package com.example.demotcs.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;

/**
 * @Author: Salexal.fww
 * @Date: 2018/12/13 16:11
 * @Version 1.0
 * @Type
 */
@Entity
@Data
public class ArticleCategory {

    @Id
    @GeneratedValue
    private Integer id;
    private Integer type;
    private String typeName;
}
