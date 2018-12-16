package com.example.demotcs.Service.impl;

import com.example.demotcs.Enum.ArticleStatus;
import com.example.demotcs.Service.BlogArticleService;
import com.example.demotcs.entity.BlogArticle;
import com.example.demotcs.entity.BlogUserArticle;
import com.example.demotcs.entity.User;
import com.example.demotcs.repository.BlogArticleRepository;
import com.example.demotcs.utils.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Salexal.fww
 * @Date: 2018/12/10 20:39
 * @Version 1.0
 * @Type
 */
@Service
public class BlogArticleServiceImpl implements BlogArticleService {

    @Autowired
    private BlogArticleRepository repository;

    @Override
    public BlogArticle saveUserArticle(BlogUserArticle blogUserArticle) {
        BlogArticle blogArticle = new BlogArticle();
        blogArticle.setTitle(blogUserArticle.getTitle());
//        String username = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        blogArticle.setAuthor(authentication.getName());
        blogArticle.setType(blogUserArticle.getType());
        blogArticle.setArticleContent(blogUserArticle.getArticleContent());
        return repository.save(blogArticle);
    }

    @Override
    public BlogArticle save(BlogArticle article) {
        return repository.save(article);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
        System.out.println("delete success");
    }

    @Override
    public BlogArticle query(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public List<BlogArticle> queryAll() {
        return repository.findByStatus(ArticleStatus.UP.getCode());
    }

    @Override
    public List<BlogArticle> queryType(Integer type) {
        return repository.findByType(type);
    }

    @Override
    public List<BlogArticle> queryAuthor(String author) {
        return repository.findByAuthor(author);
    }

    @Override
    public void changeArticleStatus(Integer id) {
        BlogArticle blogArticle =  repository.findById(id).get();
        if(blogArticle.getStatus()==0)
            blogArticle.setStatus(ArticleStatus.DOWN.getCode());
        else
            blogArticle.setStatus(ArticleStatus.UP.getCode());
         repository.save(blogArticle);
    }
}
