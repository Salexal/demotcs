package com.example.demotcs.repository;

import com.example.demotcs.entity.Authority;
import com.example.demotcs.entity.User;
import com.example.demotcs.entity.UserRoles;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

import java.util.List;

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

    @Autowired
    private UserRolesRepository rolesRepository;

    @Test
    public void saveTest(){
        User user = new User();
        user.setUserName("magic");
        user.setPassword("111111");
        user.setUserIcon("http://xxxxxx.jpg");
        repository.save(user);
        UserRoles userRoles = new UserRoles();
        userRoles.setRolesId(21);
        userRoles.setUserId(user.getId());
        rolesRepository.save(userRoles);
    }
    @Test
    public void find(){
        User user = repository.findByUserName("Salexal");
        System.out.println(user.getUsername());
        Assert.assertNotNull(user);
    }
}