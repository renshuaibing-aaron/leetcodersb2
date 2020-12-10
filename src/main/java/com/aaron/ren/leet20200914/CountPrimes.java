package com.aaron.ren.leet20200914;

public class CountPrimes {

    public int countPrimes(int n) {

        int count=0;
        if(n<2){
            return 0;
        }
        for(int i=0;i<n;i++){

          if(  check(i)){

              count++;
          }
        }
        return  count-2;
    }

    private boolean check(int num) {

        //什么是质数  只能被其自身和1整除
        int k = (int) Math.sqrt(num);//k为num的正平方根，取整数
        for (int i = 2; i <= k; i++) {
            if (num % i == 0) {
               return false;
            }
        }

        return true;
    }
}
