package com.system.blog.config;

import com.system.blog.ResponseVO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionController {

    @ExceptionHandler(value = MyLoginException.class)
    public String loginExceptionHandler(MyLoginException ex) {
        return "user/login";
    }


    @ExceptionHandler({BindException.class})
    public ResponseEntity<String> processValidationError(BindException exception) {
        BindingResult bindingResult = exception.getBindingResult();

        StringBuffer msg = new StringBuffer();
        for (ObjectError error : bindingResult.getAllErrors()) {
            msg.append(error.getDefaultMessage() + "\n");
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json;charset=UTF-8");
        return new ResponseEntity(ResponseVO.of(msg.toString()), headers, HttpStatus.OK);
    }
}
