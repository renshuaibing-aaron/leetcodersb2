package com.aaron.ren.leet20200915;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class CopyBeanProperties {

    public static void main(String[] args) throws IllegalAccessException {

        Foot zhangsanfoot = new Foot("zhangsanfoot");
        Person zhangsan = new Person("zhangsan", 10,zhangsanfoot);
        Person person = new Person();

        copyBeanProperties(zhangsan, person);

        System.out.println(person.name);
        System.out.println(person.age);
        System.out.println(person.foot.name);
    }

    //浅拷贝 利用反射 只是引用
    public static void copyBeanProperties(Object srcObj, Object destObj) throws IllegalAccessException {

        if(srcObj.getClass().getName()!=destObj.getClass().getName()){
            return;
        }
        Field[] srcFields = srcObj.getClass().getDeclaredFields();

        Field[] destfields = destObj.getClass().getDeclaredFields();

        Map<String, Object> map = new HashMap<>();
        for (Field field : srcFields) {
            field.setAccessible(true);
            map.put(field.getName(), field.get(srcObj));
        }

        //类型判断？
        for (Field file : destfields) {
            file.setAccessible(true);
            if (map.get(file.getName()) != null) {
                file.set(destObj, map.get(file.getName()));
            }
        }

    }

    private static class Person {
        private String name;
        private int age;

        private Foot foot;

        public Person(String name, int age, Foot foot) {
            this.name = name;
            this.age = age;
            this.foot = foot;
        }

        public Person() {

        }


    }

    private static class  Foot{
        private  String name;

        public Foot(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
