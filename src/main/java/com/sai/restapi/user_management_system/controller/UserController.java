package com.sai.restapi.user_management_system.controller;

import com.sai.restapi.user_management_system.annotations.CreateUserDoc;
import com.sai.restapi.user_management_system.annotations.GetAllUserDoc;
import com.sai.restapi.user_management_system.annotations.ServerErrorDoc;
import com.sai.restapi.user_management_system.annotations.UpdateUserDoc;

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
    public List<User> getAllUsers(){
        return service.getAllUsers();
    }

    @GetMapping("/getbyid")
    @Operation(summary="Get User by id")
    @GetAllUserDoc
    public User getUserById(@RequestParam Integer userId) throws UserNotFoundException {
        return service.getUserById(userId);
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
    public User updateUserById(@RequestBody User updatedUser,  @RequestParam Integer id) throws UserNotFoundException{
        return service.updateUserById(updatedUser, id);
    }







}
