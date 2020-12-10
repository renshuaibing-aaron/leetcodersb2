package com.aaron.ren.leet20200915;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {

        //注意这个和另外一个题的区别 另外一个题需要的是保证
        int j = 1, count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count <= 2) {
                //注意这个地方的区别  注意i会自动加的 j要进行手动加
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
    //使用双指针 优秀
    //采用双指针 真特码优秀
    public static  int removeDuplicates1(int[] nums) {
        int j=0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[j] == nums[i]) {
                //如果相同 只移动j位置
            } else {
                //如果不同 i的位置肯定移动 并且让j的位置的移动到i的下一个位置 牛逼
                nums[j + 1] = nums[i];
                j++;
            }
        }
        return j+1;
    }
}
