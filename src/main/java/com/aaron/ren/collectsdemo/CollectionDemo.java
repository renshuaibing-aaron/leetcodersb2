package com.aaron.ren.collectsdemo;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionDemo {

    public static void main(String[] args) {
        Arrays.asList();
    }

    private List<Person> removeduplicate(List<Person>  personList){

        return personList.stream().filter(val -> !Objects.isNull(val)).collect(Collectors.collectingAndThen(
                Collectors.toCollection(
                        () -> new TreeSet<>(Comparator.comparing(Person::getName))
                ), ArrayList::new));

    }

    private class Person {

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        private  String name;
        private  int   age;

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
