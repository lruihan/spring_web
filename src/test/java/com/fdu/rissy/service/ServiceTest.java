package com.fdu.rissy.service;

import com.fdu.rissy.onlyForTest.FakeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by lins13 on 4/14/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/test/applicationContext.xml")
public class ServiceTest {

    @Autowired
    private FakeService fakeService;

    @Test
    public void test_transactoinal() {
        fakeService.doSomething();
    }
}
