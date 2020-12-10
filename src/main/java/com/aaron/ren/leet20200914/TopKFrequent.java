package com.aaron.ren.leet20200914;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TopKFrequent {

    public static void main(String[] args) {

        String[] str={"beijing","hangzhou","hangzhou", "beijing","beijing","shanghai","shanghai","shanghai"};

        List<Map.Entry<String, Long>> collect = Arrays.stream(str)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((o1, o2) -> {
                    if (o1.getValue().equals(o2.getValue())) {
                        //这个是按照字典进行排序
                        return o1.getKey().compareTo(o2.getKey());
                    } else {
                        //这个是按照有大大小进行排序
                        return o2.getValue().compareTo(o1.getValue());
                    }
                })
                .collect(Collectors.toList());

        System.out.println(collect);

    }

    public static  List<String> topKFrequent(String[] words, int k) {

        //这个特码 不要太优秀啊
        return Arrays.stream(words)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((o1, o2) -> {
                    if (o1.getValue().equals(o2.getValue())) {
                        return o1.getKey().compareTo(o2.getKey());
                    } else {
                        return o2.getValue().compareTo(o1.getValue());
                    }
                })
                .map(Map.Entry::getKey)
                .limit(k)
                .collect(Collectors.toList());

    }
}
