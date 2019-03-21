package com.microkubes.examples.todo;

import com.microkubes.tools.gateway.spring.RegistrationConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@EnableAutoConfiguration()
@SpringBootApplication
@Import(RegistrationConfiguration.class)
public class Application {

    public static void main(String [] args){
        SpringApplication.run(Application.class, args);
    }
}
