package com.template.mvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    //404
    //not found
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException e) {
        // Customize the response message and return it with a specific HTTP status code
        String errorMessage = e.getMessage();
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }



    //bad requestion
    //400
     @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<String> BadRequestException(BadRequestException e) {
        // Customize the response message and return it with a specific HTTP status code
        String errorMessage = e.getMessage();
        //400
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(MultipartException.class)
    public ResponseEntity<String> handleMultipartException(MultipartException e) {
        // Customize the error message based on your requirements
        String errorMessage = e.getMessage();
        // You can log the exception details if needed
        // logger.error("MultipartException occurred: {}", ex.getMessage(), ex);

        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    //IOExection
     @ExceptionHandler(InputOputExeption.class)
    public ResponseEntity<String> InputOputExeption(InputOputExeption e) {
        // Customize the error message based on your requirements
        String errorMessage = e.getMessage();
        // You can log the exception details if needed
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(UserFetchException.class)
    public ResponseEntity<String> handleUserFetchException(UserFetchException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Something happened fetching users: " + ex.getMessage());
    }


}

