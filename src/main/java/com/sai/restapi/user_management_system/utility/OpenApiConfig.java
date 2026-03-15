package com.sai.restapi.user_management_system.utility;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("User Management System API")
                        .version("1.0.0")
                        .description("REST API for managing users, projects, tasks, and comments with nested DTOs")
                        .contact(new Contact()
                                .name("Nandini")
                                .email("nandini@example.com")
                                .url("https://github.com/nandini"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org")))
                .tags(List.of(
                        new Tag().name("1. User Management Controller").description("Handles operations on users"),
                        new Tag().name("2. Project Management Controller").description("Handles operations on projects"),
                        new Tag().name("3. Task Management Controller").description("Handles operations on tasks"),
                        new Tag().name("4. Comment Management Controller").description("Handles operations on comments"),
                        new Tag().name("5. Task With User Controller").description("Handles operations common to task and user"),
                        new Tag().name("6. User With Project Controller").description("Handles operations common to user and project"),
                        new Tag().name("7. Project With Task Controller").description("Handles operations common to project and task"),
                        new Tag().name("8. Task With Comment Controller").description("Handles operations common to task and comment")
//                        new Tag().name("9. Comment With Author Controller").description("Handles operations common to comment and author")
                ));
    }
}