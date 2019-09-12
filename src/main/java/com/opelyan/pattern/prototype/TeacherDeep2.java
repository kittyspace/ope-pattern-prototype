package com.opelyan.pattern.prototype;

import java.io.*;

/**
 * @Discription: 深克隆
 * @Author: Created by lyan on 2019/9/12 16:07
 */
public class TeacherDeep2 implements Cloneable, Serializable {

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
        return "TeacherDeep2 [name=" + name + ", student=" + student + "]";
    }


    //通过序列化实现深克隆
    public Object deepClone(){
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            TeacherDeep2 copy = (TeacherDeep2) ois.readObject();
            return copy;

        }catch (Exception e){
            return null;
        }
    }

    //浅克隆  相当于没有改写过的Object的clone()
    public TeacherDeep2 shallowClone(TeacherDeep2 target){
        TeacherDeep2 teacher = new TeacherDeep2();
        teacher.setName(target.getName());
        teacher.setStudent(target.getStudent());
        return teacher;

    }


    public static void main(String[] args) throws CloneNotSupportedException {

        Student s = new Student();
        s.setAge(20);
        s.setName("张三");
        TeacherDeep2 teacher = new TeacherDeep2();
        teacher.setName("小赵老师");
        teacher.setStudent(s);

        //深克隆
        TeacherDeep2 deep = (TeacherDeep2)teacher.deepClone();
        Student s1 = deep.getStudent();
        s1.setName("李四");
        s1.setAge(30);
        System.out.println("teacher1:"+teacher);
        System.out.println("teacher2:"+deep);

        //浅克隆
        TeacherDeep2 shallow = (TeacherDeep2)teacher.shallowClone(teacher);
        Student s2 = shallow.getStudent();
        s2.setName("李四");
        s2.setAge(30);
        System.out.println("teacher1:"+teacher);
        System.out.println("teacher2:"+shallow);

        //浅克隆
        TeacherDeep2 shallow11 = (TeacherDeep2)teacher.clone();
        Student s21 = shallow11.getStudent();
        s21.setName("李四");
        s21.setAge(30);
        System.out.println("teacher1:"+teacher);
        System.out.println("teacher2:"+shallow11);





    }




}
