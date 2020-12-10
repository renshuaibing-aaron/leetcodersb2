package com.aaron.ren.leet20200909;


//最长的公共子串
public class GetLCstring {

    public static void main(String[] args) {
        System.out.println(gaxSubsequence("helloworld", "loop"));
    }

    //这个我写的比较简单  但是不是道是不是ok
    public static int gaxSubsequence(String text1, String text2){
        int length = text1.length();
        int length1 = text2.length();
        int[][] res=new int[length+1][length1+1];

        int  realres=0;
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= length1; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    res[i][j] = res[i - 1][j - 1] + 1;
                }else{
                    res[i][j]=0;
                }

                realres=Math.max(realres,res[i][j]);
            }
        }
        return realres;

    }
}
