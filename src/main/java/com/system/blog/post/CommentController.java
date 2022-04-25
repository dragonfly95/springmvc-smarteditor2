package com.system.blog.post;

import com.system.blog.ResponseVO;
import com.system.blog.post.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

}
