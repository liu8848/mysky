package com.sky.interceptor;

import com.sky.constant.JwtClaimsConstant;
import com.sky.exception.BaseException;
import com.sky.properties.JwtProperties;
import com.sky.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@Slf4j
public class JwtTokenAdminInterceptor implements HandlerInterceptor {
    @Autowired
    private JwtProperties jwtProperties;

    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception{
        if(!(handler instanceof HandlerMethod)){
            return true;
        }

        //1.从请求头中获取令牌
        String token=request.getHeader(jwtProperties.getAdminTokenName());
        //2.校验令牌
        try{
            log.info("jwt校验：{}",token);
            Claims claims= JwtUtil.parseJWT(jwtProperties.getAdminSecretKey(),token);
            Long empId=Long.valueOf(claims.get(JwtClaimsConstant.EMP_ID).toString());
            log.info("当前员工id:{}",empId);
            return true;
        }catch (Exception ex){
            throw new BaseException(ex.getMessage());
        }
    }
}
