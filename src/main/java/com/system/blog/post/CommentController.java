package com.system.blog.post;

import com.system.blog.ResponseVO;
import com.system.blog.post.mapper.CommentMapper;
import com.system.blog.post.vo.CommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "comment")
public class CommentController {

    @Autowired
    private CommentMapper commentMapper;

    @GetMapping("list/{postId}")
    private ResponseEntity list(@PathVariable("postId") String postId) {
        return ResponseEntity.ok().body(ResponseVO.of("ok"));
    }

    @PostMapping("insertProcess/{postId}")
    private ResponseEntity insertProcess(@RequestBody CommentVO commentVO) {
        return ResponseEntity.ok().body(ResponseVO.of("ok"));
    }

    @DeleteMapping("deleteProcess/{postId}/{commentId}")
    private ResponseEntity deleteProcess(@PathVariable("postId") String postId, @PathVariable("commentId") String commentId) {
        return ResponseEntity.ok().body(ResponseVO.of("ok"));
    }

}
