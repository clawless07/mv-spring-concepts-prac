package com.mv.hibernate.dao;

import com.mv.hibernate.model.Student;
import com.mv.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentDao {
    //saveStudent
    //getAllStudent
    //getStudentById
    //UpdateStudent
    //DeleteStudent

    public void saveStudent(Student student){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }

    }
}
