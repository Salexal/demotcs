package com.example.demotcs.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;

import java.util.List;

/**
 * @Author: Salexal.fww
 * @Date: 2018/12/11 21:18
 * @Version 1.0
 * @Type
 */
@Data
public class BlogArticleTypeVO {


    @JsonProperty("type")
    private Integer type;
    @JsonProperty("typeName")
    private String typeName;
    @JsonProperty("articleLists")
    private List<BlogArticleVO> blogArticleVOList;
}
