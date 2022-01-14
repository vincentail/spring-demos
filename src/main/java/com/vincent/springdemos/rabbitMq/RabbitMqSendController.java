package com.vincent.springdemos.rabbitMq;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Random;
import java.util.UUID;

/**
 * author vincent
 * create at 2022/1/14
 * Description
 **/
@Api(description = "rabbitmq")
@Slf4j
@RestController
@RequestMapping("/rabbit/send")
public class RabbitMqSendController {
    @Resource
    private RabbitTemplate rabbitTemplate;

    private String exchange="exchange.vincent";
    private String routingKey="vincent.routing1";

    @RequestMapping("/msg/{content}")
    public String sendMsg(@PathVariable("content") String content) {
        log.info("send msg:{}",content);
        rabbitTemplate.convertAndSend(Constants.EXCHANGE,Constants.ROUTING_KEY,content);
        return "send:"+content;
    }

    @RequestMapping("/test")
    public String testError() {
        Random random = new Random();
        if (random.nextBoolean()) {
            throw new RuntimeException("error random");
        }
        return UUID.randomUUID().toString();
    }


}
