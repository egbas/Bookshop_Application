package com.egbas.BookshopApplication.service.impl;

import com.egbas.BookshopApplication.exceptions.EmailAlreadyExistsException;
import com.egbas.BookshopApplication.repository.UserRepository;
import com.egbas.BookshopApplication.response.ApiResponse;
import com.egbas.BookshopApplication.response.UserSignupResponse;
import com.egbas.BookshopApplication.dto.UserDto;
import com.egbas.BookshopApplication.enums.Gender;
import com.egbas.BookshopApplication.model.User;
import com.egbas.BookshopApplication.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public ResponseEntity<ApiResponse<UserSignupResponse>> registerUser(UserDto userDto) {
        boolean userExists = userRepository.findByEmail(userDto.getEmail()).isPresent();

        if(userExists){
            throw new EmailAlreadyExistsException("Email already exists, kindly login your account");
        }

        User newUser = User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .role(userDto.getRole())
                .password(userDto.getPassword())
                .gender(Gender.valueOf(String.valueOf(userDto.getGender())))
                .build();

        userRepository.save(newUser);



        UserSignupResponse signupResponse = UserSignupResponse.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .build();


        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>("Account created successfully", signupResponse));
    }
}
