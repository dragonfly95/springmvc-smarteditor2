package com.system.blog.post.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.core.serializer.Serializer;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PostVO implements Serializable {

    private static final long serialVersionUID = -9026936407398324865L;

    private String id;
    private String categoryId;
    private String title;
    private String content;
    private String userId;
    private Timestamp regDate;

    private CategoryVO category;
    private List<CommentVO> comment;

}

