package com.rookiewzw.service.impl;

import com.rookiewzw.dataobject.SellerInfo;
import com.rookiewzw.repository.SellerInfoRepository;
import com.rookiewzw.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by RookieWangZhiWei on 2018/10/23.
 */
@Service
public class SellerServiceImpl implements SellerService {


    @Autowired
    private SellerInfoRepository sellerInfoRepository;


    @Override
    public SellerInfo findSellerInfoByOpenId(String openid) {

        return sellerInfoRepository.findByOpenid(openid);
    }


}
