package net.spring.springboot.Mapper;

import net.spring.springboot.dto.UserDto;
import net.spring.springboot.entity.User;

public class UserMapper {
    public static UserDto mapToUserDto(User user) {
        //Convert user JPA Entity into UserDto
        UserDto userDto = new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
        return userDto;
    }

    //Convert UserDto into User JPA Entity
    public static User mapTouser(UserDto userDto) {


    User user = new User(
            userDto.getId(),
            userDto.getFirstName(),
            userDto.getLastName(),
            userDto.getEmail()
    );
        return user;
}

}
