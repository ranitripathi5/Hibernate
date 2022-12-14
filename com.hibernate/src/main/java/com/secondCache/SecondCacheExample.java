package com.secondCache;

//import net.sf.ehcache.hibernate.EhCacheRegionFactory;

//import net.sf.ehcache.hibernate.EhCacheRegionFactory;
import net.sf.ehcache.hibernate.EhCacheRegionFactory;
import org.example.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SecondCacheExample {
    public static void main(String[] args) {
        //EhCacheRegionFactory
        SessionFactory factory=new Configuration().configure().buildSessionFactory();
        //first
        Session session1=factory.openSession();
        Student student1=session1.get(Student.class,103);
        System.out.println(student1);

        //second
        Session session2=factory.openSession();
        Student student2=session2.get(Student.class, 103);
        System.out.println(student2);

        session1.close();
        session2.close();
        factory.close();
    }
}
