package com.opelyan.pattern.prototype;

import java.io.Serializable;

/**
 * @Discription: 浅克隆
 * @Author: Created by lyan on 2019/9/12 15:54
 */
public class Student implements Cloneable, Serializable {

    private int age;
    private String name;

    @Override
    public Object clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        return super.clone();
    }

    @Override
    public String toString() {
        return "Student [age=" + age + ", name=" + name + "]";
    }


    public Student(){


    }

    public Student(int age,String name){
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param args
     * @throws CloneNotSupportedException
     */
    public static void main(String[] args) throws CloneNotSupportedException {
        Student student1 = new Student(20, "张三");
        Student student2 = (Student) student1.clone();
        student2.setAge(22);// 注意修改student2的age值 但是没有影响 student1的值
        System.out.println("student1：" + student1.getName() + "-->"+ student1.getAge());
        System.out.println("student2：" + student2.getName() + "-->"+ student2.getAge());

    }

}
