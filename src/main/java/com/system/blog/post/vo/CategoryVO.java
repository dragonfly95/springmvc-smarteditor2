package com.system.blog.post.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class CategoryVO implements Serializable {

    private static final long serialVersionUID = -5367906884229163763L;
    private String id;
    private String name;
    private String userId;

}
