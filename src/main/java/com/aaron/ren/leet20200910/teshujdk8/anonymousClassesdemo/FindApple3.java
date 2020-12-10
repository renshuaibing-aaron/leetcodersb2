package com.aaron.ren.leet20200910.teshujdk8.anonymousClassesdemo;


import com.aaron.ren.leet20200910.teshujdk8.bean.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindApple3 {
    public static List<Apple> orchard = Arrays.asList(new Apple("green", 150),
            new Apple("green", 200), new Apple("yellow", 150), new Apple("red", 170));

    public static void main(String[] args) {
        List<Apple> basket = appleFilter(orchard, new AppleCheck() {
            @Override
            public boolean test(Apple apple) {
                return apple.getWeight() > 150;
            }
        });
        System.out.println(basket);
    }

    // 根据指定条件找苹果(条件可以随意变更)
    private static List<Apple> appleFilter(List<Apple> orchard, AppleCheck appleCheck) {
        List<Apple> temp = new ArrayList<>();
        for (Apple apple : orchard) {
            if (appleCheck.test(apple)) {
                temp.add(apple);
            }
        }
        return temp;
    }
}