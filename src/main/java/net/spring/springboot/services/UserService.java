package net.spring.springboot.services;

import net.spring.springboot.dto.UserDto;
import net.spring.springboot.entity.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);
    UserDto getUserById(Long userId);
    List<UserDto> getAllUsers();
    UserDto updateUser(UserDto user);
    void deleteUser(Long userId);
}
