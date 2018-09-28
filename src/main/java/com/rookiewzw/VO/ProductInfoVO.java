package com.rookiewzw.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by RookieWangZhiWei on 2018/9/27.
 */
@Data
public class ProductInfoVO {

    @JsonProperty("id")
    private String productId;


    @JsonProperty("name")
    private String productName;

    @JsonProperty("price")
    private BigDecimal productPrice;

    @JsonProperty("description")
    private String productDescription;

    @JsonProperty("icon")
    private String productIcon;
}
