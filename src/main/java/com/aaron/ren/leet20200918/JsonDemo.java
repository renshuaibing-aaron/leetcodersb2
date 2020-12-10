package com.aaron.ren.leet20200918;

import com.alibaba.fastjson.JSON;

public class JsonDemo {

    public static void main(String[] args) {
        Person person=new Person("122","11",null);
       String variable = JSON.toJSONString(person);

        System.out.println(variable);
    }

    static class Person{
        private String name;
        private String address;
        private String age;

        public Person(String name, String address, String age) {
            this.name = name;
            this.address = address;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }
    }

}
