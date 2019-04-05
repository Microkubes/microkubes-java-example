package com.microkubes.examples.todo;

import com.microkubes.tools.gateway.spring.AutoRegister;
import com.microkubes.tools.security.spring.EnableSecurity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableAutoConfiguration()
@SpringBootApplication
@Import({AutoRegister.class})
@ComponentScan(basePackages = "com.microkubes.examples.todo.service,com.microkubes.examples.todo")
@PropertySource("classpath:config.properties")
@EnableSecurity
@EnableResourceServer
public class Application {

    public static void main(String [] args){
        SpringApplication.run(Application.class, args);
    }
}
