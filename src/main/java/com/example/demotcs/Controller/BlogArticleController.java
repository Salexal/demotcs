package com.example.demotcs.Controller;

import com.example.demotcs.Service.BlogArticleService;
import com.example.demotcs.entity.BlogArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    /** 放入垃圾桶*/
    public void trash(Integer id){

    }

}
