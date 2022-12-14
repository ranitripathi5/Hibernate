package com.cascade;

import com.map.Answer;
import com.map.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.net.spi.InetAddressResolverProvider;
import java.util.ArrayList;
import java.util.List;

public class CascadeExample {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure().buildSessionFactory();
        Session sesssion=factory.openSession();
         Question q=new Question();
         q.setQuestionId(11);
         q.setQuestion("What is nautanki");
         Answer ans1=new Answer(12,"very important concept");
         Answer ans2=new Answer(16, "I'm about to learn nautanki");
         Answer ans3=new Answer(17, "Let's learn nautanki");
        List<Answer> list=new ArrayList<>();
        list.add(ans1);
        list.add(ans2);
        list.add(ans3);

         q.setLi(list);
         Transaction tx=sesssion.beginTransaction();
         sesssion.save(q);
         //we will not need to save answers when we use cascading .
         //sesssion.save(ans1);
         //sesssion.save(ans2);
         //sesssion.save(ans3);
         tx.commit();
         sesssion.close();
         factory.close();
    }
}
