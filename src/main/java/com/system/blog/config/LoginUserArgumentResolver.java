package com.system.blog.config;

import com.system.blog.user.vo.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
public class LoginUserArgumentResolver implements HandlerMethodArgumentResolver {

    private final HttpSession session;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        boolean loginAnnotation = parameter.hasParameterAnnotation(Login.class);
        return UserVO.class.isAssignableFrom(parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        UserVO loginVO = (UserVO) session.getAttribute("loginVO");
        if (loginVO == null) {
            throw new MyLoginException("로그인 해주세요");
        }
        return loginVO;
    }
}
