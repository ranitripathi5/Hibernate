package com.map1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class ManyToManyMapping {
    public static void main(String[] args) {
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf=cfg.buildSessionFactory();//uildSessionFactory();

        Employee e1=new Employee();
        e1.setEmpId(1);
        e1.setEmployee("Virat");

        Employee e2=new Employee();
        e2.setEmpId(2);
        e2.setEmployee("Anushka");

        Project p1=new Project();
        p1.setProjectId(1);
        p1.setProject("Acting");

        Project p2=new Project();
        p2.setProjectId(2);
        p2.setProject("Cricket");

        List<Employee>l1=new ArrayList<>();
        List<Project>l2=new ArrayList<>();

        l1.add(e1);
        l1.add(e2);

        l2.add(p1);
        l2.add(p2);

        e1.setProjects(l2);
        p2.setEmployees(l1);

        Session session=sf.openSession();
        Transaction tx= session.beginTransaction();

        session.save(e1);
        session.save(e2);
        session.save(p2);
        session.save(p1);

        tx.commit();
        session.close();
        sf.close();
    }
}
