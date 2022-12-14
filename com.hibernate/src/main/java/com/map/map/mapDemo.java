package com.map.map;

import com.map.Answer;
import com.map.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class mapDemo {
    public static void main(String[] args) {
        Configuration cfg=new Configuration();//on();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory= cfg.buildSessionFactory();

        //question object being saved
        Question q1=new Question();
        q1.setQuestionId(1);
        q1.setQuestion("What is Java?");

        /*Question q2=new Question();
        q2.setQuestionId(2);
        q2.setQuestion("What is backend?");
        */
        //crating answer object
        Answer an1=new Answer();
        an1.setAnswerId(1);
        //an1.setAnswer("Backend is bigger nautanki");
        an1.setAnswer("i program in java");

        Answer an2=new Answer();
        an2.setAnswerId(2);
        an2.setAnswer("java is nautanki");
        an1.setQ(q1);
        an2.setQ(q1);
        // making list of answers fro questions
        List<Answer> li=new ArrayList<>();
        li.add(an1);
        li.add(an2);


       // q1.setAnswer(an2);
        q1.setLi(li);
      //  q2.setAnswer(an1);
        Session session=factory.openSession();
        Transaction tx=session.beginTransaction();

        //saving
            session.save(q1);
            //session.save(li);
            session.save(an1);
            session.save(an2);


        /*fetching

        Question q=(Question)session.get(Question.class,1);
        System.out.println(q.getQuestion());
        for(Answer a:q.getLi()){
            System.out.println(a.getAnswer());
        }*/

        tx.commit();
        session.close();
        factory.close();
    }
}
