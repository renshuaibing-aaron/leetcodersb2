package com.aaron.ren.leet20200919;

import java.util.Comparator;
import java.util.PriorityQueue;

public class GetLeastNumbers {

    private  int k;

    public int[] getLeastNumbers(int[] arr, int k) {

        //求最小的k个数

        //设置大根
        PriorityQueue<Integer>  queue=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for(int num:arr){
            if(queue.size()<k){
                queue.offer(num);
            }else{
                if(queue.peek()>num){
                    queue.poll();
                    queue.offer(num);
                }

            }

        }

        //怎么把里面的数据打捞起来
        int[] res=new int[k];
        for(int i=0;i<k;i++){
            res[i]=queue.poll();
        }

        return res;
    }
}
