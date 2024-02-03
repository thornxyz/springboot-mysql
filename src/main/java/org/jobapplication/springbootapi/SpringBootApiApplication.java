package org.jobapplication.springbootapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "product api",version = "2.0",description = "product microservice"))
public class SpringBootApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApiApplication.class, args);
    }

}
