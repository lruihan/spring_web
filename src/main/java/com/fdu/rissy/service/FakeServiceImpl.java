package com.fdu.rissy.service;

import com.fdu.rissy.dao.UserDao;
import com.fdu.rissy.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lins13 on 4/14/17.
 */
@Service
@Transactional(readOnly = true)
public class FakeServiceImpl implements FakeService {

    @Autowired
    private UserDao userDao;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void doSomething() {
<<<<<<< HEAD
        userDao.save(new User("Rissy4"));
=======
        another();
    }
    
    public void another() {
        userDao.save(new User("Rissy7"));
>>>>>>> Add @Transaction for JPA Object Update (will commit automatically)
    }
}
