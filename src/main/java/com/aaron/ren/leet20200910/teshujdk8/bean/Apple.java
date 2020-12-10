package com.aaron.ren.leet20200910.teshujdk8.bean;

public class Apple {

    private String color;   // 颜色
    private int weight;     // 重量

    public Apple(String color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple [color=" + color + ", weight=" + weight + "]";
    }

}