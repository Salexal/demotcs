package com.example.demotcs.entity;

import com.example.demotcs.Enum.ArticleStatus;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
@Data
public class BolgArticle {

    @Id
    private Integer id;
    private Integer status = ArticleStatus.UP.getCode();
    private String title;
    private String author;
    private String articleContent;
    private List<String> lostMsg;

}
