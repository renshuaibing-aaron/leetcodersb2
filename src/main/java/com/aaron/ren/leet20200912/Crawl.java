package com.aaron.ren.leet20200912;

import java.util.ArrayList;
import java.util.List;

public class Crawl {

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {

        List<String> urls = htmlParser.getUrls(startUrl);
        //感觉要使用正则表达式
        return  null;

    }


     // This is the HtmlParser's API interface.
     // You should not implement it, or speculate about its implementation
     class HtmlParser {
           List<String> getUrls(String url) {
               return new ArrayList<>();
           }
     }
}
