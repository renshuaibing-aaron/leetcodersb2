package com.aaron.ren.leet20200915;

import java.util.List;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        //初始化
        dp[0] = true;
        //遍历  放弃
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {

                //利用动态规划但是这个动态规划 太特码南翔了
                dp[i] = dp[j] && wordDict.contains(s.substring(j, i));
                if (dp[i]) {
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
