package net.spring.springboot.services.impl;

import net.spring.springboot.Mapper.UserMapper;
import net.spring.springboot.dto.UserDto;
import net.spring.springboot.entity.User;
import net.spring.springboot.exception.ResourceNotFoundException;
import net.spring.springboot.repository.UserRepository;
import net.spring.springboot.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public UserDto createUser(UserDto userDto) {
        //convert UserDto into JPA Entity
      //  User user = UserMapper.mapTouser(userDto);
        User user = modelMapper.map(userDto, User.class);
        User saveduser = userRepository.save(user);

        //convert User JPA Entity to UserDto
      //  UserDto savedUserDto = UserMapper.mapToUserDto(saveduser);

        UserDto savedUserDto = modelMapper.map(saveduser, UserDto.class);

        return savedUserDto;

    }

    @Override
    public UserDto getUserById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User","id",userId)
        );
      //  User user = optionalUser.get();
      //  return UserMapper.mapToUserDto(user);
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        /*return users.stream().map(UserMapper :: mapToUserDto)
                .collect(Collectors.toList());*/

        return users.stream().map((user) -> modelMapper.map(user, UserDto.class) )
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto user) {
        User existingUser = userRepository.findById(user.getId()).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", user.getId())
        );
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updatedUser = userRepository.save(existingUser);
     //   return UserMapper.mapToUserDto(updatedUser);

        return modelMapper.map(updatedUser, UserDto.class);
    }

    @Override
    public void deleteUser(Long userId) {
        User existingUser = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", userId)
        );


        userRepository.deleteById(userId);
    }
}
