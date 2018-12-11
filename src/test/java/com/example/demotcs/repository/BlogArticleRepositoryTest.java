package com.example.demotcs.repository;

import com.example.demotcs.entity.BlogArticle;
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
        article.setArticleContent("fwwhaoshuai a ");
        article.setAuthor("Salexal");
        article.setLostMsg("文章好酷");
        article.setTitle("第一次的结果");
    }

    @Test
    public void findByAuthor() {
    }

    @Test
    public void findByType() {
    }
}