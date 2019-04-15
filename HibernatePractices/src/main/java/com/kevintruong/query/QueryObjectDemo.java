package com.kevintruong.query;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.kevintruong.entities.Employee;
import com.kevintruong.hibernate.HibernateUtils;

public class QueryObjectDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			session.getTransaction().begin();
			String sqlstr = "Select e from " + Employee.class.getName() + " e " + " order by e.empName, e.empNo ";
			Query<Employee> query = session.createQuery(sqlstr);
			List<Employee> employees = query.getResultList();
			for (Employee emp : employees) {
				System.out.println("Emp: " + emp.getEmpNo() + " : " + emp.getEmpName());
			}
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}

}