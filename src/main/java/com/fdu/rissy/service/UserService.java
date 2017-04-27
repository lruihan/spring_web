package com.fdu.rissy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lins13 on 4/27/17.
 */
@Service
public class UserService {

    @Autowired
    private NameService nameService;

    public UserService(NameService nameService) {
        this.nameService = nameService;
    }

    public String getUserName(String id) {
        return nameService.getUserName(id);
    }
}
