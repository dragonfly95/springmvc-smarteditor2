package com.system.blog.user.vo;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;


@Getter
@Setter
@NoArgsConstructor
public class UserVO {

    private String userId;

    @NotEmpty(message = "Please provide a author")
    private String name;

    @NotEmpty(message = "Please provide a author")
    private String passwd;

    @NotEmpty(message = "이메일을 입력하세요")
    private String email;

}
