package com.egbas.BookshopApplication.controller;


import com.egbas.BookshopApplication.dto.UserDto;
import com.egbas.BookshopApplication.response.ApiResponse;
import com.egbas.BookshopApplication.response.UserSignupResponse;
import com.egbas.BookshopApplication.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user/")
@RequiredArgsConstructor
@Tag(name = "User registration management API")
public class UserController {

    private final UserService userService;


    @Operation(
            summary = "Registration of user of book application",
            description = "Register a new user and create a book history"
    )

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<UserSignupResponse>> registerUser(@Valid @RequestBody UserDto userDto){
        return userService.registerUser(userDto);
    }
}
