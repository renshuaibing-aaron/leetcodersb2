package com.aaron.ren.leet20200912;

public class DistributeCandies2 {

    public int[] distributeCandies(int candies, int num_people) {

        int currgive = 0;
        int[] res = new int[num_people];

        while (candies > 0) {
            res[currgive % num_people] += Math.min(++currgive, candies);
            candies -= currgive;
        }

        return res;

    }

    public int[] distributeCandies2(int candies, int num_people) {

        int currgive = 0;
        int[] res = new int[num_people];

        while (candies > 0) {
            res[currgive % num_people] =res[currgive % num_people] + Math.min(++currgive, candies);
            candies=candies- currgive;
        }

        return res;

    }
}
