package com.system.blog.post.vo;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.sql.Timestamp;
import java.util.List;

@Data
public class PostVO {

    private String id;
    private String categoryId;
    private String title;
    private String content;
    private String userId;
    private Timestamp regDate;

    private CategoryVO category;
//    private List<CommentVO> comment;

}

