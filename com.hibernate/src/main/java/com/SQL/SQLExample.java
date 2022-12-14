package com.SQL;

import org.example.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import java.util.Arrays;
import java.util.List;

public class SQLExample {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure().buildSessionFactory();
        Session session=factory.openSession();


        //sql query
        String q="select *from student1";
        //session.createSQLQuery(q);
        NativeQuery nq=session.createSQLQuery(q);
        List<Object[]> list=nq.list();
        for(Object[] st: list){
            System.out.println(Arrays.deepToString(st));
            //System.out.println(st.getStudentName()+" "+st.getCity());
        }

        session.close();
        factory.close();


    }
}
