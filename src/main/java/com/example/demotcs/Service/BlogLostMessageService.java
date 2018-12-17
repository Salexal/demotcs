package com.example.demotcs.Service;

import com.example.demotcs.entity.BlogLostMessage;
import com.example.demotcs.entity.role_user.UserLostMessage;

import java.util.List;

/**
 * @Author: Salexal.fww
 * @Date: 2018/12/13 18:28
 * @Version 1.0
 * @Type
 */
public interface BlogLostMessageService {

    public List<BlogLostMessage> findByArticleId(Integer id);

    public BlogLostMessage save(BlogLostMessage message);

    public BlogLostMessage saveUserLostMessage(UserLostMessage message);
}
