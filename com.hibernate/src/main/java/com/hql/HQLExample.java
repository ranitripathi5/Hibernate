package com.hql;

import org.example.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;

public class HQLExample {
    public static void main(String[] args) {
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf=cfg.buildSessionFactory();
        Session session= sf.openSession();
        //HQL
        //Syntex:
        //String query = "FROM Student";
        String query="From Student as s where s.city=:c and s.studentName=:n"; // as alias
        Query q=session.createQuery(query);
        q.setParameter("c","Madhuban");
        q.setParameter("n","Shilpi");
        List<Student> li= q.list();
        for(Student s:li){
            System.out.println(s.getStudentName()+" "+s.getCity());
        }
        System.out.println("_______________________________________________");


        Transaction tx= session.beginTransaction();
        //. deletion
        //Query q2=session.createQuery("delete from Student s where s.studentName=:c");
        //q2.setParameter("c","Bhaggu");
        //.int r=q2.executeUpdate();
        //System.out.println("deleted:");
        //System.out.println(r);


        //update query
       // Query q3=session.createQuery("update Student set city=:c where studentName=:n");
        //q3.setParameter("c","Saukhor");
        //q3.setParameter("n","Shilpi");
        //int r=q3.executeUpdate();
        //System.out.println("updated");
        //System.out.println(r);


        // join query
        // needed - one - many relationship
        Query q4 = session.createQuery("select q.question, q.questionId, a.answer from Question as q INNER JOIN q.li as a ");
        List<Object []> list=q4.getResultList();
        for(Object[]arr:list){
            System.out.println(Arrays.toString(arr));
        }
        tx.commit();
        session.close();
        sf.close();
    }
}
