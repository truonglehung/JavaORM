package com.kevintruong.hibernatecfgexample.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.kevintruong.hibernatecfgexample.model.Student;
import com.kevintruong.hibernatecfgexample.utils.HibernateUtil;

public class StudentDAO {
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	public void save(Student student) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(student);
			session.getTransaction().commit();
			System.out.println("insert success!");
		}catch(RuntimeException ex) {
			session.getTransaction().rollback();
			ex.printStackTrace();
		}finally {
//			session.flush();
			session.close();
		}
	}
	
	public void showAll() {
	    Session session = sessionFactory.openSession();
	    List<Student> list = session.createQuery("from Student ",Student.class).list();
	    for (Student student : list) {
	      System.out.println(student.toString());
	    }
	  }
	
	public void delete(int id) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			Student student =session.load(Student.class, id);
			session.delete(student);
			session.getTransaction().commit();
			System.out.println("detete success!");
			
		}catch(RuntimeException e) {
			session.beginTransaction().rollback();
			e.printStackTrace();
		}finally {
//			session.flush();
			session.close();
		}
	}
	public Student findById(int id) {
		Session session = sessionFactory.openSession();
//		Student student  = session.load(Student.class, id);
		Student student  = session.get(Student.class, id);
		if(student==null) {
			System.out.println("Id not exist");
		}
		System.out.println(student);
		return student ;
	}
	public  void updateName(int id,String firstName) {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Query query = session.createSQLQuery(
			    "UPDATE Student st SET st.first_name= :newName WHERE st.id= :id");
		query.setParameter("newName", firstName);
		query.setParameter("id", id);
		int result = query.executeUpdate();
		session.getTransaction().commit();
		
	}
	public void searchByName(String name) {
		Session session  = sessionFactory.openSession();
		String strSql = "From Student where first_name like :name" ;
		Query query = session.createQuery(strSql);
		query.setParameter("name", "%" +name +"%");
		List<Student> students = query.list();
		for(Student stu: students) {
			System.out.println(stu);
		}
		
	}
}
