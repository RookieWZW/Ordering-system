package com.rookiewzw.form;

import lombok.Data;

/**
 * Created by RookieWangZhiWei on 2018/10/20.
 */
@Data
public class CategoryForm {


    private Integer categoryId;

    /** 类目名字. */
    private String categoryName;

    /** 类目编号. */
    private Integer categoryType;
}
