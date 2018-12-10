package com.example.demotcs.repository;

import com.example.demotcs.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Integer>{

    User findByUserName(String userName);
}
