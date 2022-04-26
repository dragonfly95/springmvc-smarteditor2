package com.system.blog.post;

import com.system.blog.ResponseVO;
import com.system.blog.post.mapper.CommentMapper;
import com.system.blog.post.vo.CommentVO;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "comment")
public class CommentController {

    @Autowired
    private CommentMapper commentMapper;

    @GetMapping("list/{postId}")
    private ResponseEntity list(@PathVariable("postId") String postId) {
        List<CommentVO> list = commentMapper.list(postId);

        return ResponseEntity.ok().body(list);
    }

    @PostMapping("insertProcess/{postId}")
    private ResponseEntity insertProcess(@RequestBody CommentVO commentVO) {
        int row = commentMapper.insertProcess(commentVO);
        return ResponseEntity.ok().body(ResponseVO.of("ok"));
    }

    @DeleteMapping("deleteProcess/{postId}/{commentId}")
    private ResponseEntity deleteProcess(@PathVariable("postId") String postId, @PathVariable("commentId") String commentId) {
        EgovMap map = new EgovMap();
        map.put("postId", postId);
        map.put("commentId", commentId);
        int row = commentMapper.deleteProcess(map);
        return ResponseEntity.ok().body(ResponseVO.of("ok"));
    }

}
