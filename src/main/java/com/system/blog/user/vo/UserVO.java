package com.system.blog.user.vo;

import jakarta.validation.constraints.NotNull;
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

    @NotNull(message = "Please provide a author")
    private String name;

    @NotEmpty(message = "Please provide a author")
    private String passwd;

    @NotNull(message = "이메일을 입력하세요")
    private String email;

}
