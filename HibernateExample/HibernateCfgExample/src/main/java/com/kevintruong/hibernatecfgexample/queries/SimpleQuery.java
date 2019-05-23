package com.kevintruong.hibernatecfgexample.queries;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.kevintruong.hibernatecfgexample.model.Student;
import com.kevintruong.hibernatecfgexample.utils.HibernateUtil;

public class SimpleQuery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 	Student student = new Student("Ramesh3", "Fadatare", "rameshfadatare@javaguides.com");
	        Student student1 = new Student("John3", "Cena", "john@javaguides.com");
	        Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // save the student objects
	            session.save(student);
	            session.save(student1);
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        	
	            List < Student > students = session.createQuery("from Student", Student.class).list();
	            for (Student stu : students) {
	                System.out.println("Emp: " +stu.getFirstName());
	            }
	            
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	    }
	}


