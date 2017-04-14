package com.fdu.rissy;

import com.fdu.rissy.service.FakeService;
import com.fdu.rissy.service.MyUniqueService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by lins13 on 4/14/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ServiceTest {

    @Autowired
    private MyUniqueService myUniqueService;

    @Autowired
    private FakeService fakeService;

    @Test
    public void test_transactoinal() {
        fakeService.doSomething();
<<<<<<< HEAD
        myUniqueService.saveUserInfo("Rissy4", 27);
=======
        myUniqueService.saveUserInfo("Rissy7", 27);
>>>>>>> Add @Transaction for JPA Object Update (will commit automatically)
    }
}
