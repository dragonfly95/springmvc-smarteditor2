package com.system.blog.post;

import com.system.blog.ResponseVO;
import com.system.blog.post.vo.PostVO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "post")
public class PostController {

    @GetMapping(value = "write.do")
    private String write() {
        return "post/write";
    }

    @GetMapping(value = "view.do")
    private String view() {
        return "post/view";
    }

    @PostMapping(value = "writeProcess")
    private ResponseEntity writeProcess(@RequestBody PostVO postVO) {
        return ResponseEntity.ok().body(ResponseVO.of("ok"));
    }

    @PutMapping(value = "upateProcess/{id}")
    private ResponseEntity updateProcess(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(ResponseVO.of("ok"));
    }

    @DeleteMapping(value = "deleteProcess/{id}")
    private ResponseEntity deleteProcess(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(ResponseVO.of("ok"));
    }
}