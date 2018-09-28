package com.rookiewzw.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by RookieWangZhiWei on 2018/9/28.
 */
public class JsonUtil {

    public static String toJson(Object object){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson  = gsonBuilder.create();
        return gson.toJson(object);
    }
}
