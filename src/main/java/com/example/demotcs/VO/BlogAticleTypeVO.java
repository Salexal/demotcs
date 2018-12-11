package com.example.demotcs.VO;

import lombok.Getter;

import java.util.List;

/**
 * @Author: Salexal.fww
 * @Date: 2018/12/11 21:18
 * @Version 1.0
 * @Type
 */
@Getter
public class BlogAticleTypeVO {

    private Integer id;
    private String type;
    private List<BlogArticleVO> blogArticleVOList;
}
