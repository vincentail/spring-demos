package com.vincent.springdemos.rabbitMq.consumer;

import com.rabbitmq.client.Channel;
import com.vincent.springdemos.rabbitMq.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

/**
 * author vincent
 * create at 2022/1/14
 * Description
 **/

@Service
@Slf4j
public class RabbitMqConsumerDemo {

    @RabbitListener(bindings = {@QueueBinding(value = @Queue(durable = "true", value = Constants.ROUTING_KEY),key= Constants.ROUTING_KEY, exchange =@Exchange(durable = "true", value = Constants.EXCHANGE))})
    public void consume(@Payload String msg, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, Channel channel) {
        log.info("consume msg:{}",msg);
//        throw new RuntimeException("retry?");
    }
}
