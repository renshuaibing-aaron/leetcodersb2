package com.aaron.ren.leet20200915;

public class AddStrings {



    //1 2 3  1 2 3=2 4 6

    //大概不考
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        //用carry保留进位
        int carry = 0, i = num1.length()-1, j = num2.length()-1;
        while(i >= 0 || j >= 0 || carry != 0){

            if(i>=0) {
                carry = carry+num1.charAt(i)-'0';
                i--;
            }
            if(j>=0) {
                carry =carry+ num2.charAt(j)-'0';
                j--;
            }
            sb.append(carry%10);
            carry =carry/ 10;
        }
        //数据反转
        return sb.reverse().toString();
    }
}
