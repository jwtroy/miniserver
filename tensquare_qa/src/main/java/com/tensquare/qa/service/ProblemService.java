package com.tensquare.qa.service;

import com.tensquare.qa.dao.ProblemDao;
import com.tensquare.qa.pojo.Problem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.List;

/**
 * @Auther: <a href="mailto:jiwang@gtmap.cn">jiwang</a>
 * @Version: 1.0, 2019/1/13
 * @Description:
 */
@Service
public class ProblemService {

    @Autowired
    private ProblemDao problemDao;
    @Autowired
    private IdWorker idWorker;

    /**
        *@Author: jiwang
        *@Date: 19:27 2019/1/13
        *@Param: [labelid, page, rows]
        *@return: org.springframework.data.domain.Page<com.tensquare.qa.pojo.Problem>
        *@Description:热门问题列表
        **/
    public Page<Problem> hotlist(String labelid, int page, int rows){
        Pageable pageable = PageRequest.of(page-1,rows);
        return problemDao.hotlist(labelid,pageable);
    }
    /**
        *@Author: jiwang
        *@Date: 19:28 2019/1/13
        *@Param: [labelid, page, rows]
        *@return: org.springframework.data.domain.Page<com.tensquare.qa.pojo.Problem>
        *@Description:等待回答问题
        **/
    public Page<Problem> waitlist(String labelid, int page, int rows){
        Pageable pageable = PageRequest.of(page-1,rows);
        return problemDao.waitlist(labelid,pageable);
    }
    /**
        *@Author: jiwang
        *@Date: 19:28 2019/1/13
        *@Param: [labelid, page, rows]
        *@return: org.springframework.data.domain.Page<com.tensquare.qa.pojo.Problem>
        *@Description:最新问题列表
        **/
    public Page<Problem> newlist(String labelid, int page, int rows){
        Pageable pageable = PageRequest.of(page-1,rows);
        return problemDao.newlist(labelid,pageable);
    }

    //增删改查
    public List<Problem> findAll(){
        return problemDao.findAll();
    }
    public Problem findById(String id){
        return problemDao.findById(id).get();
    }
    public void save(Problem label){
        label.setId(idWorker.nextId()+"");
        problemDao.save(label);
    }
    public void update(Problem label){
        problemDao.save(label);
    }
    public void deleteById(String id){
        problemDao.deleteById(id);
    }
}
