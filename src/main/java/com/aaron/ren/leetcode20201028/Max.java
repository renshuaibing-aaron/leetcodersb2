package com.aaron.ren.leetcode20201028;

public class Max {
    public static void main(String[] args){
        int[] arr = new int[]{5,2,3,7,4,9,6,2,4,7};
        int maxi = arr[0];		//记录j之前最小的a[i]
        int maxMinus = 0;		//记录最大差值
        int a = 0;				//记录最大差值的i下标
        int b = 0;				//记录最大差值的j下标
        int temp = 0;			//暂存最大差值的i下标
        for (int j = 0; j < arr.length ; j++)
        {
            if ((arr[j] - maxi) > maxMinus)	//当小于当前的最大差值时
            {
                maxMinus = arr[j] - maxi;		//更新最大差值
                a = temp;
                b = j;

            }
            else if ((arr[j] - maxi) < 0)		//当小于当前最小的a[i]时
            {
                maxi = arr[j];				//更新最小的a[i]
                temp = j;
            }
        }
        System.out.println("最大差值是a[" + b + "]-[" + a + "]=" + maxMinus);
    }

}
