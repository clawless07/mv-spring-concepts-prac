package com.mv.hibernate;

import com.mv.hibernate.model.Student;
import com.mv.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {
    public static void main(String[] args) {
        Student student = new Student("Mak", "Gamer", "abc.xyz@email.com");
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
        }catch (Exception e){
           e.printStackTrace();
           if(transaction != null){
                transaction.rollback();
            }
        }
    }
}
