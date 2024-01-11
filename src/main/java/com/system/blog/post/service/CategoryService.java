package com.system.blog.post.service;


import com.system.blog.post.mapper.CategoryMapper;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {


    @Autowired
    private CategoryMapper categoryMapper;

    public Object list(String userId) {

        List<EgovMap> list = categoryMapper.getList(userId);
        EgovMap map = new EgovMap();
        map.put("data", list);
        return map;
    }
}
