package com.example.demotcs.repository;

import com.example.demotcs.VO.BlogArticleVO;
import com.example.demotcs.entity.BlogArticle;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;
public interface BlogArticleRepository extends JpaRepository<BlogArticle,Integer> {

    @Transactional
    List<BlogArticle> findByAuthor(String author);

    @Transactional
    List<BlogArticle> findByType(Integer type);

    List<BlogArticle> findByStatus(Integer Status);
}
