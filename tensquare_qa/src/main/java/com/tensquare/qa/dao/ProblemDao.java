package com.tensquare.qa.dao;

import com.tensquare.qa.pojo.Problem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface ProblemDao extends JpaRepository<Problem,String>,JpaSpecificationExecutor<Problem>{

    @Query(value = "select * from tensquare_qa.tb_problem t1 left join (tensquare_qa.tb_pl t2) on (t1.id = t2.problemid) where t2.labelid = ? order by t1.replytime DESC ",nativeQuery = true)
    public Page<Problem> newlist(String labelid, Pageable pageable);

    @Query(value = "select * from tensquare_qa.tb_problem t1 left join tensquare_qa.tb_pl t2\n" +
            "on t1.id = t2.problemid where t2.labelid = ? order by t1.reply DESC ",nativeQuery = true)
    public Page<Problem> hotlist(String labelid, Pageable pageable);

    @Query(value = "select * from tensquare_qa.tb_problem t1 left join tensquare_qa.tb_pl t2\n" +
            "on t1.id = t2.problemid where t2.labelid = ? and t1.reply = 0 order by t1.replytime",nativeQuery = true)
    public Page<Problem> waitlist(String labelid, Pageable pageable);
	
}
