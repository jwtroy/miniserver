package com.tensquare.spit.dao;

import com.tensquare.spit.pojo.Spit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Auther: <a href="mailto:jiwang@gtmap.cn">jiwang</a>
 * @Version: 1.0, 2019/1/16
 * @Description:
 */
public interface SpitDao extends MongoRepository<Spit,String>{
    Page<Spit> findByParentid(String parentid, Pageable pageable);
}
