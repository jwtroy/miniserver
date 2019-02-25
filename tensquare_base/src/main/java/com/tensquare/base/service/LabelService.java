package com.tensquare.base.service;

import com.tensquare.base.dao.LabelDao;
import com.tensquare.base.pojo.Label;
import util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: <a href="mailto:jiwang@gtmap.cn">jiwang</a>
 * @Version: 1.0, 2019/1/10
 * @Description:
 */
@Service
@Transactional
public class LabelService {
    @Autowired
    private LabelDao labelDao;
    @Autowired
    private IdWorker idWorker;

    public List<Label> findAll(){
        return labelDao.findAll();
    }
    public Label findById(String id){
        return labelDao.findById(id).get();
    }
    public void save(Label label){
        label.setId(idWorker.nextId()+"");
        labelDao.save(label);
    }
    public void update(Label label){
        labelDao.save(label);
    }
    public void deleteById(String id){
        labelDao.deleteById(id);
    }

    public List<Label> findSearch(Label label) {
        return labelDao.findAll(new Specification<Label>() {
            /**
                *@Author: jiwang
                *@Date: 23:22 2019/1/10
                *@Param: [root 根对象，也就是要把条件封装到哪个对象中 where 类名 = label.getId
                * , query 封装的是查询的关键字, cb 用来封装条件对象 如果直接返回null 表示不需要条件]
                *@return: javax.persistence.criteria.Predicate
                *@Description:
                **/
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                //new一个集合 来存放条件
                List<Predicate> list = new ArrayList<>();
                if (label.getLabelname() != null && !"".equals(label.getLabelname())) {
                    Predicate predicate = cb.like(root.get("labelname").as(String.class), "%" + label.getLabelname() + "%");//where labelname like labelname
                    list.add(predicate);
                }
                if (label.getState() != null && !"".equals(label.getState())) {
                    Predicate predicate = cb.equal(root.get("state").as(String.class),  label.getState());//where labelname like labelname
                    list.add(predicate);
                }
                //new 一个数组作为最终返回值的条件
               Predicate[] parr = new Predicate[list.size()];
                //把list直接转数组
                list.toArray(parr);
                return cb.and(parr);
            }
        });
    }

    public Page<Label> pageQuery(Label label, int page, int size) {
        //封装分页对象
        Pageable pageable = PageRequest.of(page-1,size);
        return labelDao.findAll(new Specification<Label>() {
            /**
             *@Author: jiwang
             *@Date: 23:22 2019/1/10
             *@Param: [root 根对象，也就是要把条件封装到哪个对象中 where 类名 = label.getId
             * , query 封装的是查询的关键字, cb 用来封装条件对象 如果直接返回null 表示不需要条件]
             *@return: javax.persistence.criteria.Predicate
             *@Description:
             **/
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                //new一个集合 来存放条件
                List<Predicate> list = new ArrayList<>();
                if (label.getLabelname() != null && !"".equals(label.getLabelname())) {
                    Predicate predicate = cb.like(root.get("labelname").as(String.class), "%" + label.getLabelname() + "%");//where labelname like labelname
                    list.add(predicate);
                }
                if (label.getState() != null && !"".equals(label.getState())) {
                    Predicate predicate = cb.equal(root.get("state").as(String.class),  label.getState());//where labelname like labelname
                    list.add(predicate);
                }
                //new 一个数组作为最终返回值的条件
                Predicate[] parr = new Predicate[list.size()];
                //把list直接转数组
                list.toArray(parr);
                return cb.and(parr);
            }
        },pageable);
    }
}
