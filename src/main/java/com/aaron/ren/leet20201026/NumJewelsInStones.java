package com.aaron.ren.leet20201026;

import java.util.HashSet;
import java.util.Set;

public class NumJewelsInStones {

    public int numJewelsInStones(String J, String S) {

Set<Character> set=new HashSet<>();
        char[] chars = J.toCharArray();

        for(char item:chars){
            set.add(item);
        }

        int num=0;
        char[] chars1 = S.toCharArray();
        for(char  item :chars1){
            if(set.contains(item)){
                num=num+1;
            }
        }

        return num;
    }
}
