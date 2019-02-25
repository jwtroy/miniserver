package com.tensquare.base;

import util.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @Auther: <a href="mailto:jiwang@gtmap.cn">jiwang</a>
 * @Version: 1.0, 2019/1/4
 * @Description:
 */
@SpringBootApplication
public class BaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class);
    }
    /**
        *@Author: jiwang
        *@Date: 17:30 2019/1/11
        *@Param: []
        *@return: util.IdWorker
        *@Description:创建容器的唯一标示，保证在微服务中容器唯一
        **/
    @Bean
    public IdWorker idWorker(){
        return new IdWorker();
    }
}
