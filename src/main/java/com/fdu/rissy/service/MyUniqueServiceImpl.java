package com.fdu.rissy.service;

import com.fdu.rissy.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Created by lins13 on 3/22/17.
 */
@Service
public class MyUniqueServiceImpl implements MyUniqueService {

    public User getUser(String name) {
        System.out.println("test");
        return populateCache(name);
    }

    public User populateCache(String name) {
        User user = new User(name, new Random().nextInt());
        return user;
    }
}
