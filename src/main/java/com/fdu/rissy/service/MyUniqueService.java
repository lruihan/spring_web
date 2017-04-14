package com.fdu.rissy.service;

import com.fdu.rissy.pojo.User;
import com.fdu.rissy.pojo.UserInfo;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by lins13 on 3/22/17.
 */
public interface MyUniqueService {

    @Cacheable(value="MyCache")
    User getUser(String name);

    @CachePut(value="MyCache")
    User populateCache(String name);

    UserInfo saveUserInfo(String name, int age);
}
