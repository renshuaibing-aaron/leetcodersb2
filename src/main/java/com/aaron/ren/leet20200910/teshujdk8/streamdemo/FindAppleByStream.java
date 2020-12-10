package com.aaron.ren.leet20200910.teshujdk8.streamdemo;



import com.aaron.ren.leet20200910.teshujdk8.bean.Apple;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 流的操作
 *  什么情况下使用流
 *   一个数据源(集合)
 *   零个或者多个中间操作(中间操作会返回一个新的流)
 *   一个终止操作(终止操作会关闭流)
 */
public class FindAppleByStream {

    public static List<Apple> orchard = Arrays.asList(new Apple("green", 150),
            new Apple("green", 200), new Apple("yellow", 150),new Apple("red", 170));

    public static void main(String[] args) {
        List<Apple> basket = orchard.stream()
                .filter(apple -> "green".equals(apple.getColor()) ?
                        (apple.getWeight() > 150 ? true : false) : false)   //过滤

                .sorted((o1, o2) -> o2.getWeight()- o1.getWeight())   //排序

                .collect(Collectors.toList());  //输出

        basket.forEach(System.out::println);  //打印
    }

    public static  void  streamtest(){
        Stream<Double> limit = Stream.generate(Math::random).limit(10);
        limit.forEach(System.out::println);
    }

    public static  void  streamtest2(){
    /*    Stream<T> filter(Predicate<? super T> predicate);  过滤机制

        Stream<T> sorted(Comparator<? super T> comparator);   排序机制
*/
    }





}