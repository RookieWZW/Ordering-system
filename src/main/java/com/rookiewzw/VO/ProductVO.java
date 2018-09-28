package com.rookiewzw.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by RookieWangZhiWei on 2018/9/27.
 */

@Data
public class ProductVO {

    @JsonProperty("name")
    private String categoryName;


    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;

}
