package com.example.demotcs.entity.role_user;

import com.example.demotcs.Enum.ArticleStatus;
import lombok.Data;

/**
 * @Author: Salexal.fww
 * @Date: 2018/12/15 21:49
 * @Version 1.0
 * @Type
 */
@Data
public class BlogUserArticle {

    private Integer type;
    private Integer status = ArticleStatus.UP.getCode();
    private String title;
    private String articleContent;

}
