package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;

public class MainApp {
    public static void main(String[] args) {
        Configuration configuration=new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory= configuration.buildSessionFactory();
        Session session= sessionFactory.openSession();
        Transaction transaction= session.beginTransaction();
        Course course=new Course();
        course.setName("Physics");

        Course course1=new Course();
        course1.setName("Arduino");
        Student student=new Student();
        student.setName("Ak");
        ArrayList<Course> courses=new ArrayList<>();
        courses.add(course);
        courses.add(course1);
        student.setCourses(courses);

        Course course2=new Course();
        course2.setName("Chemistry");

        Course course3=new Course();
        course3.setName("Biology");

        Course course4=new Course();
        course4.setName("Maths");
        Student student1=new Student();
        student1.setName("KK");
        ArrayList<Course> courses1=new ArrayList<>();
        courses1.add(course2);
        courses1.add(course3);
        courses1.add(course4);
        student1.setCourses(courses1);

        session.save(student);
        session.save(student1);
        transaction.commit();
    }
}
