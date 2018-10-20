package com.rookiewzw.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by RookieWangZhiWei on 2018/9/28.
 */
@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeixinController {

    @GetMapping("/auth")
    public void auth(@RequestParam("code")String code){
        log.info("进入auth方法。。。");
        log.info("code={}", code);

        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx645b35f65d3c98cf&secret=1a133181d9f641cf8564f69d036824e3&code=" + code + "&grant_type=authorization_code";

        RestTemplate restTemplate = new RestTemplate();

        String response = restTemplate.getForObject(url,String.class);
        log.info("response={}", response);

    }
}
