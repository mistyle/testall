package com.example.demo.test.serializable.clone;

import java.io.IOException;

/**
 * 腾讯课堂搜索 咕泡学院
 * 加群获取视频：608583947
 * 风骚的Michael 老师
 * 这个个深克隆
 */
public class CloneDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Teacher teacher=new Teacher();
        teacher.setName("mic");

        Student student=new Student();
        student.setName("沐风");
        student.setAge(35);
        student.setTeacher(teacher); //teacher设置进去

        Student student2=(Student) student.deepClone(); //克隆一个对象 student2
        System.out.println(student.getTeacher()); //1. 打印student

        //student2.getTeacher().setName("james");
        System.out.println(student2.getTeacher()); //2. 打印student2
        /**
         * 打印:
         * com.example.demo.test.serializable.clone.Student@3941a79c
         * com.example.demo.test.serializable.clone.Student@45ff54e6
         *
         * 注意克隆出来的对象跟原来不是一个对象，只是引用的对象也复制了
         *
         * student里面的teacher也变了
         * com.example.demo.test.serializable.clone.Teacher@3d494fbf
         * com.example.demo.test.serializable.clone.Teacher@45ff54e6
         */

    }
}


