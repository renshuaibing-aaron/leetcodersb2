package com.aaron.ren.leet20200915;

public class LongestPalindromeSubseq {



    //最长回文子序列
    //"bbbab"
    public int longestPalindromeSubseq(String s) {

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromeOld("bbbab"));
        System.out.println(longestPalindrome("bbbab"));
        System.out.println(longestPalindromeSubseq2("bbbab"));
    }
    public static  int longestPalindromeSubseq2(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];

        //说实话 这个我的确不知道怎么办啊
        for(int i=0;i<len;i++){
                dp[i][i]=1;
            for(int j=i-1;j>=0;j--){
                if(s.charAt(i) == s.charAt(j)) {
                    dp[j][i]= dp[j+1][i-1]+2;
                } else {
                    dp[j][i]=Math.max(dp[j][i-1], dp[j+1][i]);
                }
            }
        }
        return dp[0][len-1];
    }






    public static  String longestPalindromeOld(String s) {
        if(s.isEmpty()){
            return s;
        }
        // zheg
        String res=s.substring(0,1);
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String k=s.substring(i,j);
                String rk=new StringBuffer(k).reverse().toString();
                if(k.equals(rk)&&k.length()>res.length()){
                    res=k;
                }
            }

        }
        return res;
    }

    //最长回文字串
    public static String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return s;
        }
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int left = 0;
        int right = 0;
        for (int i = n - 2; i >= 0; i--) {
            dp[i][i] = true;
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) &&( j-i<3||dp[i+1][j-1]);//小于3是因为aba一定是回文
                if(dp[i][j]&&right-left<j-i){
                    left=i;
                    right=j;
                }
            }
        }
        return s.substring(left,right+1);

    }
}
