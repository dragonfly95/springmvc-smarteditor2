package com.system.blog.user;


import com.system.blog.ResponseVO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "user")
public class UserController {

    @GetMapping(value = "login.do")
    private String login() {
        return "login";
    }

    @PostMapping(value = "loginProcess")
    private ResponseEntity loginProcess() {
        return ResponseEntity.ok().body(ResponseVO.of("ok"));
    }

    @GetMapping(value = "registation.do")
    private String registration() {
        return "registration";
    }
}
