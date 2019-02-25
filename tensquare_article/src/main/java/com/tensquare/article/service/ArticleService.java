package com.tensquare.article.service;

import com.tensquare.article.dao.ArticleDao;
import com.tensquare.article.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import java.util.List;

/**
 * @Auther: <a href="mailto:jiwang@gtmap.cn">jiwang</a>
 * @Version: 1.0, 2019/1/14
 * @Description:
 */
@Service
@Transactional
public class ArticleService {
    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private RedisTemplate redisTemplate;

    public void updateState(String id){
        articleDao.updateState(id);
    }

    public void updateThumbup(String id){
        articleDao.updateThumbup(id);
    }

    //增删改查
    public List<Article> findAll(){
        return articleDao.findAll();
    }

    public Article findById(String id){
        //先从缓存中查询当前对象
        Article article = (Article) redisTemplate.opsForValue().get("article_"+id);
        if (article == null){
            article = articleDao.findById(id).get();
            redisTemplate.opsForValue().set("article_"+id,article);
        }
        return article;
    }
    public void save(Article article){
        article.setId(idWorker.nextId()+"");
        articleDao.save(article);
    }
    public void update(Article article){
        redisTemplate.delete("article_"+article.getId());
        articleDao.save(article);
    }
    public void deleteById(String id){
        redisTemplate.delete("article_"+id);
        articleDao.deleteById(id);
    }
}
