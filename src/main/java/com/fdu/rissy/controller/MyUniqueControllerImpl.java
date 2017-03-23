package com.fdu.rissy.controller;

import com.fdu.rissy.pojo.User;
import com.fdu.rissy.service.MyUniqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lins13 on 3/22/17.
 */
@RestController
public class MyUniqueControllerImpl implements MyUniqueController{

    @Autowired
    private MyUniqueService myUniqueService;

    public User getUser(@RequestParam(value = "name") String name) {
        return myUniqueService.getUser(name);
    }
}
