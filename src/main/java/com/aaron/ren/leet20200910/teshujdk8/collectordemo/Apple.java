package com.aaron.ren.leet20200910.teshujdk8.collectordemo;

/**
 * 苹果类
 *  有两个属性   颜色和重量
 */
public class Apple{

    private String color;
    private Integer weight;

    public Apple(String color, Integer weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public Integer getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Apple [color=" + color + ", weight=" + weight + "]";
    }

}