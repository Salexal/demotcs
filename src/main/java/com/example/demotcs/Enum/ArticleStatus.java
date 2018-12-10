package com.example.demotcs.Enum;

import lombok.Getter;

@Getter
public enum ArticleStatus implements CodeEnum{

    UP(0,"发表"),
    DOWN(1,"垃圾桶")
    ;

    private Integer code;
    private String msg;

    ArticleStatus(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    @Override
    public Integer getCode() {
        return code;
    }
}
