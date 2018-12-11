package com.example.demotcs.Controller;

import com.example.demotcs.Service.BlogArticleService;
import com.example.demotcs.VO.ResultVO;
import com.example.demotcs.entity.BlogArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("save_article")
    public BlogArticle save(BlogArticle blogArticle){
        return service.save(blogArticle);
    }
    @RequestMapping("findByAuthor_article")
    public List<BlogArticle> findByAuthor(String author){
        return service.queryAuthor(author);

    }
    @RequestMapping("findByAuthor_article")
    public List<BlogArticle> findByType(String type){
        return service.queryType(type);
    }
    @RequestMapping("change_articleStatus")
    /** 放入或取出垃圾桶*/
    public void trash(Integer id) {
        service.changeArticleStatus(id);
    }
    @RequestMapping("list")
    public ResultVO List(){

        
        return null;
    }
}
