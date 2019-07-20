package com.reptiles.pp;

import com.reptiles.pp.service.CrawlNewsService;
import com.reptiles.pp.utils.UrlUtil;

import java.io.*;

/**
 * @author Paul Lee
 */
public class Main {

    public static void main(String[] args) throws IOException {

        for (String url : UrlUtil.getPPUrl()) {
            CrawlNewsService crawlNewsService = new CrawlNewsService(url);
            crawlNewsService.parseFirstUrl();
        }
    }
}

