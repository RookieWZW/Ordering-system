package com.rookiewzw.service.impl;

import com.rookiewzw.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by RookieWangZhiWei on 2018/9/27.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {
    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void findOne() throws Exception {

        ProductCategory productCategory = categoryService.findOne(1);
        Assert.assertEquals(new Integer(1),productCategory.getCategoryId());
    }

    @Test
    public void findAll() throws Exception {

        List<ProductCategory> productCategoryList = categoryService.findAll();

        Assert.assertNotEquals(null,productCategoryList.size());
    }

    @Test
    public void findByCategoryTypeIn() throws Exception {

        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(Arrays.asList(1,2,3,4));
        Assert.assertNotEquals(0,productCategoryList.size());
    }


    @Test
    public void save() throws Exception {

        ProductCategory productCategory = new ProductCategory("south",6);
        ProductCategory productCategoryTemp = categoryService.save(productCategory);

        Assert.assertNotNull(productCategoryTemp);
    }

}