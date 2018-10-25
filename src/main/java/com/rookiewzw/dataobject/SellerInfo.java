package com.rookiewzw.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by RookieWangZhiWei on 2018/10/23.
 */
@Data
@Entity
public class SellerInfo {

    @Id
    private String Id;

    private String username;

    private String password;

    private String openid;
}
