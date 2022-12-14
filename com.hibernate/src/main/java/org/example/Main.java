package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
        Configuration cfg=new Configuration();
        cfg.addAnnotatedClass(org.example.Address.class);
        cfg.addAnnotatedClass(org.example.Student.class);

        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory=cfg.buildSessionFactory();
        // open a new Session
        Session session = sessionFactory.openSession();
        //System.out.println(sessionFactory);
        //createing student
        Student st=new Student();
        st.setId(108);
        st.setStudentName("Bhaggu");
        st.setCity("Sonbhadra");
        System.out.println(st);

        // object of address
         Address ad=new Address();
         ad.setAddId(101);
         ad.setStreet("mathia");
         ad.setCity("Ratanpura");
         ad.setOpen(true);
         ad.setAddedDate(new Date());
         ad.setX(1.11);
         // image

        FileInputStream fis=new FileInputStream("src/main/resources/thorDaHathoda.jpg");
        byte[] data =new byte[fis.available()];
        ad.setImage(data);
       // Session session=sessionFactory.getCurrentSession();
        //session.beginTransaction();
        //session.save(st);
        //session.getTransaction().commit();// this can also be Written as
         Transaction tx=session.beginTransaction();
        session.save(st);
        session.save(ad);
        tx.commit();
        session.close();
    }
}