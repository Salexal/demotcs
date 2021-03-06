package com.example.demotcs.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;

import java.util.List;

/**
 * @Author: Salexal.fww
 * @Date: 2018/12/11 21:15
 * @Version 1.0
 * @Type
 */
@Data
public class BlogArticleVO {

    @JsonProperty("type")
    private Integer type;

    @JsonProperty("author")
    private String author;
    @JsonProperty("text")
    private String articleContent;
    @JsonProperty("lostMessages")
    private List<BlogArticleMessageInfoVO> lostMessage;

}
