package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class dataFetching {
    public static void main(String[] args) {
        //get
        //load
        Configuration cfg=new Configuration();
        cfg.addAnnotatedClass(org.example.Address.class);
        cfg.addAnnotatedClass(org.example.Student.class);

        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory=cfg.buildSessionFactory();
        // open a new Session
        Session session = sessionFactory.openSession();

        //get - throws null if object with given primary key not found
        Student stud=(Student)session.get(Student.class,102);

        //load throws exception if object with given primary key is not found, unlike get it doesn't give null value.
        Address ad=(Address)session.load(Address.class, 1);
        System.out.println(stud);
        System.out.println(ad);

        session.close();
        sessionFactory.close();
    }
}
