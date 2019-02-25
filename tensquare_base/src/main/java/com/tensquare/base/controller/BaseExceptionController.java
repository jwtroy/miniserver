package com.tensquare.base.controller;

import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Auther: <a href="mailto:jiwang@gtmap.cn">jiwang</a>
 * @Version: 1.0, 2019/1/10
 * @Description:统一处理异常信息  包装成约定好的JSON对象
 */
@RestControllerAdvice
public class BaseExceptionController {

    @ExceptionHandler(value = Exception.class)
    public Result ecxeption(Exception e){
        return new Result(false, StatusCode.ERROR,e.getMessage());
    }
}
