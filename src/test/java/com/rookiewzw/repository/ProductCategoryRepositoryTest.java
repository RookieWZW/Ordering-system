package com.rookiewzw.repository;

import com.rookiewzw.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by RookieWangZhiWei on 2018/9/26.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {


    @Autowired
    private ProductCategoryRepository repository;



    @Test
    public void findOneTest(){
        ProductCategory productCategory = repository.findOne(1);
        System.out.println(productCategory.toString());
    }

    @Test
    @Transactional
    public void saveTest(){

        ProductCategory productCategory  = new ProductCategory("fourth ",5);

        ProductCategory productCategoryTemp = repository.save(productCategory);

        Assert.assertNotNull(productCategoryTemp);

        //Assert.assertNotEquals(null,productCategoryTemp);

    }

    @Test
    public void findByCategoryTypeIn(){
        List<Integer> list = Arrays.asList(2,3,4);


        List<ProductCategory> result=repository.findByCategoryTypeIn(list);


        Assert.assertNotEquals(0,result.size());
    }
}