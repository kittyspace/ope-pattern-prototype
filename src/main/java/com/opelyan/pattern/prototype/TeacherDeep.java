package com.opelyan.pattern.prototype;

/**
 * @Discription: 深克隆
 * @Author: Created by lyan on 2019/9/12 16:07
 */
public class TeacherDeep implements Cloneable {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    private String name;
    private Student student;

    @Override
    public String toString() {
        return "TeacherDeep [name=" + name + ", student=" + student + "]";
    }


    //注意：通过重写clone里面逻辑实现了深克隆
    @Override
    public Object clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        //注意以下代码
         TeacherDeep teacher = (TeacherDeep)super.clone();
         teacher.setStudent((Student)teacher.getStudent().clone());
         return teacher;
    }


    public static void main(String[] args) throws CloneNotSupportedException {
        Student s1 = new Student();
        s1.setAge(20);
        s1.setName("张三");
        TeacherDeep teacher1 = new TeacherDeep();
        teacher1.setName("小赵老师");
        teacher1.setStudent(s1);
        //为什么会出现以下结果, Teacher中的clone方法
        TeacherDeep teacher2 = (TeacherDeep)teacher1.clone();
        Student s2 = teacher2.getStudent();
        s2.setName("李四");
        s2.setAge(30);
        System.out.println("teacher1:"+teacher1);
        System.out.println("teacher2:"+teacher2);

    }



}
