package com.example.demotcs.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class User {
    @Id
    private Integer id;
    private String userName;
    private String password;
    private String userIcon;
}
