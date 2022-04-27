package com.system.blog.user.vo;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Size;


@Getter
@Setter
@NoArgsConstructor
public class UserVO {

    private String userId;

    private String name;

    private String passwd;

    @Size
    private String email;

}
