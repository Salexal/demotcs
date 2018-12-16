package com.example.demotcs.repository;

import com.example.demotcs.entity.BlogLostMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: Salexal.fww
 * @Date: 2018/12/11 21:02
 * @Version 1.0
 * @Type
 */
public interface BlogLostMessageRepository extends JpaRepository<BlogLostMessage,Integer> {
        List<BlogLostMessage>  findByArticleId(Integer id);
}
