package com.microkubes.examples.todo;

import com.microkubes.tools.gateway.spring.AutoRegister;
import com.microkubes.tools.security.spring.EnableSecurity;
import com.microkubes.tools.security.spring.JWTOAuth2Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableAutoConfiguration()
@SpringBootApplication
@Import({AutoRegister.class})
@ComponentScan(basePackages = "com.microkubes.examples.todo.service")
@PropertySource("classpath:config.properties")
@EnableSecurity
public class Application extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated();
    }

    public static void main(String [] args){
        SpringApplication.run(Application.class, args);
    }
}
