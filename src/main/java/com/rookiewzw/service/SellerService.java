package com.rookiewzw.service;

import com.rookiewzw.dataobject.SellerInfo;

/**
 * Created by RookieWangZhiWei on 2018/10/23.
 */
public interface SellerService {


    SellerInfo findSellerInfoByOpenId(String openid);
}
