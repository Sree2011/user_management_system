package com.sai.restapi.user_management_system.service;

import com.sai.restapi.user_management_system.exception.UserNotFoundException;
import com.sai.restapi.user_management_system.model.User;
import com.sai.restapi.user_management_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public User getUserById(Integer id) throws UserNotFoundException{
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }
    public User saveUser(User user) {
        return userRepository.save(user);
    }
    public void deleteUser(Integer id){
        userRepository.deleteById(id);
    }

    public User updateUserById(User updatedUser, Integer id) throws UserNotFoundException{
        return userRepository.findById(id)
                .map(existingUser -> {
                    existingUser.setName(updatedUser.getName());
                    existingUser.setEmail(updatedUser.getEmail());
                    // set other fields...
                    return userRepository.save(existingUser);
                })
                .orElseThrow(() -> new UserNotFoundException(id));


    }
}