package com.system.blog.post;

import com.system.blog.post.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "category")
public class CategoryController {

    @Autowired
    private CategoryMapper categoryMapper;

    @GetMapping(value = "crud.do")
    public String crud() {
        return "category/crud";
    }

}
