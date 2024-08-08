package com.example.studydemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException extends RuntimeException {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFound(Exception e) {
        return ResponseEntity.status(432).body(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleUnwantedException(Exception e){
        e.printStackTrace();
        return ResponseEntity.status(500).body("Unknow error");
    }

}
