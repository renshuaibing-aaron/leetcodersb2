package com.aaron.ren.leet20200913;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LexicalOrder {

    // 字典排序
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();

        List<String> strlist = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            strlist.add(String.valueOf(i));
        }

        Collections.sort(strlist);
        for (String str : strlist) {
            res.add(Integer.valueOf(str));
        }
        return res;

    }
}
