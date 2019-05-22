package com.example.demo.test.serializable.copy;

import java.io.IOException;

/**
 * 腾讯课堂搜索 咕泡学院
 * 加群获取视频：608583947
 * 风骚的Michael 老师
 * 这个类是复制，类似于浅克隆clone,但会调构造方法，clone不会调构造方法
 */
public class CloneDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Teacher teacher=new Teacher();
        teacher.setName("mic");

        Student student=new Student();
        student.setName("沐风");
        student.setAge(35);
        student.setTeacher(teacher);

        Student student2=student;
        System.out.println(student.getTeacher());

        student2.getTeacher().setName("james");
        System.out.println(student2.getTeacher());

        /**
         * teacher没有变
         * com.example.demo.test.serializable.copy.Teacher@12edcd21
         * com.example.demo.test.serializable.copy.Teacher@12edcd21
         */


    }
}
