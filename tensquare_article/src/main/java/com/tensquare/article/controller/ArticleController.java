package com.tensquare.article.controller;

import com.tensquare.article.pojo.Article;
import com.tensquare.article.service.ArticleService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: <a href="mailto:jiwang@gtmap.cn">jiwang</a>
 * @Version: 1.0, 2019/1/14
 * @Description:
 */
@RestController
@RequestMapping("/article")
@CrossOrigin
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/examine/{articleId}",method = RequestMethod.PUT)
    public Result examine(@PathVariable String articleId){
        articleService.updateState(articleId);
        return new Result(true,StatusCode.OK,"审核成功");
    }

    @RequestMapping(value = "/thumbup/{articleId}",method = RequestMethod.PUT)
    public Result thumbup(@PathVariable String articleId){
        articleService.updateThumbup(articleId);
        return new Result(true,StatusCode.OK,"点赞成功");
    }

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        return new Result(true, StatusCode.OK,"查询成功",articleService.findAll());
    }

    @RequestMapping(value = "/{articleId}",method = RequestMethod.GET)
    public Result findById(@PathVariable("articleId") String articleId){
        return new Result(true,StatusCode.OK,"查询成功",articleService.findById(articleId));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Article article){//RequestBody JSON->pojo
        articleService.save(article);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    @RequestMapping(value = "/{articleId}",method = RequestMethod.PUT)
    public Result update(@PathVariable("articleId") String articleId, @RequestBody Article article){//RequestBody JSON->pojo
        article.setId(articleId);
        articleService.update(article);
        return new Result(true, StatusCode.OK,"更新成功");
    }

    @RequestMapping(value = "/{articleId}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable("articleId") String articleId){//RequestBody JSON->pojo
        articleService.deleteById(articleId);
        return new Result(true,StatusCode.OK,"删除成功");
    }

}
