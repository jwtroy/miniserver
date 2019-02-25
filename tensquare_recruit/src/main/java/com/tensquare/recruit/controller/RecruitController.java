package com.tensquare.recruit.controller;

import com.tensquare.recruit.pojo.Enterprise;
import com.tensquare.recruit.pojo.Recruit;
import com.tensquare.recruit.service.RecruitService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: <a href="mailto:jiwang@gtmap.cn">jiwang</a>
 * @Version: 1.0, 2019/1/12
 * @Description:
 */
@RestController
@CrossOrigin
@RequestMapping("/recruit")
public class RecruitController {

    @Autowired
    private RecruitService recruitService;

    @RequestMapping(value = "/search/newlist",method = RequestMethod.GET)
    public Result newlist(){
        List<Recruit> list = recruitService.newlist();
        return new Result(true,StatusCode.OK,"获取最新职位成功",list);
    }

    /**
        *@Author: jiwang
        *@Date: 23:54 2019/1/12
        *@Param: []
        *@return: entity.Result
        *@Description:推荐职位
        **/
    @RequestMapping(value = "/search/recommend",method = RequestMethod.GET)
    public Result recommend(){
        List<Recruit> list = recruitService.recommend();
        return new Result(true,StatusCode.OK,"查询推荐职位成功",list);
    }

    //增  删  改  查 beigin
    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Recruit recruit){
        recruitService.save(recruit);
        return new Result(true,StatusCode.OK,"增加成功");
    }

    @RequestMapping(value = "/{recruitId}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable("recruitId") String recruitId){
        recruitService.deleteById(recruitId);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    @RequestMapping(value = "/{recruitId}",method = RequestMethod.PUT)
    public Result update(@PathVariable("recruitId") String recruitId,@RequestBody Recruit recruit){
        recruit.setId(recruitId);
        recruitService.update(recruit);
        return new Result(true,StatusCode.OK,"更新成功");
    }

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        List<Recruit> list = recruitService.findAll();
        return new Result(true, StatusCode.OK,"查询成功",list);
    }

    @RequestMapping(value = "/{recruitId}",method = RequestMethod.GET)
    public Result findById(@PathVariable("recruitId") String recruitId){
        Recruit recruit = recruitService.findById(recruitId);
        return new Result(true,StatusCode.OK,"查询成功",recruit);
    }
    //增  删  改  查 end

}
