package com.example.demotcs.Service.impl;

import com.example.demotcs.Service.BlogLostMessageService;
import com.example.demotcs.entity.BlogLostMessage;
import com.example.demotcs.repository.BlogLostMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author: Salexal.fww
 * @Date: 2018/12/13 18:30
 * @Version 1.0
 * @Type
 */
public class BlogLostMessageServiceImpl implements BlogLostMessageService {

    @Autowired
    private BlogLostMessageRepository repository;

    @Override
    public List<BlogLostMessage> findByArticleId(Integer id) {
        return repository.findByArticleId(id);
    }
}
