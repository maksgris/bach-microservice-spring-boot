package edu.rtu.lv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class BachMicroserviceWebappApplication {

    public static void main(String[] args) {
        SpringApplication.run(BachMicroserviceWebappApplication.class, args);
    }

}
