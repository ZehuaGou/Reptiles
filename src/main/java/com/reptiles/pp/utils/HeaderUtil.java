package com.reptiles.pp.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Paul Lee
 * <p>
 * 请求头工具类
 */
public class HeaderUtil {

    /**
     * 设置人民网请求头信息
     *
     * @return
     */
    public static Map<String, String> getPPHeader() {
        Map<String, String> header = new HashMap<>(5);
        header.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
        header.put("Accept-Encoding", "gzip, deflate");
        header.put("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8,en-US;q=0.7");
        header.put("Cache-Control", "no-cache");
        header.put("Connection", "keep-alive");
        header.put("Cookie", "wdcid=146c5fd2574f4b10; ALLYESID4=11B407875C6F206A; _people_ip_new_code=450000; _ma_tk=8ezkjs1trz8e9lm64ozk6eyydn0xqhue; _ma_starttm=1559286228077; sso_c=0; sfr=1; _ma_is_new_u=0; wdlast=1559289092; wdses=42738c8e88c08bb4");
        header.put("Host", "world.people.com.cn");
        header.put("Pragma", "no-cache");
        header.put("Referer", "http://www.people.com.cn/");
        header.put("Upgrade-Insecure-Requests", "1");
        header.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36");

        return header;
    }
}
