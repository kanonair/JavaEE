package io.kanonair;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringcloudProvider8081Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudProvider8081Application.class, args);
    }

}
