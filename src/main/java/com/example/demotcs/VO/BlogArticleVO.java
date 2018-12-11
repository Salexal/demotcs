package com.example.demotcs.VO;

import lombok.Getter;

import java.util.List;

/**
 * @Author: Salexal.fww
 * @Date: 2018/12/11 21:15
 * @Version 1.0
 * @Type
 */
@Getter
public class BlogArticleVO {

    private Integer id;
    private String type;
    private String author;
    private String articleValue;
    private List<BlogArticleMessageInfoVO> lostMessage;

}
