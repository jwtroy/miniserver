package com.tensquare.test;

import com.tensquare.rabbit.RabbitApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Auther: <a href="mailto:jiwang@gtmap.cn">jiwang</a>
 * @Version: 1.0, 2019/2/20
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitApplication.class)
public class ProductTest {
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Test
    public void sendMessage(){
        rabbitTemplate.convertAndSend("itcast","test direct");
    }
    @Test
    public void sendMessage2(){
        rabbitTemplate.convertAndSend("chuanzhi","","分裂模式");
    }
    @Test
    public void sendMessage3(){
        rabbitTemplate.convertAndSend("topictest","good.abc","主题模式");
    }
}
