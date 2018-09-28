package com.rookiewzw.service;

import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;
import com.rookiewzw.dto.OrderDTO;

/**
 * Created by RookieWangZhiWei on 2018/9/28.
 */
public interface PayService {
    PayResponse create(OrderDTO orderDTO);

    PayResponse notify(String notifyData);

    RefundResponse refund(OrderDTO orderDTO);

}
