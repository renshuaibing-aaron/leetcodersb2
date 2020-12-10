package com.aaron.ren.leet20200909;

public class Multiply {
    public String multiply(String num1, String num2) {

        Long integer1 = Long.valueOf(num1);
        Long integer2 = Long.valueOf(num2);
        Long  i = integer1 * integer2;
        return String.valueOf(i);
    }
}
