package edu.rtu.lv.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableJpaRepositories("edu.rtu.lv.repository")
@ComponentScan("edu.rtu.lv.repository")
public class NumbersRepositoryConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
