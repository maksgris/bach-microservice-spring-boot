package edu.rtu.lv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SuppressWarnings("SpringComponentScan")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class},
        scanBasePackages = {"repository","mapper","service"})
public class BachMicroserviceWebappApplication {

    public static void main(String[] args) {
        SpringApplication.run(BachMicroserviceWebappApplication.class, args);
    }
}
