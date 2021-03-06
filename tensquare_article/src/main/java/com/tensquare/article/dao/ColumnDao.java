package com.tensquare.article.dao;

import com.tensquare.article.pojo.Column;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Auther: <a href="mailto:jiwang@gtmap.cn">jiwang</a>
 * @Version: 1.0, 2019/1/14
 * @Description:
 */
public interface ColumnDao extends JpaRepository<Column,String>,JpaSpecificationExecutor<Column> {
}
