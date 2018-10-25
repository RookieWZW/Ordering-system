package com.rookiewzw.service;

import com.rookiewzw.dto.OrderDTO;

/**
 * Created by RookieWangZhiWei on 2018/10/24.
 */
public interface PushMessageService {

    void orderStatus(OrderDTO orderDTO);

}
