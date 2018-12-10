package com.example.demotcs.Service.impl;

import com.example.demotcs.Service.UserService;
import com.example.demotcs.entity.User;
import com.example.demotcs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Salexal.fww
 * @Date: 2018/12/10 20:27
 * @Version 1.0
 * @Type
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User addUser(User user) {
        return repository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        repository.deleteById(id);
        System.out.println("delete success");
    }

    @Override
    public List<User> queryAll() {
        return repository.findAll();
    }

    @Override
    public User queryByUserName(String userName) {
        return repository.findByUserName(userName);
    }


}
