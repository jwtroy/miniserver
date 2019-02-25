package com.tensquare.recruit.service;

import com.tensquare.recruit.dao.EnterpriseDao;
import com.tensquare.recruit.pojo.Enterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.List;

/**
 * @Auther: <a href="mailto:jiwang@gtmap.cn">jiwang</a>
 * @Version: 1.0, 2019/1/11
 * @Description:
 */
@Service
public class EnterpriseService {
    @Autowired
    private EnterpriseDao enterpriseDao;
    @Autowired
    private IdWorker idWorker;

    /**
        *@Author: jiwang
        *@Date: 22:34 2019/1/12
        *@Param: [ishot]
        *@return: java.util.List<com.tensquare.recruit.pojo.Enterprise>
        *@Description:热门列表
        **/
    public List<Enterprise> hotList(String ishot){
        return enterpriseDao.findByIshot(ishot);
    }

    public List<Enterprise> findAll(){
        return enterpriseDao.findAll();
    }
    public Enterprise findById(String id){
        return enterpriseDao.findById(id).get();
    }
    public void save(Enterprise enterprise){
        enterprise.setId(idWorker.nextId()+"");
        enterpriseDao.save(enterprise);
    }
    public void update(Enterprise enterprise){
        enterpriseDao.save(enterprise);
    }
    public void deleteById(String id){
        enterpriseDao.deleteById(id);
    }
}
