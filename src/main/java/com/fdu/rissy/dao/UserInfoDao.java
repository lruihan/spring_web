package com.fdu.rissy.dao;

import com.fdu.rissy.pojo.User;
import com.fdu.rissy.pojo.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by lins13 on 4/14/17.
 */
public interface UserInfoDao extends JpaRepository<UserInfo, String> {
<<<<<<< HEAD
=======

    UserInfo findByName(String name);
>>>>>>> Add @Transaction for JPA Object Update (will commit automatically)
}
