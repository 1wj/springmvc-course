package com.bjpowernode.vo;

public class Student {
    private  String name;
    private Integer age;

    public Student() {
        System.out.println("这是student的无参构造");
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("setName"+name);
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
        System.out.println("setAge"+age);
    }

    @Override
    public String toString() {
        return "Strudent{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
