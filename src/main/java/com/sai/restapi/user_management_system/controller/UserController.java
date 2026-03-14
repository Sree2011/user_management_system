package com.sai.restapi.user_management_system.controller;

import com.sai.restapi.user_management_system.annotations.*;

import com.sai.restapi.user_management_system.exception.UserNotFoundException;
import com.sai.restapi.user_management_system.model.User;
import com.sai.restapi.user_management_system.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/users")
@ServerErrorDoc
@Tag(name = "User Management Controller", description = "Handles operations on users")
public class UserController {


    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    //----------------------------Get Users---------------------------------
    @GetMapping("/getall")
    @Operation(summary = "Get All Users")
    @GetAllUserDoc
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> ss = service.getAllUsers();
        return ResponseEntity.ok(ss);
    }

    @GetMapping("/getbyid")
    @Operation(summary="Get User by id")
    @GetAllUserDoc
    public ResponseEntity<User> getUserById(@RequestParam Integer userId) throws UserNotFoundException {
        User user = service.getUserById(userId);
        return ResponseEntity.ok(user);
    }


    //------------------------------Create Users------------------------------
    @PostMapping("/create")
    @CreateUserDoc
    public ResponseEntity<User> createUser(@RequestBody User user_param){
        User user = service.saveUser(user_param);
        return ResponseEntity.ok(user);
    }


    //------------------------------Update user by id--------------------
    @PutMapping("/update")
    @UpdateUserDoc
    public ResponseEntity<User> updateUserById(@RequestBody User updatedUser,  @RequestParam Integer id) throws UserNotFoundException{
        User existingUser = service.updateUserById(updatedUser, id);
        return ResponseEntity.ok(existingUser);
    }


    //------------------------Delete user by id-------------------------
    @DeleteMapping("/deletebyid")
    @DeleteUserDoc
    public ResponseEntity<String> deleteUserById(@RequestParam Integer id) throws UserNotFoundException{
        service.deleteUser(id);
        return ResponseEntity.noContent().build();
    }


}
