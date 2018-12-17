package com.example.demotcs.Service.impl;

import com.example.demotcs.Service.UserService;
import com.example.demotcs.entity.User;
import com.example.demotcs.entity.UserRoles;
import com.example.demotcs.repository.UserRepository;
import com.example.demotcs.repository.UserRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
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

    @Autowired
    private UserRolesRepository rolesRepository;

    @Override
    public String addUser(User user) {
        repository.save(user);
        UserRoles userRoles = new UserRoles();
        userRoles.setRolesId(21);
        userRoles.setUserId(user.getId());
        rolesRepository.save(userRoles);
        return "save successful";
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
