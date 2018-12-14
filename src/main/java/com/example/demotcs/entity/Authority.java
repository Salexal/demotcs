package com.example.demotcs.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Author: Salexal.fww
 * @Date: 2018/12/14 11:04
 * @Version 1.0
 * @Type
 */

@Entity
@Data
public class Authority {
    @Id
    @GeneratedValue
    private Integer id;
    private String username;
    private String roles;
}
