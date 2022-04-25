package com.system.blog.post.vo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class PostVO {

    private String id;
    private String categoryId;
    private String title;
    private String content;
    private String userId;
    private Timestamp regDate;

}

