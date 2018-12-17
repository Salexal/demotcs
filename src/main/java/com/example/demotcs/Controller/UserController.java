package com.example.demotcs.Controller;

import com.example.demotcs.Service.UserService;
import com.example.demotcs.entity.User;
import com.example.demotcs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Salexal.fww
 * @Date: 2018/12/10 20:54
 * @Version 1.0
 * @Type
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("saveUser")
    public String save(User user){
        return userService.addUser(user);
    }
    @RequestMapping("queryAll")
    public List<User> findAll(){
        return userService.queryAll();
    }


}
