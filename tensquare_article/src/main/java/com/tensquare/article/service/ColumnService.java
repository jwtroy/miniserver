package com.tensquare.article.service;

import com.tensquare.article.dao.ChannelDao;
import com.tensquare.article.dao.ColumnDao;
import com.tensquare.article.pojo.Channel;
import com.tensquare.article.pojo.Column;
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
public class ColumnService {

    @Autowired
    private ColumnDao columnDao;
    @Autowired
    private IdWorker idWorker;

    //增删改查
    public List<Column> findAll(){
        return columnDao.findAll();
    }
    public Column findById(String id){
        return columnDao.findById(id).get();
    }
    public void save(Column column){
        column.setId(idWorker.nextId()+"");
        columnDao.save(column);
    }
    public void update(Column column){
        columnDao.save(column);
    }
    public void deleteById(String id){
        columnDao.deleteById(id);
    }
}
