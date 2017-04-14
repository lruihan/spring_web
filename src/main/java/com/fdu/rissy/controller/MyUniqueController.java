package com.fdu.rissy.controller;

import com.fdu.rissy.pojo.User;
import com.fdu.rissy.pojo.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lins13 on 3/22/17.
 */
public interface MyUniqueController {

    @RequestMapping(value = "cache", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    User getUser(@RequestParam(value = "name") String name);

    @RequestMapping(value = "user", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    UserInfo saveUserInfo(@RequestParam(value = "name") String name, @RequestParam(value = "age") int age);
}
