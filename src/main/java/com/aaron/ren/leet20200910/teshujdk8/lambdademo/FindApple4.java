package com.aaron.ren.leet20200910.teshujdk8.lambdademo;


import com.aaron.ren.leet20200910.teshujdk8.anonymousClassesdemo.AppleCheck;
import com.aaron.ren.leet20200910.teshujdk8.bean.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://blog.csdn.net/xiliunian/article/details/88343762
 */
public class FindApple4 {

    public static List<Apple> orchard = Arrays.asList(new Apple("green", 150),
            new Apple("green", 200), new Apple("yellow", 150), new Apple("red", 170));
    public static void main(String[] args) {


        // 使用Lambda表达式代替匿名内部类
        List<Apple> basket = appleFilter(orchard, apple -> apple.getWeight() > 150);
        System.out.println(basket);
    }

    private static List<Apple> appleFilter(List<Apple> orchard, AppleCheck appleCheck) {
        List<Apple> temp = new ArrayList<>();
        for (Apple apple : orchard) {
            if(appleCheck.test(apple)) {
                temp.add(apple);
            }
        }
        return temp;
    }

}