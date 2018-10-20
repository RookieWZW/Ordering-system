package com.rookiewzw.controller;

import com.rookiewzw.VO.ProductInfoVO;
import com.rookiewzw.VO.ProductVO;
import com.rookiewzw.VO.ResultVO;
import com.rookiewzw.dataobject.ProductCategory;
import com.rookiewzw.dataobject.ProductInfo;
import com.rookiewzw.service.CategoryService;
import com.rookiewzw.service.ProductService;
import com.rookiewzw.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by RookieWangZhiWei on 2018/9/27.
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list() {
        List<ProductInfo> productInfoList = productService.findUpAll();

        /*List<Integer> categoryTypeList = new ArrayList<>();

        for (ProductInfo productInfo :
                productInfoList) {
            categoryTypeList.add(productInfo.getCategoryType());
        }*/

        List<Integer> categoryTypeList = productInfoList.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());

        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        //数据拼装
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory :
                productCategoryList) {

            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();

            for (ProductInfo productInfo :
                    productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }

            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);

        }

        return ResultVOUtil.success(productVOList);
    }

}
