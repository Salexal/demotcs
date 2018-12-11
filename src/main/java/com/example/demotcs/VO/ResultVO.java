package com.example.demotcs.VO;

import lombok.Getter;

/**
 * @Author: Salexal.fww
 * @Date: 2018/12/11 21:20
 * @Version 1.0
 * @Type
 */
@Getter
public class ResultVO<T> {

    private Integer code;
    private String msg;
    private T data;

}
