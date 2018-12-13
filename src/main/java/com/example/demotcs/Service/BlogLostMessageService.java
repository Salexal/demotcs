package com.example.demotcs.Service;

import com.example.demotcs.entity.BlogLostMessage;

import java.util.List;

/**
 * @Author: Salexal.fww
 * @Date: 2018/12/13 18:28
 * @Version 1.0
 * @Type
 */
public interface BlogLostMessageService {

    public List<BlogLostMessage> findByArticleId(Integer id);


}
