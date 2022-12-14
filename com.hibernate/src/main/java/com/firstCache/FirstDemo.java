package com.firstCache;

import org.example.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FirstDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure().buildSessionFactory();
        Session session=factory.openSession();
        // first level cache(by Default enabled)
        Student student=session.get(Student.class, 103);
        System.out.println(student);

        // for the first time , hibernate will fire select query, ans session will keep it in its cache
        Student student1=session.get(Student.class,103);
        System.out.println(student1);
        // the second time the session is called to get the object , hibernate will not hit the database
        // instead, it will get to the session cache and get the result.
        System.out.println(session.contains(student1));// it will return true because session already has the object


        session.close();
        factory.close();
    }
}
