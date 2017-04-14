package com.fdu.rissy;

import com.fdu.rissy.pojo.User;
import com.fdu.rissy.service.MyUniqueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lins13 on 3/22/17.
 */
public class SpringTest {

    private static final Logger logger = LoggerFactory.getLogger(SpringTest.class);
    public static void main(String[] args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyUniqueService myUniqueService = context.getBean(MyUniqueService.class);
//        myUniqueService.populateCache("Rissy1");
//        myUniqueService.populateCache("Rissy2");

        User user1 = myUniqueService.getUser("Rissy1");
        //System.out.println(user1.getName() + ", " + user1.getAge());
//        logger.info("name : {}, age : {}", user1.getName(), user1.getAge());
//        User user2 = myUniqueService.getUser("Rissy2");
//        System.out.println(user2.getName() + ", " + user2.getAge());
//        User user3 = myUniqueService.getUser("Rissy1");
//        System.out.println(user3.getName() + ", " + user3.getAge());
//        User user4 = myUniqueService.getUser("Rissy2");
//        System.out.println(user4.getName() + ", " + user4.getAge());
    }
}
