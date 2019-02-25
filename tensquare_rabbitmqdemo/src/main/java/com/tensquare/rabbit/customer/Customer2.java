package com.tensquare.rabbit.customer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Auther: <a href="mailto:jiwang@gtmap.cn">jiwang</a>
 * @Version: 1.0, 2019/2/20
 * @Description:
 */
@Component
@RabbitListener(queues = "itheima")
public class Customer2 {
    @RabbitHandler
    public void getMessage(String msg){
        System.out.printf("custom2 msg:"+msg);
    }
}
