package com.aaron.ren.leetcode20201102;

import java.util.Arrays;
import java.util.List;

public class Jinzhizhuanhuan {
    static Character[] nums = { '0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z' };
    //asList的返回对象是一个Arrays内部类,并没有实现集合的修改方法，后台的数据仍是数组。
    static List<Character> list = Arrays.asList(nums);

    public static void main(String[] args) {

        String str1="12";
        String str2="10";
        String r=f(str1,str2);
        System.out.println(r);
    }

    static String f(String str1, String str2) {
        //toCharArray()方法可以将字符串对象中的字符转换为一个字符数组
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        //数组从0开始，因此减1
        int i = s1.length - 1;
        int j = s2.length - 1;
        int temp = 0;// 进位
        //也可以使用StringBuffer,但是它比 StringBuilder要慢。 在 StringBuilder 上的主要操作是 append 和 insert 方法。
        StringBuilder sb = new StringBuilder();
        //两个相加的数的位数相同
        while (i >= 0 && j >= 0) {
            char c1 = s1[i];
            char c2 = s2[j];
            //返回指定字符在此字符串中第一次出现处的索引
            int index1 = list.indexOf(c1);
            int index2 = list.indexOf(c2);
            int sum = index1 + index2 + temp;
            if (sum >= 36) {
                temp = 1;
                //有进位时，用append()将余数进行拼接
                sb.append(list.get(sum % 36));
            } else {
                //没有进位时，直接将相加得到的数进行拼接
                temp=0;
                sb.append(list.get(sum));
            }
            //--是因为要从低位开始相加
            i--;
            j--;
        }
        //第一个数位数多于第二个数的位数
        while (i >= 0) {
            int sum = list.indexOf(s1[i]) + temp;
            if (sum >=36) {
                temp = 1;
                sb.append(list.get(sum % 36));
            } else {
                temp=0;
                sb.append(list.get(sum));
            }
            i--;
        }
        //第一个数位数小于第二个数的位数
        while (j >= 0) {
            int sum = list.indexOf(s2[j]) + temp;
            if (sum >=36) {
                temp = 1;
                sb.append(list.get(sum % 36));
            } else {
                temp=0;
                sb.append(list.get(sum));
            }
            j--;
        }
        //temp!=0说明有进位，这是需要把进位的1拼接
        if(temp!=0){
            sb.append('1');
        }
        //前面拼接是从个位开始的，也就是拼接出来的数跟所求的数是倒着的
        //reverse() 方法用于颠倒数组中元素的顺序
        return sb.reverse().toString();
    }
}
