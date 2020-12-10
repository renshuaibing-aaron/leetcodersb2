package com.aaron.ren.interview;

public class MaxString {

    public static String maxString(String str) {
        if (str==null||str.length()==0) {
            return "";
        }
        //假设重复的字符串相隔1,2,3,4,...str.length();
        int k=0;
        int max=0;
        int first=0;
        for (int i = 1; i < str.length(); i++) {
            //从当前位置开始，将相隔i 的重复的求出来！
            for (int j = 0; j < str.length()-i; j++) {
                if (str.charAt(j)==str.charAt(i+j)) {
                    k++;
                }else {
                    k=0;
                }
                if (k>max) {
                    max=k;
                    first=j-k+1;//实质为：j-(k-1)
                }
            }
            k=0;
        }

        return str.substring(first, first+max);
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(maxString("abdcdyedhjhyed"));
    }

}
