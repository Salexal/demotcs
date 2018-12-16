package com.example.demotcs.repository;

import com.example.demotcs.entity.BlogArticle;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author: Salexal.fww
 * @Date: 2018/12/11 20:38
 * @Version 1.0
 * @Type
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogArticleRepositoryTest {

    @Autowired
    private BlogArticleRepository repository;

    @Test
    public void save(){
        BlogArticle article = new BlogArticle();
        article.setStatus(0);
        article.setArticleContent("say fww zs");
        article.setAuthor("cdx");
        article.setType(33);
//        article.setId(123);
        article.setTitle("cdxcdx");
        repository.save(article);

    }
    @Test
    public void delete(){
        repository.deleteById(9);
    }

    @Test
    public void findByAuthor() {
    }

    @Test
    public void findByType() {
    }
}