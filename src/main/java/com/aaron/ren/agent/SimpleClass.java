package com.aaron.ren.agent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class SimpleClass {
    public static void main( String[] args ) throws IOException {
        System.out.println("===========执行main方法=============");
        fetch("http://www.baidu.com");
        fetch("http://www.163.com");
    }

    private static void fetch(final String address) throws IOException {

        final URL url = new URL(address);
        final URLConnection connection = url.openConnection();

        try (final BufferedReader in = new BufferedReader(
                new InputStreamReader( connection.getInputStream())
        )){
            String inputLine = null;
            final StringBuffer sb = new StringBuffer();
            while ( (inputLine = in.readLine()) != null){
                sb.append(inputLine);
            }

            System.out.println("Content size:" + sb.length());
            System.out.println("Content size:" + sb);
        }

    }

}
