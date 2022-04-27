package com.system.blog.user.vo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UserVO {

    @NotNull
    private String userId;

    @NotNull
    private String name;

    @NotNull
    private String passwd;

    @NotNull
    private String email;

}
