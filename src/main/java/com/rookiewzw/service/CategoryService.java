package com.rookiewzw.service;

import com.rookiewzw.dataobject.ProductCategory;

import java.util.List;

/**
 * Created by RookieWangZhiWei on 2018/9/27.
 */
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);


}
