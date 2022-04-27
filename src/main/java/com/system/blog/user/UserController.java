package com.system.blog.user;


import com.system.blog.ResponseVO;
import com.system.blog.user.mapper.UserMapper;
import com.system.blog.user.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping(value = "logout.do")
    private String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        UserVO loginVO = (UserVO) session.getAttribute("loginVO");
        if (loginVO != null) {
            session.invalidate();
        }
        return "user/login";
    }


    @GetMapping(value = "login.do")
    private String login() {
        return "user/login";
    }

    @PostMapping(value = "loginProcess")
    private ResponseEntity loginProcess(HttpServletRequest request, @RequestBody UserVO userVO) {
        UserVO loginVO = userMapper.login(userVO);
        if (loginVO != null) {
            HttpSession session = request.getSession();
            session.setAttribute("loginVO", loginVO);
        } else {
            throw new RuntimeException("login failed");
        }
        return ResponseEntity.ok().body(ResponseVO.of("ok"));
    }

    @GetMapping(value = "registation.do")
    private String registration() {
        return "user/registration";
    }

    @PostMapping(value = "registrationProcess")
    private ResponseEntity registrationProcess(@RequestBody @Valid UserVO userVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new RuntimeException("오류 !!!");
        }
        int row = userMapper.registrationProcess(userVO);
        return ResponseEntity.ok().body(ResponseVO.of("ok"));
    }
}
