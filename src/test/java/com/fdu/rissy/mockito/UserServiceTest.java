package com.fdu.rissy.mockito;

import com.fdu.rissy.service.MocksApplication;
import com.fdu.rissy.service.NameService;
import com.fdu.rissy.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by lins13 on 4/27/17.
 */
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MocksApplication.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private NameService nameService;

    @Test
    public void test_mock_nameService() {
        Mockito.when(nameService.getUserName("SomeId")).thenReturn("Mock user name");
        String testName = userService.getUserName("SomeId");
        assertEquals("Mock user name", testName);
    }

}
