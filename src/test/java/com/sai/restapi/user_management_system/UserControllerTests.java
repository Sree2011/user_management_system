package com.sai.restapi.user_management_system;

import com.sai.restapi.user_management_system.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
class UserControllerTests {

    @Autowired
    private MockMvc mockMvc;

    // GET /users/getall
    @Test
    void getAllUsers_shouldReturnOk() throws Exception {
        mockMvc.perform(get("/users/getall"))
                .andExpect(status().isOk());
    }

    // GET /users/getbyid?id=1
    @Test
    void getUserById_shouldReturnOk() throws Exception {
        mockMvc.perform(get("/users/getbyid")
                        .param("id", "1"))
                .andExpect(status().isOk());
    }

    // POST /users/create
    @Test
    void createUser_shouldReturnCreated() throws Exception {
        String userJson = "{ \"name\": \"user1\", \"email\": \"user1@gmail.com\" }";

        mockMvc.perform(post("/users/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userJson))
                .andExpect(status().isCreated());
    }

    // PUT /users/update?id=1
    @Test
    void updateUser_shouldReturnOk() throws Exception {
        String updatedUserJson = "{ \"name\": \"updatedUser\", \"email\": \"updated@gmail.com\" }";

        mockMvc.perform(put("/users/update")
                        .param("id", "1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updatedUserJson))
                .andExpect(status().isOk());
    }
}