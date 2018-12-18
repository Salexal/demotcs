package com.example.demotcs.repository;

import com.example.demotcs.entity.ArticleCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @Author: Salexal.fww
 * @Date: 2018/12/13 16:14
 * @Version 1.0
 * @Type
 */
public interface ArticleCategoryRepository extends JpaRepository<ArticleCategory,Integer> {

    List<ArticleCategory> findByType(List<Integer> typeList);


}
