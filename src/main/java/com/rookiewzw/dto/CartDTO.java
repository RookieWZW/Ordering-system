package com.rookiewzw.dto;

import lombok.Data;

/**
 * Created by RookieWangZhiWei on 2018/9/27.
 */
@Data
public class CartDTO {

    private String productId;

    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
