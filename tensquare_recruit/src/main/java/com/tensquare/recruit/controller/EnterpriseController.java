package com.tensquare.recruit.controller;

import com.tensquare.recruit.pojo.Enterprise;
import com.tensquare.recruit.service.EnterpriseService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: <a href="mailto:jiwang@gtmap.cn">jiwang</a>
 * @Version: 1.0, 2019/1/11
 * @Description:
 */
@RestController
@CrossOrigin
@RequestMapping("/enterprise")
public class EnterpriseController {

    @Autowired
    private EnterpriseService enterpriseService;

    /**
        *@Author: jiwang
        *@Date: 22:39 2019/1/12
        *@Param: []
        *@return: entity.Result
        *@Description: 热门企业列表
        **/
    @RequestMapping(value = "/search/hotlist",method = RequestMethod.GET)
    public Result hotlist(){
        List<Enterprise> list = enterpriseService.hotList("1");
        return new Result(true, StatusCode.OK,"查询成功",list);
    }

    //增  删  改  查 beigin
    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Enterprise enterprise){
        enterpriseService.save(enterprise);
        return new Result(true,StatusCode.OK,"增加成功");
    }

    @RequestMapping(value = "/{enterpriseId}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable("enterpriseId") String enterpriseId){
        enterpriseService.deleteById(enterpriseId);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    @RequestMapping(value = "/{enterpriseId}",method = RequestMethod.PUT)
    public Result update(@PathVariable("enterpriseId") String enterpriseId,@RequestBody Enterprise enterprise){
        enterprise.setId(enterpriseId);
        enterpriseService.update(enterprise);
        return new Result(true,StatusCode.OK,"更新成功");
    }

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        List<Enterprise> list = enterpriseService.findAll();
        return new Result(true,StatusCode.OK,"查询成功",list);
    }

    @RequestMapping(value = "/{enterpriseId}",method = RequestMethod.GET)
    public Result findById(@PathVariable("enterpriseId") String enterpriseId){
        Enterprise enterprise = enterpriseService.findById(enterpriseId);
        return new Result(true,StatusCode.OK,"查询成功",enterprise);
    }
    //增  删  改  查 end



}
