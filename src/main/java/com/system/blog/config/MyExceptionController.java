package com.system.blog.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionController {

    @ExceptionHandler(value = MyLoginException.class)
    public String loginExceptionHandler(MyLoginException ex) {
        return "user/login";
    }
}
