package com.egbas.BookshopApplication.service;

import com.egbas.BookshopApplication.response.ApiResponse;
import com.egbas.BookshopApplication.response.UserSignupResponse;
import com.egbas.BookshopApplication.dto.UserDto;
import org.springframework.http.ResponseEntity;

public interface UserService {

//    ResponseEntity<ApiResponse<UserSignupResponse>> registerUser(UserDto userDto);
ResponseEntity<ApiResponse<UserSignupResponse>> registerUser(UserDto userDto);
}
