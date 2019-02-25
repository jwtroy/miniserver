package com.tensquare.recruit.service;

import com.tensquare.recruit.dao.RecruitDao;
import com.tensquare.recruit.pojo.Enterprise;
import com.tensquare.recruit.pojo.Recruit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.List;

/**
 * @Auther: <a href="mailto:jiwang@gtmap.cn">jiwang</a>
 * @Version: 1.0, 2019/1/12
 * @Description:
 */
@Service
public class RecruitService {

    @Autowired
    private RecruitDao recruitDao;

    @Autowired
    private IdWorker idWorker;

    public List<Recruit> recommend(){
        return recruitDao.findTop6ByStateOrderByCreatetimeDesc("2");
    }
    public List<Recruit> newlist(){
        return recruitDao.findTop6ByStateNotOrderByCreatetimeDesc("0");
    }

    public List<Recruit> findAll(){
        return recruitDao.findAll();
    }
    public Recruit findById(String id){
        return recruitDao.findById(id).get();
    }
    public void save(Recruit label){
        label.setId(idWorker.nextId()+"");
        recruitDao.save(label);
    }
    public void update(Recruit label){
        recruitDao.save(label);
    }
    public void deleteById(String id){
        recruitDao.deleteById(id);
    }

}
