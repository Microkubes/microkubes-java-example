package com.microkubes.examples.todo;

import com.microkubes.tools.gateway.spring.AutoRegister;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@EnableAutoConfiguration()
@SpringBootApplication
@Import(AutoRegister.class)
@ComponentScan(basePackages = "com.microkubes.examples.todo.service")
public class Application {
    public static void main(String [] args){
        SpringApplication.run(Application.class, args);
    }
}
