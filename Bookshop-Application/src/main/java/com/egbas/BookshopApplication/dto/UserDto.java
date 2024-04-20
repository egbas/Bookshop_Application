package com.egbas.BookshopApplication.dto;

import com.egbas.BookshopApplication.enums.Gender;
import com.egbas.BookshopApplication.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @Size(min = 2, max = 125, message = "first name must be at least 2 characters long")
    private String firstName;

    @Size(min = 2, max = 125, message = "last name must be at least 2 characters long")
    @NotBlank(message = "Last name must not be blank")
    private String lastName;

    @Size(min = 2, max = 125)
    @NotBlank(message = "email is required")
    @Email(message = "email must be valid")
    private String email;

    @Size(min = 6, max = 65, message = "password must be at least 6 characters long")
    @NotBlank(message = "password must not be blank")
    private String password;

    @Size(min = 6, max = 65, message = "confirm password must be at least 6 characters long")
    @NotBlank(message = "confirm password must not be blank")
    private String confirmPassword;


    private Role role;


    private Gender gender;

}
