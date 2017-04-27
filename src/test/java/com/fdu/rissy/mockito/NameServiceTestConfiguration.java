package com.fdu.rissy.mockito;

import com.fdu.rissy.service.NameService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

/**
 * Created by lins13 on 4/27/17.
 */
@Profile("test")
@Configuration
public class NameServiceTestConfiguration {

    @Bean
    @Primary
    public NameService nameService() {
        return Mockito.mock(NameService.class);
    }
}
