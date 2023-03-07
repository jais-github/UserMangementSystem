package net.spring.springboot.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    @NotEmpty(message = "user first name should not be empty")
    private String firstName;
    @NotEmpty(message = "user last name should not be empty")
    private String lastName;
    @NotEmpty
    @Email(message = "users email should not be empty")
    private String email;
}
