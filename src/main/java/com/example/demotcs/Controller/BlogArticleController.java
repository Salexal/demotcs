package com.example.demotcs.Controller;

import com.example.demotcs.Service.ArticleCategoryService;
import com.example.demotcs.Service.BlogArticleService;
import com.example.demotcs.VO.BlogArticleMessageInfoVO;
import com.example.demotcs.VO.BlogArticleTypeVO;
import com.example.demotcs.VO.BlogArticleVO;

import com.example.demotcs.VO.ResultVO;
import com.example.demotcs.entity.ArticleCategory;
import com.example.demotcs.entity.BlogArticle;
import com.example.demotcs.entity.BlogLostMessage;
import com.example.demotcs.repository.BlogLostMessageRepository;
import com.example.demotcs.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
public class BlogArticleController {

    @Autowired
    private BlogArticleService service;

    @Autowired
    private ArticleCategoryService articleCategoryService;

    @Autowired
    private BlogLostMessageRepository blogLostMessageRepository;

    @RequestMapping("saveArticle")
    public BlogArticle save(BlogArticle blogArticle){
        return service.save(blogArticle);
    }

    @RequestMapping("findByAuthorArticle")
    public List<BlogArticle> findByAuthor(String author){
        return service.queryAuthor(author);

    }
    @RequestMapping("findByTypeArticle")
    public List<BlogArticle> findByType(Integer type){
        return service.queryType(type);
    }

    /** 放入或取出垃圾桶*/
    @RequestMapping("changeArticleStatus")
    public void trash(Integer id) {
        service.changeArticleStatus(id);
    }


    @RequestMapping("list")
    public ResultVO List(){
        /** 获取所有不在垃圾箱的文章 */
        List<BlogArticle> blogArticleList = service.queryAll();

////        2. 查询类目(一次性查询)
//        List<Integer> categoryTypeList = new ArrayList<>();
////        传统方法
//        for (BlogArticle productInfo : blogArticleList) {
//            categoryTypeList.add(productInfo.getType());
//        }
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
