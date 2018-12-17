package com.example.demotcs.Service.impl;

import com.example.demotcs.Service.BlogLostMessageService;
import com.example.demotcs.entity.BlogLostMessage;
import com.example.demotcs.entity.role_user.UserLostMessage;
import com.example.demotcs.repository.BlogLostMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Salexal.fww
 * @Date: 2018/12/13 18:30
 * @Version 1.0
 * @Type
 */
@Service
public class BlogLostMessageServiceImpl implements BlogLostMessageService {

    @Autowired
    private BlogLostMessageRepository repository;

    @Override
    public List<BlogLostMessage> findByArticleId(Integer id) {
        return repository.findByArticleId(id);
    }

    @Override
    public BlogLostMessage save(BlogLostMessage message) {
        return repository.save(message);
    }

    @Override
    public BlogLostMessage saveUserLostMessage(UserLostMessage message) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        BlogLostMessage lostMessage = new BlogLostMessage();
        lostMessage.setMessage(message.getMessage());
        lostMessage.setArticleId(message.getArticleId());
        lostMessage.setAuthorName(authentication.getName());
        return repository.save(lostMessage);
    }
}
