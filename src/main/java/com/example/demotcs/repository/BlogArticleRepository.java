package com.example.demotcs.repository;

import com.example.demotcs.entity.BlogArticle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface BlogArticleRepository extends JpaRepository<BlogArticle,Integer> {

    List<BlogArticle> findByAuthor(String author);
    List<BlogArticle> findByType(String type);
}
