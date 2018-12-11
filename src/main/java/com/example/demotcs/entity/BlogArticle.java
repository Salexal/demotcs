package com.example.demotcs.entity;

import com.example.demotcs.Enum.ArticleStatus;
import lombok.Data;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
@Data
public class BlogArticle {

    @Id
    @GeneratedValue
    private Integer id;
    private String type;
    private Integer status = ArticleStatus.UP.getCode();
    private String title;
    private String author;
    private String articleContent;
    private String lostMsg;

}
