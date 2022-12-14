package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbedDemo {
    public static void main(String[] args) {
        Configuration cfg=new Configuration();
        cfg.addAnnotatedClass(org.example.Address.class);
        cfg.addAnnotatedClass(org.example.Student.class);

        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory=cfg.buildSessionFactory();
        // open a new Session


        Student student1=new Student();
        student1.setStudentName("virat");
        student1.setId(109);
        student1.setCity("Delhi");

        Certificate c=new Certificate();
        c.setCourse("Backend");
        c.setDuration("2 months");

        student1.setCerti(c);

        Student student2=new Student();
        student2.setStudentName("hardik");
        student2.setCity("Mumbai");
        student2.setId(110);

        Certificate c2=new Certificate();
        c2.setDuration("1 month");
        c2.setCourse("Hibernate");
        student2.setCerti(c2);

        Session session = sessionFactory.openSession();
        Transaction tx=session.beginTransaction();
         session.save(student1);
         session.save(student2);

         tx.commit();
         session.close();
        sessionFactory.close();
    }
}
