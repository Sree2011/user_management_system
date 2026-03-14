package com.sai.restapi.user_management_system.service;

import com.sai.restapi.user_management_system.dto.UserDTO;
import com.sai.restapi.user_management_system.exception.UserNotFoundException;
import com.sai.restapi.user_management_system.model.User;
import com.sai.restapi.user_management_system.repository.UserRepository;
import com.sai.restapi.user_management_system.utility.DtoMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Get all users as DTOs
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(DtoMapper::toUserDTO)
                .collect(Collectors.toList());
    }

    // Get single user by ID as DTO
    public UserDTO getUserById(Integer id) throws UserNotFoundException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        return DtoMapper.toUserDTO(user);
    }

    // Save user (accepts DTO, converts to entity)
    public UserDTO saveUser(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        User savedUser = userRepository.save(user);
        return DtoMapper.toUserDTO(savedUser);
    }

    // Delete user
    public void deleteUser(Integer id) throws UserNotFoundException {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
    }

    // Update user by ID (accepts DTO, returns DTO)
    public UserDTO updateUserById(UserDTO updatedUserDTO, Integer id) throws UserNotFoundException {
        User updatedUser = userRepository.findById(id)
                .map(existingUser -> {
                    existingUser.setName(updatedUserDTO.getName());
                    existingUser.setEmail(updatedUserDTO.getEmail());
                    return userRepository.save(existingUser);
                })
                .orElseThrow(() -> new UserNotFoundException(id));

        return DtoMapper.toUserDTO(updatedUser);
    }
}