package com.example.demotcs.Controller;

import com.example.demotcs.Service.ArticleCategoryService;
import com.example.demotcs.Service.BlogArticleService;
import com.example.demotcs.Service.UserService;
import com.example.demotcs.VO.BlogArticleMessageInfoVO;
import com.example.demotcs.VO.BlogArticleTypeVO;
import com.example.demotcs.VO.BlogArticleVO;

import com.example.demotcs.VO.ResultVO;
import com.example.demotcs.entity.*;
import com.example.demotcs.repository.BlogLostMessageRepository;
import com.example.demotcs.repository.UserRepository;
import com.example.demotcs.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: Salexal.fww
 * @Date: 2018/12/10 21:06
 * @Version 1.0
 * @Type
 */

@RestController
@RequestMapping("all")
public class BlogArticleController {

    @Autowired
    private BlogArticleService service;

    @Autowired
    private UserService userService;

    @Autowired
    private ArticleCategoryService articleCategoryService;

    @Autowired
    private BlogLostMessageRepository blogLostMessageRepository;

    @RequestMapping("findByAuthorArticle")
    public List<BlogArticle> findByAuthor(String author){
        return service.queryAuthor(author);
    }

    @RequestMapping("findByTypeArticle")
    public BlogArticleTypeVO findByType(Integer type){
        List<ArticleCategory> articleCategoryList = articleCategoryService.findAll();
        BlogArticleTypeVO blogArticleTypeVO = new BlogArticleTypeVO();
        for(ArticleCategory articleCategory:articleCategoryList){
            if(articleCategory.getType()==type){
                blogArticleTypeVO.setTypeName(articleCategory.getTypeName());
                break;
            }
        }
        List<BlogArticle> blogArticleList = service.queryType(type);
        List<BlogArticleVO> blogArticleVOList = new ArrayList<>();
        for(BlogArticle blogArticle:blogArticleList){

                BlogArticleVO blogArticleVO = new BlogArticleVO();
                blogArticleVO.setArticleContent(blogArticle.getArticleContent());
                blogArticleVO.setAuthor(blogArticle.getAuthor());
                blogArticleVO.setType(type);

                List<BlogLostMessage> blogLostMessageList = blogLostMessageRepository.findByArticleId(blogArticle.getId());
                List<BlogArticleMessageInfoVO> blogArticleMessageInfoVOList = new ArrayList<>();
                for(BlogLostMessage blogLostMessage:blogLostMessageList){
                    BlogArticleMessageInfoVO messageInfoVO = new BlogArticleMessageInfoVO();
                    messageInfoVO.setMessage(blogLostMessage.getMessage());
                    messageInfoVO.setAuthor(blogArticle.getAuthor());
                    blogArticleMessageInfoVOList.add(messageInfoVO);
                }
                blogArticleVO.setLostMessage(blogArticleMessageInfoVOList);
                blogArticleVOList.add(blogArticleVO);

        }
        blogArticleTypeVO.setBlogArticleVOList(blogArticleVOList);
        blogArticleTypeVO.setType(type);

        return blogArticleTypeVO;
    }

    @RequestMapping("findByName")
    public User findByName(String userName){
        return userService.queryByUserName(userName);
    }

    @RequestMapping("list")
    public ResultVO List(){
        /** 获取所有不在垃圾箱的文章 */
        List<BlogArticle> blogArticleList = service.queryAll();
        List<ArticleCategory> articleCategoryList = articleCategoryService.findAll();

        List<BlogArticleTypeVO> blogArticleTypeVOList = new ArrayList<>();
        for(ArticleCategory articleCategory:articleCategoryList){

            BlogArticleTypeVO blogArticleTypeVO = new BlogArticleTypeVO();
            blogArticleTypeVO.setType(articleCategory.getType());
            blogArticleTypeVO.setTypeName(articleCategory.getTypeName());

            List<BlogArticleVO> blogArticleVOList = new ArrayList<>();
            for(BlogArticle blogArticle:blogArticleList){

                if(blogArticle.getType().equals(articleCategory.getType())){
                    BlogArticleVO blogArticleVO = new BlogArticleVO();
                    BeanUtils.copyProperties(blogArticle,blogArticleVO);

                    List<BlogLostMessage> blogArticleMessageList = blogLostMessageRepository.findByArticleId(blogArticle.getId());
                    List<BlogArticleMessageInfoVO> blogArticleMessageInfoVOList = new ArrayList<>();

                    for(BlogLostMessage blogLostMessage:blogArticleMessageList){

                        BlogArticleMessageInfoVO messageInfoVO = new BlogArticleMessageInfoVO();
                        messageInfoVO.setAuthor(blogLostMessage.getAuthorName());
                        messageInfoVO.setMessage(blogLostMessage.getMessage());

                        blogArticleMessageInfoVOList.add(messageInfoVO);
                    }
                   blogArticleVO.setLostMessage(blogArticleMessageInfoVOList);
                   blogArticleVOList.add(blogArticleVO);
                }
            }
            blogArticleTypeVO.setBlogArticleVOList(blogArticleVOList);
            blogArticleTypeVOList.add(blogArticleTypeVO);
        }
        return ResultVOUtil.success(blogArticleTypeVOList);
    }


}
