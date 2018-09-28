package com.rookiewzw.utils;

import java.util.Random;

/**
 * Created by RookieWangZhiWei on 2018/9/27.
 */
public class KeyUtil {

    public static synchronized String genUniqueKey() {

        Random random = new Random();

        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }
}
