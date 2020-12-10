package com.aaron.ren.leet20200915;

public class FindDuplicateNew {
    public int findDuplicateNew(int[] nums) {
        int start = 1;
        int end = nums.length;
        while (start <= end) {
            //            取中值
            int middle = start + ((end - start) >> 1);
            //            计算从开始值到中值区间内有多少数字。
            int tempCount = countRange(nums, start, middle);
            //            如果已经区间已经缩小的到了只有一个数了，那么就可以判断在区间内的数字是不是有两个了。
            if (start == end) {
                if (tempCount > 1) {
                    return start;
                } else {
                    break;
                }
            }

            //            区间就是 中值- 开始值 + 1。然后开始和计数比较。
            int range = middle - start + 1;
            if (tempCount > range) {
                end = middle;
            } else if (tempCount <= range) {
                start = middle + 1;
            }
        }
        return -1;
    }

    //    计数比较，时间复杂度为O(n)
    private int countRange(int[] nums, int start, int end) {
        int count = 0;
        for (int item : nums) {
            if (item >= start && item <= end ) {
                count++;
            }
        }
        return count;
    }
}
