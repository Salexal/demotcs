package com.example.demotcs.repository;

import com.example.demotcs.entity.Authority;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: Salexal.fww
 * @Date: 2018/12/14 11:08
 * @Version 1.0
 * @Type
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthorityTest {

    @Autowired
    private AuthorityRepository repository;

    @Test
    public void save(){
        Authority authority = new Authority();
        authority.setUsername("admin");
        authority.setRoles("admin");
        repository.save(authority);
    }

}