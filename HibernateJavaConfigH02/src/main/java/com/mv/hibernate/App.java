package com.mv.hibernate;

import com.mv.hibernate.dao.StudentDao;
import com.mv.hibernate.model.Student;

public class App {
    public static void main(String[] args) {
        Student student = new Student("Mak", "COder", "abc.xyz@email.com");
        new StudentDao().saveStudent(student);
    }
}
