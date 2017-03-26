package com.fdu.rissy.rabbitmq;

/**
 * Created by lruihan on 3/26/17.
 */
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * No use for this example, add sending messages in MyUniqueServiceImpl to queues
 */
public class Producer {

    @Autowired
    private AmqpTemplate messageQueue;

    private final AtomicInteger counter = new AtomicInteger();

    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Scheduled(fixedRate = 1000)
    public void execute() {
        System.out.println("execute...");
        messageQueue.convertAndSend("hello " + counter.incrementAndGet());
    }
}