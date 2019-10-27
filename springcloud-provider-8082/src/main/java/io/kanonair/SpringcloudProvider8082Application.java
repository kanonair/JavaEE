package io.kanonair;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringcloudProvider8082Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudProvider8082Application.class, args);
    }

}
