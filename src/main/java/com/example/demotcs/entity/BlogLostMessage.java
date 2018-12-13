package com.example.demotcs.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;

/**
 * @Author: Salexal.fww
 * @Date: 2018/12/11 20:58
 * @Version 1.0
 * @Type
 */
@Data
@Entity
public class BlogLostMessage {

    @Id
    @GeneratedValue
    private Integer id;
    private Integer articleId;
    private String authorName;
    private String message;
//    @CreatedDate
//    private Long bg_time;
//    @LastModifiedDate
//    private Long update_time;
}
