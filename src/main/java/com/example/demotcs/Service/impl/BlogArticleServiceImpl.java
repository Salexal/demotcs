package com.example.demotcs.Service.impl;

import com.example.demotcs.Service.BlogArticleService;
import com.example.demotcs.entity.BlogArticle;
import com.example.demotcs.repository.BlogArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        return repository.findAll();
    }

    @Override
    public List<BlogArticle> queryType(String type) {
        return repository.findByType(type);
    }

    @Override
    public List<BlogArticle> queryAuthor(String author) {
        return repository.findByAuthor(author);
    }

    @Override
    public void changeArticleStatus(Integer id) {
        BlogArticle blogArticle = (BlogArticle) repository.findById(id).get();
       
    }
}
