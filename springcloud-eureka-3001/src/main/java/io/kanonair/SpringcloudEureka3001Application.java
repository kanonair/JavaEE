package io.kanonair;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringcloudEureka3001Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudEureka3001Application.class, args);
    }

}
