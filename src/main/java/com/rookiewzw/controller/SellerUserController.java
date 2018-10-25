package com.rookiewzw.controller;

import com.rookiewzw.config.ProjectUrlConfig;
import com.rookiewzw.constant.CookieConstant;
import com.rookiewzw.constant.RedisConstant;
import com.rookiewzw.dataobject.SellerInfo;
import com.rookiewzw.enums.ResultEnum;
import com.rookiewzw.service.SellerService;
import com.rookiewzw.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by RookieWangZhiWei on 2018/10/23.
 */
@Controller
@RequestMapping("/seller")
public class SellerUserController {


    @Autowired
    private SellerService sellerService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    @GetMapping("/login")
    public ModelAndView login(@RequestParam("openid") String openid,
                              HttpServletResponse response,
                              Map<String, Object> map) {

        SellerInfo sellerInfo = sellerService.findSellerInfoByOpenId(openid);

        if (sellerInfo == null) {
            map.put("msg", ResultEnum.LOGIN_FAIL.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error");
        }

        String token = UUID.randomUUID().toString();

        Integer exprie = RedisConstant.EXPRIE;

        redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_PRIEFIX, token), openid, exprie, TimeUnit.SECONDS);

        CookieUtil.set(response, CookieConstant.TOKEN, token, exprie);

        return new ModelAndView("redirect:" + projectUrlConfig.getSell() + "/sell/seller/order/list");


    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request,
                               HttpServletResponse response,
                               Map<String, Object> map) {

        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);

        if (cookie != null) {
            redisTemplate.opsForValue().getOperations().delete(String.format(RedisConstant.TOKEN_PRIEFIX, cookie.getValue()));

            CookieUtil.set(response, CookieConstant.TOKEN, null, 0);
        }


        map.put("msg", ResultEnum.LOGOUT_SUCCESS.getMessage());
        map.put("url", "/sell/seller/order/list");

        return new ModelAndView("common/success", map);

    }
}
