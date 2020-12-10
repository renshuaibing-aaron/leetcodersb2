package com.aaron.ren.leet20200914;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Partition {
    //输入: "aab"
    //输出:
    //[
    //  ["aa","b"],
    //  ["a","a","b"]
    //]
    public List<List<String>> partition(String s) {

        if (s.length() == 0) {
            return new ArrayList<>();
        }
        int length = s.length();

        List<List<String>> res = new ArrayList<>();

        Deque<String> path = new LinkedList<>();
        dfs(s, res, path, 0, length);

        return res;
    }

    private void dfs(String s, List<List<String>> res, Deque<String> path, int start, int length) {

        if (start == length) {
            res.add(new ArrayList<>(path));
        }
        for (int right = start; right < length; right++) {
            if (!checkPalindrome(s, start, right)) {
                continue;
            }
            path.addLast(s.substring(start, right + 1));
            dfs(s, res, path, right + 1, length);
            path.removeLast();

        }

    }

    /**
     * 这一步的时间复杂度是 O(N)，因此，可以采用动态规划先把回文子串的结果记录在一个表格里
     *  怎么判断回文
     * @param str
     * @param left  子串的左边界，可以取到
     * @param right 子串的右边界，可以取到
     * @return
     */
    private boolean checkPalindrome(String str, int left, int right) {
        // 严格小于即可
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
