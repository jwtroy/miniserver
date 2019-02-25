package com.tensquare.recruit.dao;

import com.tensquare.recruit.pojo.Recruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @Auther: <a href="mailto:jiwang@gtmap.cn">jiwang</a>
 * @Version: 1.0, 2019/1/11
 * @Description:
 */
public interface RecruitDao  extends JpaRepository<Recruit,String>,JpaSpecificationExecutor<Recruit> {
    //推荐职位
    public List<Recruit> findTop6ByStateOrderByCreatetimeDesc(String state);//where

    //热门职位
    public List<Recruit> findTop6ByStateNotOrderByCreatetimeDesc(String state);
}
