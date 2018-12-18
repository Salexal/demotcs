package com.example.demotcs.Controller;

import com.example.demotcs.Service.ArticleCategoryService;
import com.example.demotcs.Service.BlogArticleService;
import com.example.demotcs.entity.BlogArticle;
import com.example.demotcs.repository.BlogLostMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Salexal.fww
 * @Date: 2018/12/17 12:14
 * @Version 1.0
 * @Type
 */
@RequestMapping("role_admin")
@RestController
public class BlogAdminController {

    @Autowired
    private BlogArticleService service;

    @RequestMapping("saveArticle")
    public BlogArticle save(BlogArticle blogArticle){
        return service.save(blogArticle);
    }

    /** 放入或取出垃圾桶*/
    @RequestMapping("changeArticleStatus")
    public BlogArticle trash(Integer id) {
        service.changeArticleStatus(id);
        return service.query(id);
    }

}
