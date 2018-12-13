package com.example.demotcs.Service;

import com.example.demotcs.entity.BlogArticle;

import java.util.List;

/**
 * @Author: Salexal.fww
 * @Date: 2018/12/10 20:34
 * @Version 1.0
 * @Type
 */
public interface BlogArticleService {

    /** 増 */    /** 改 */
    public BlogArticle save(BlogArticle article);

    /** 删 */
    public void delete(Integer id);

    /** 查 */
    public BlogArticle query(Integer id);

    /** 查all */
    public List<BlogArticle> queryAll();

    /** 查类别*/
    public List<BlogArticle> queryType(Integer type);

    /** 查类别*/
    public List<BlogArticle> queryAuthor(String author);

    public void changeArticleStatus(Integer id);

}
