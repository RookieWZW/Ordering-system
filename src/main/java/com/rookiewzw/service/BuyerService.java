package com.rookiewzw.service;

import com.rookiewzw.dto.OrderDTO;

/**
 * Created by RookieWangZhiWei on 2018/9/28.
 */
public interface BuyerService {

    OrderDTO findOrderOne(String openid,String orderId);

    OrderDTO cancelOrder(String openid,String orderId);
}
