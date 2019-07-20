package com.reptiles.pp.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Paul Lee
 */
public class UrlUtil {

    /**
     * 获得人民网要爬的网页
     *
     * @return
     */
    public static List<String> getPPUrl() {

        List<String> list = new ArrayList();

        //时政页面
        list.add("http://politics.people.com.cn/");
        //财经页面
        list.add("http://finance.people.com.cn/");
        //军事页面
        list.add("http://military.people.com.cn/");
        //教育页面
        list.add("http://edu.people.com.cn/");
        //文化页面
        list.add("http://culture.people.com.cn/");

        return list;
    }

    /**
     * 设置要爬的基础网址
     *
     * @return
     */
    public static String getBaseUrl() {
        return "http://www.people.com.cn/";
    }
}
