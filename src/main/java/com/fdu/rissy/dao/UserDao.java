package com.fdu.rissy.dao;

import com.fdu.rissy.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by lins13 on 4/10/17.
 */
public interface UserDao extends JpaRepository<User, Integer>{

}
