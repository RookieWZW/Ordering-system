package com.rookiewzw.VO;

import lombok.Data;

/**
 * Created by RookieWangZhiWei on 2018/9/27.
 */
@Data
public class ResultVO<T> {


    private Integer code;

    private String msg;

    private T data;
}
