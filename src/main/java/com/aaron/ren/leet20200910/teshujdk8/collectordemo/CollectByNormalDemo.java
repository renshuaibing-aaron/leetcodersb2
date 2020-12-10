package com.aaron.ren.leet20200910.teshujdk8.collectordemo;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 一般情况下的聚集功能
 */
public class CollectByNormalDemo {

     //Arrays  注意这个类 也有大用
    public static List<Apple> orchard = Arrays.asList(new Apple("green", 150),
            new Apple("red", 170), new Apple("green", 100), new Apple("red", 170),
            new Apple("yellow", 170), new Apple("green", 150));

    public static void main(String[] args) {
        //
    }

    //设计一个方法 对list进行分类 按照颜色

    public Map<String,List<Apple>> collectByNormalJdk7(List<Apple>  applesList){
        Map<String,List<Apple>> res=new HashMap<>();
        for(Apple  apple: applesList){
            List<Apple> basket  = res.get(apple.getColor());
            if(basket.isEmpty()){
                basket=new ArrayList<>();
                res.put(apple.getColor(),basket);
            }
            basket.add(apple);
        }
        return res;
    }

    public Map<String,List<Apple>> collectByNormalJdk8(List<Apple>  applesList){
        Map<String, List<Apple>> baskets = new HashMap<>();
        applesList.forEach(apple -> {
            //这个尼玛  有是啥  获取list  没有就创建  有就获取
            List<Apple> basket = Optional.ofNullable(baskets.get(apple.getColor()))
                    .orElseGet(() -> {
                        List<Apple> tempbasket = new ArrayList<>();
                        baskets.put(apple.getColor(), tempbasket);
                        return tempbasket;
                    });
            //取到的值 放入
            basket.add(apple);

        });
        return  baskets;
    }

    public Map<String,List<Apple>> collectByJdk8Collect(List<Apple>  applesList){
        //尼玛  一行代码直接搞定 分组
        Map<String, List<Apple>> baskets = orchard.stream()
                .collect(Collectors.groupingBy(Apple::getColor));
        return  baskets;
    }



}
