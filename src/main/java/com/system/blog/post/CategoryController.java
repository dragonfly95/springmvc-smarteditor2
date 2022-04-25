package com.system.blog.post;

import com.system.blog.ResponseVO;
import com.system.blog.post.mapper.CategoryMapper;
import com.system.blog.post.vo.CategoryVO;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "category")
public class CategoryController {

    @Autowired
    private CategoryMapper categoryMapper;

    @GetMapping(value = "crud.do")
    public String crud() {
        return "category/crud";
    }

    @GetMapping(value = "list")
    public ResponseEntity list(@RequestParam("userId") String userId) {
        List<EgovMap> list = categoryMapper.getList(userId);
        return ResponseEntity.ok().body(list);
    }

    @PostMapping(value = "insertProcess")
    public ResponseEntity insertProcess(@RequestBody CategoryVO categoryVO) {
        int row = categoryMapper.insertProcess(categoryVO);
        return ResponseEntity.ok().body(ResponseVO.of("ok"));
    }

    @PutMapping(value = "updateProcess/{id}")
    public ResponseEntity updateProcess(@RequestBody CategoryVO categoryVO, @PathVariable("id") String id) {
        int row = categoryMapper.updateProcess(categoryVO);
        return ResponseEntity.ok().body(ResponseVO.of("ok"));
    }

    @DeleteMapping(value = "deleteProcess/{id}")
    public ResponseEntity deleteProcess(@PathVariable("id") String id) {
        int row = categoryMapper.deleteProcess(id);
        return ResponseEntity.ok().body(ResponseVO.of("ok"));
    }
}
