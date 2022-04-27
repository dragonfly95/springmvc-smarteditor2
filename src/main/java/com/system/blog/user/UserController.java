package com.system.blog.user;


import com.system.blog.Idgenerator;
import com.system.blog.ResponseVO;
import com.system.blog.user.mapper.UserMapper;
import com.system.blog.user.vo.UserVO;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

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
    private ResponseEntity registrationProcess(@RequestBody UserVO userVO) {
        int row = userMapper.registrationProcess(userVO);
        return ResponseEntity.ok().body(ResponseVO.of("ok"));
    }
}
