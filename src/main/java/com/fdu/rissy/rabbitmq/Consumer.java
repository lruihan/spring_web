package com.fdu.rissy.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * Created by lruihan on 3/26/17.
 */
public class Consumer implements MessageListener {

    private Logger logger = LoggerFactory.getLogger(Consumer.class);

    public void onMessage(Message message) {
        logger.info(message.toString());
        try{
            Thread.sleep(1500);
        }catch (InterruptedException e) {
            logger.error("interrupted", e);
        }
    }
}
