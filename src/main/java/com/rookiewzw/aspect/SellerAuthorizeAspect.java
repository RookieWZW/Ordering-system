package com.rookiewzw.aspect;

import com.rookiewzw.constant.CookieConstant;
import com.rookiewzw.constant.RedisConstant;
import com.rookiewzw.exception.SellerAuthorizeException;
import com.rookiewzw.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by RookieWangZhiWei on 2018/10/24.
 */

@Aspect
@Component
@Slf4j
public class SellerAuthorizeAspect {

    @Autowired
    private StringRedisTemplate redisTemplate;


    @Pointcut("execution(public * com.rookiewzw.controller.Seller*.*(..))" +
            "&& !execution(public * com.rookiewzw.controller.SellerUserController.*(..))")
    public void verify() {
    }


    @Before("verify()")
    public void doVerify() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = attributes.getRequest();

        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);

        if (cookie == null) {
            log.warn("Cookie is null");
            throw new SellerAuthorizeException();
        }


        String tokenValue = redisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_PRIEFIX, cookie.getValue()));
        if (StringUtils.isEmpty(tokenValue)) {
            log.warn("redis is not true token");
            throw new SellerAuthorizeException();
        }
    }
}
