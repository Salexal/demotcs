package com.example.demotcs.entity;

import lombok.Data;
import org.springframework.stereotype.Controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author: Salexal.fww
 * @Date: 2018/12/16 14:42
 * @Version 1.0
 * @Type
 */
@Data
@Entity
@Table(name = "user_roles")
public class UserRoles {

    @Id
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "roles_id")
    private Integer rolesId;

}
