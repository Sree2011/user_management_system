package com.sai.restapi.user_management_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories("com.sai.restapi.user_management_system.repository")
@ComponentScan({"com.sai.restapi.user_management_system.service","com.sai.restapi.user_management_system.model","com.sai.restapi.user_management_system.repository"})
public class UserManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserManagementSystemApplication.class, args);
    }

}
