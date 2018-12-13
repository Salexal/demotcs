package com.example.demotcs.Service;

import com.example.demotcs.entity.ArticleCategory;

import java.util.List;

/**
 * @Author: Salexal.fww
 * @Date: 2018/12/13 16:16
 * @Version 1.0
 * @Type
 */
public interface ArticleCategoryService {

    ArticleCategory findOne(Integer categoryId);

    List<ArticleCategory> findAll();

    List<ArticleCategory> findByType(List<Integer> typeList);

    ArticleCategory save(ArticleCategory articleCategory);



}
