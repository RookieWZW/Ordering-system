package com.rookiewzw.repository;

import com.rookiewzw.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by RookieWangZhiWei on 2018/9/26.
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {

    List<ProductCategory> findByCategoryTypeIn(List<Integer>  categoryTypeList);

}



