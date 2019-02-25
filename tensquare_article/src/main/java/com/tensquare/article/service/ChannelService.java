package com.tensquare.article.service;

import com.tensquare.article.dao.ArticleDao;
import com.tensquare.article.dao.ChannelDao;
import com.tensquare.article.pojo.Article;
import com.tensquare.article.pojo.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.List;

/**
 * @Auther: <a href="mailto:jiwang@gtmap.cn">jiwang</a>
 * @Version: 1.0, 2019/1/14
 * @Description:
 */
@Service
public class ChannelService {

    @Autowired
    private ChannelDao channelDao;
    @Autowired
    private IdWorker idWorker;

    //增删改查
    public List<Channel> findAll(){
        return channelDao.findAll();
    }
    public Channel findById(String id){
        return channelDao.findById(id).get();
    }
    public void save(Channel channel){
        channel.setId(idWorker.nextId()+"");
        channelDao.save(channel);
    }
    public void update(Channel channel){
        channelDao.save(channel);
    }
    public void deleteById(String id){
        channelDao.deleteById(id);
    }

}
