package com.example.demotcs.Controller;

import com.example.demotcs.Service.BlogArticleService;
import com.example.demotcs.Service.BlogLostMessageService;
import com.example.demotcs.entity.BlogArticle;
import com.example.demotcs.entity.BlogLostMessage;
import com.example.demotcs.entity.role_user.BlogUserArticle;
import com.example.demotcs.entity.role_user.UserLostMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Salexal.fww
 * @Date: 2018/12/17 12:12
 * @Version 1.0
 * @Type
 */
@RequestMapping("role_user")
@RestController
public class BlogUserController {

    @Autowired
    private BlogArticleService service;

    @Autowired
    private BlogLostMessageService blogLostMessageService;

    @RequestMapping("saveUserArticle")
    public BlogArticle saveUserArticle(BlogUserArticle blogUserArticle){
        return service.saveUserArticle(blogUserArticle);
    }

    @RequestMapping("saveUserLostMessage")
    public BlogLostMessage saveUserLostMessage(UserLostMessage message){
        return blogLostMessageService.saveUserLostMessage(message);
    }

}
