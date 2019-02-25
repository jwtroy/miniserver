package com.tensquare.search.dao;

import com.tensquare.search.pojo.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @Auther: <a href="mailto:jiwang@gtmap.cn">jiwang</a>
 * @Version: 1.0, 2019/1/20
 * @Description:
 */
public interface ArticleDao extends ElasticsearchRepository<Article,String>{
    public Page<Article> findByTitleOrContentLike(String title, String content, Pageable pageable);

}
