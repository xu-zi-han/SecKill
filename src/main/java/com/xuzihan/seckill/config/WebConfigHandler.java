package com.xuzihan.seckill.config;

import com.xuzihan.seckill.domain.SecKillUser;
import com.xuzihan.seckill.service.SecKillUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ZihanXu
 * @version 1.0
 */

@Service
public class WebConfigHandler implements HandlerMethodArgumentResolver {

    @Autowired
    SecKillUserService secKillUserService;

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        Class<?> clazz = methodParameter.getParameterType();
        return clazz == SecKillUser.class;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer,
                        NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        HttpServletResponse httpServletResponse = nativeWebRequest.getNativeResponse(HttpServletResponse.class);
        HttpServletRequest httpServletRequest = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
        String cookieToken = getCookieValue(httpServletRequest , "token");
        String paramToken = httpServletRequest.getParameter("token");
        if(cookieToken == null && paramToken == null){
            return null;
        }
        String token = cookieToken == null ? paramToken : cookieToken;
        return secKillUserService.getByToken(httpServletResponse , token);
    }

    private String getCookieValue(HttpServletRequest httpServletRequest, String cookieName) {
        Cookie[] cookies = httpServletRequest.getCookies();
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals(cookieName)){
                return cookie.getValue();
            }
        }
        return null;
    }
}
