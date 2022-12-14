package com.pagination;

import org.example.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HQLPagination {
    public static void main(String[] args) {
        SessionFactory sf=new Configuration().configure().buildSessionFactory();
        Session session=sf.openSession();
        Query query=session.createQuery("from Student");

        //implementing pagination using hibernate
        query.setFirstResult(0);
        query.setMaxResults(5);
        List<Student>list=query.list();
        for(Student st:list){
            System.out.println(st.getStudentName());
        }

        sf.close();
    }
}
