package com.example.demotcs.repository;

import com.example.demotcs.entity.BolgArticle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BolgArticleRepository extends JpaRepository<BolgArticle,Integer> {

    List<BolgArticle> findByAuthor(String author);

}
