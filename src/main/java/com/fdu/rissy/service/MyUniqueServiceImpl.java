package com.fdu.rissy.service;

import com.fdu.rissy.dao.UserDao;
import com.fdu.rissy.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by lins13 on 3/22/17.
 */
@Service
public class MyUniqueServiceImpl implements MyUniqueService {

    private static final Logger logger = LoggerFactory.getLogger(MyUniqueServiceImpl.class);

    @Autowired
    private AmqpTemplate messageQueue;

    @Autowired
    private UserDao userDao;

    private final AtomicInteger counter = new AtomicInteger();

    public User getUser(String name) {
        logger.info("Cache is not hit, put {} into cache", name);
        messageQueue.convertAndSend("hello " + counter.incrementAndGet());
        return populateCache(name);
    }

    public User populateCache(String name) {
        User user = new User(name, new Random().nextInt());
        userDao.save(user);
        return user;
    }
}
