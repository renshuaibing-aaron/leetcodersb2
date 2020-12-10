package com.aaron.ren.leet20200914;

import java.util.HashSet;
import java.util.Set;

public class NumJewelsInStones {
    public int numJewelsInStones(String J, String S) {

        char[] chars = S.toCharArray();
        int ans=0;
        for(char c:chars){
            if(J.indexOf(c)!=-1){
                ans++;
            }

        }
        return  ans;
    }
}
