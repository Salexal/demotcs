package com.example.demotcs.repository;

import com.example.demotcs.entity.BlogLostMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author: Salexal.fww
 * @Date: 2018/12/13 21:21
 * @Version 1.0
 * @Type
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogLostMessageRepositoryTest {

    @Autowired
    private BlogLostMessageRepository repository;

    @Test
    public void save(){
        BlogLostMessage message = new BlogLostMessage();
        message.setArticleId(5);
        message.setAuthorName("Salexal");
        message.setMessage("我也是这么认为的");

        repository.save(message);
    }
}