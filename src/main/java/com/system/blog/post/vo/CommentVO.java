package com.system.blog.post.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
public class CommentVO implements Serializable {

    private static final long serialVersionUID = 1860314601164950932L;
    private String id;
    private String commentText;
    private Timestamp regDate;

    @JsonIgnore
    private String postId;

    private String userId;

}
