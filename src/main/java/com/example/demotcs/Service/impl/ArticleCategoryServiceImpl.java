package com.example.demotcs.Service.impl;

import com.example.demotcs.Service.ArticleCategoryService;
import com.example.demotcs.entity.ArticleCategory;
import com.example.demotcs.repository.ArticleCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Salexal.fww
 * @Date: 2018/12/13 16:18
 * @Version 1.0
 * @Type
 */
@Service
public class ArticleCategoryServiceImpl implements ArticleCategoryService {

    @Autowired
    private ArticleCategoryRepository repository;

    @Override
    public ArticleCategory findOne(Integer categoryId) {
        return repository.findById(categoryId).get();
    }

    @Override
    public List<ArticleCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ArticleCategory> findByType(List<Integer> typeList) {
        return repository.findByType(typeList);
    }

    @Override
    public ArticleCategory save(ArticleCategory articleCategory) {
        return repository.save(articleCategory);
    }

}
