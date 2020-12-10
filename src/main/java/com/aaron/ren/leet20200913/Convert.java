package com.aaron.ren.leet20200913;

import java.util.ArrayList;
import java.util.List;

public class Convert {

    public String convert(String s, int numRows) {
        if(numRows<2){
            return  s;
        }
        List<StringBuilder> rows=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            rows.add(new StringBuilder());
        }

        //模拟 整个过程
        //这里设置flag太牛逼了
        int i=0,flag=-1;
        for(char c :s.toCharArray()){
        rows.get(i).append(c);
        if(i==0||i==numRows-1) {
            flag=-flag;
        }
        i=i+flag;
        }

        StringBuilder res=new StringBuilder();
        for(StringBuilder row :rows){
            res.append(row);
        }

        return res.toString();

    }
















}
