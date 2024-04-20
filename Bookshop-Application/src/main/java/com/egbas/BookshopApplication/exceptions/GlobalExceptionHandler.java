package com.egbas.BookshopApplication.exceptions;

import com.egbas.BookshopApplication.model.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmailAlreadyExistsException.class)
    ResponseEntity<ErrorDetails> handleEmailAlreadyExistsException(final EmailAlreadyExistsException e){

        ErrorDetails errorResponse = new ErrorDetails();
        errorResponse.setTimeStamp(LocalDateTime.now());
        errorResponse.setErrorDetails(String.valueOf(HttpStatus.CONFLICT));
        errorResponse.setErrorMessage(e.getMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
//        return null;
    }


    @ExceptionHandler(UserNotFoundException.class)
    ResponseEntity<ErrorDetails> handleUserNotFoundException(final UserNotFoundException e){

        ErrorDetails errorResponse = new ErrorDetails();
        errorResponse.setTimeStamp(LocalDateTime.now());
        errorResponse.setErrorDetails(String.valueOf(HttpStatus.BAD_REQUEST));
        errorResponse.setErrorMessage(e.getMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(BookNotFoundException.class)
    ResponseEntity<ErrorDetails> handleBookNotFoundException(final BookNotFoundException e){

        ErrorDetails errorResponse = new ErrorDetails();
        errorResponse.setTimeStamp(LocalDateTime.now());
        errorResponse.setErrorDetails(String.valueOf(HttpStatus.NOT_FOUND));
        errorResponse.setErrorMessage(e.getMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

    }

//    ErrorDetails errorResponse = new ErrorDetails();
//        errorResponse.setTimeStamp(LocalDateTime.now());
//        errorResponse.setErrorDetails(String.valueOf(HttpStatus.CONFLICT));
//        errorResponse.setErrorMessage(e.getMessage());
//
//        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
}
