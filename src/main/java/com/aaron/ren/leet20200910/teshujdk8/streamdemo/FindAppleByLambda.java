package com.aaron.ren.leet20200910.teshujdk8.streamdemo;


import com.aaron.ren.leet20200910.teshujdk8.bean.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 未使用流的过滤器 需要首先进行过滤 然后进行排序 当然这里用了lambda表达式
 */
public class FindAppleByLambda {
    // 果园
    public static List<Apple> orchard = Arrays.asList(new Apple("green", 150),
            new Apple("green", 200), new Apple("yellow", 150),new Apple("red", 170));

    public static void main(String[] args) {

        // 这个条件是 找出所有绿苹果 并且 重量在150以上  然后 对结果进行排序 从大到小进行排序
        List<Apple> basket = appleFilterThenSort(orchard,
                apple -> "green".equals(apple.getColor()) ?
                        (apple.getWeight() > 150 ? true : false) : false);


        basket.forEach(System.out::println);
    }

    private static List<Apple> appleFilterThenSort(List<Apple> orchard, Predicate<Apple> predicate) {
        List<Apple> tempList = new ArrayList<>();
        for (Apple apple : orchard) {
            if(predicate.test(apple)) {
                tempList.add(apple);
            }
        }
        //进行排序 重大到小排序
        tempList.sort((o1,o2) -> o2.getWeight() - o1.getWeight());
        return tempList;
    }

}