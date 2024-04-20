package com.egbas.BookshopApplication.response;


import com.egbas.BookshopApplication.util.DateUtils;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class ApiResponse <T> {
    private String responseMessage;
    private T responseData;
    private final String responseTime = DateUtils.toDateString(LocalDateTime.now());

    public ApiResponse(String message) {
        this.responseMessage = message;
        this.responseData = null;
    }

    public ApiResponse(String message, T data) {
        this.responseMessage = message;
        this.responseData = data;
    }
}
