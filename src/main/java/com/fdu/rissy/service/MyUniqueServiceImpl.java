package com.fdu.rissy.service;

import com.fdu.rissy.dao.UserDao;
import com.fdu.rissy.dao.UserInfoDao;
import com.fdu.rissy.pojo.User;
import com.fdu.rissy.pojo.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by lins13 on 3/22/17.
 */
@Service
@Transactional(readOnly = true)
public class MyUniqueServiceImpl implements MyUniqueService {

    private static final Logger logger = LoggerFactory.getLogger(MyUniqueServiceImpl.class);

    @Autowired
    private AmqpTemplate messageQueue;

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserInfoDao userInfoDao;

    private final AtomicInteger counter = new AtomicInteger();

    public User getUser(String name) {
        logger.info("Cache is not hit, put {} into cache", name);
        messageQueue.convertAndSend("hello " + counter.incrementAndGet());
        return populateCache(name);
    }

    @Transactional
    public User populateCache(String name) {
        User user = new User(name);
        userDao.save(user);
        return user;
    }

    //Must add @Transactional to override the readOnly = true on class level
    @Transactional
    public UserInfo saveUserInfo(String name, int age) {
        UserInfo userInfo = userInfoDao.findByName(name);
        if(userInfo != null) {
            userInfo.setAge(age);
        }else {
            userInfo = new UserInfo(name, age);
            userInfoDao.save(userInfo);
        }
        return userInfo;
    }
}
