package com.example.demotcs.repository;

import com.example.demotcs.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

import static org.junit.Assert.*;

/**
 * @Author: Salexal.fww
 * @Date: 2018/12/10 20:48
 * @Version 1.0
 * @Type
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Test
    public void saveTest(){
        User user = new User();
        user.setUserName("lemon");
        user.setPassword("fwwsmy");
        user.setUserIcon("http://xxxxxx.jpg");
        repository.save(user);

    }

}