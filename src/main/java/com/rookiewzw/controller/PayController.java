package com.rookiewzw.controller;

import com.lly835.bestpay.model.PayResponse;
import com.rookiewzw.dto.OrderDTO;
import com.rookiewzw.enums.ResultEnum;
import com.rookiewzw.exception.SellException;
import com.rookiewzw.service.OrderService;
import com.rookiewzw.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by RookieWangZhiWei on 2018/9/28.
 */
@Controller
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PayService payService;

    @GetMapping("/create")
    public ModelAndView create(@RequestParam("orderId") String orderId,
                               @RequestParam("returnUrl") String returnurl,
                               Map<String, Object> map) {

        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null) {
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        PayResponse payResponse = payService.create(orderDTO);

        map.put("payResponse", payResponse);
        map.put("returnUrl", returnurl);

        return new ModelAndView("pay/create", map);
    }


    @PostMapping("/notify")
    public ModelAndView notify(@RequestBody String notifyData) {
        payService.notify(notifyData);

        return new ModelAndView("pay/success");
    }
}
