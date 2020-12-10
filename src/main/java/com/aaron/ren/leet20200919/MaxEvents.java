package com.aaron.ren.leet20200919;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaxEvents {


    // 1 2
    //  2 3
    //  3 4
    public static void main(String[] args) {
   int[][] arrays={{1,2},{2,3},{3,4}};
        System.out.println(maxEvents(arrays));
    }
    public static int maxEvents(int[][] events) {
        Set<Integer> set = new HashSet<>();
        //关键是这里怎么进行排序呢
        Arrays.sort(events, (first, second) -> first[1]==second[1]?
                first[0]-second[0]:first[1]-second[1]);

        System.out.println(Arrays.toString(events));

        for(int[] event: events) {
            for(int i = event[0]; i<=event[1]; i++) {
                if(set.add(i)) {
                    break;
                }
            }
        }
        return set.size();
    }
}
