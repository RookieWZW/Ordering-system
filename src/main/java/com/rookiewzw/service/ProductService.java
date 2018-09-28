package com.rookiewzw.service;

import com.rookiewzw.dataobject.ProductInfo;
import com.rookiewzw.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by RookieWangZhiWei on 2018/9/27.
 */
public interface ProductService {


    ProductInfo findOne(String productId);

    List<ProductInfo> findUpAll();

    ProductInfo save(ProductInfo productInfo);

    Page<ProductInfo> findAll(Pageable pageable);


    void increaseStock(List<CartDTO> cartDTOList);

    void decreaseStock(List<CartDTO> cartDTOList);

    ProductInfo onSale(String productId);

    ProductInfo offSale(String productId);



}
