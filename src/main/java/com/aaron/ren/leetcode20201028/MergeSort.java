package com.aaron.ren.leetcode20201028;

public class MergeSort {
    static void mergesort(int[] arr, int[] result, int start, int end) {
        if (start >= end) {
            return;
        }
        int len = end - start, mid = (len >> 1) + start;
        int start1 = start, end1 = mid;
        int start2 = mid + 1, end2 = end;


        mergesort(arr, result, start1, end1);
        mergesort(arr, result, start2, end2);

        int k = start;
        while (start1 <= end1 && start2 <= end2) {
            result[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
        }
        while (start1 <= end1) {
            result[k++] = arr[start1++];
        }
        while (start2 <= end2) {
            result[k++] = arr[start2++];
        }
        for (k = start; k <= end; k++) {
            arr[k] = result[k];
        }
    }

    public static void merge_sort(int[] arr) {
        int len = arr.length;
        int[] result = new int[len];
        mergesort(arr, result, 0, len - 1);
    }
}
