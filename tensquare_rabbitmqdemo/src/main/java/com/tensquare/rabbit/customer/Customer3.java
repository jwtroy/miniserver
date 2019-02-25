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
@RabbitListener(queues = "kudingyu")
public class Customer3 {
    @RabbitHandler
    public void getMessage(String msg){
        System.out.printf("custom3 msg:"+msg);
    }
}
