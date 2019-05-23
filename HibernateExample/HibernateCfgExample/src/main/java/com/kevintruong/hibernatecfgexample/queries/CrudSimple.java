package com.kevintruong.hibernatecfgexample.queries;

import com.kevintruong.hibernatecfgexample.dao.StudentDAO;
import com.kevintruong.hibernatecfgexample.model.Student;

public class CrudSimple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		insertStudent();
//		deleteStudentById();
//		showStudent();
//		findStudentById();
//		updateStudentById();
		updateStudentById();
		searchFirstName();
	}
	
	public static void insertStudent() {
		StudentDAO studentdao = new StudentDAO();
		studentdao.save(new Student("hung1", "lehung", "hung1@gmail.com"));
		studentdao.save(new Student("hung2", "lehung", "hung2@gmail.com"));
		studentdao.save(new Student("hung3", "lehung", "hung3@gmail.com"));
		studentdao.save(new Student("hung4", "lehung", "hung4@gmail.com"));
		studentdao.save(new Student("hung5", "lehung", "hung5@gmail.com"));
	}
	public static void showStudent() {
		StudentDAO studentdao = new StudentDAO();
		studentdao.showAll();
	}
	public static void deleteStudentById() {
		StudentDAO studentdao = new StudentDAO();
		studentdao.delete(10);
		studentdao.delete(11);
		
	}
	public static void findStudentById() {
		StudentDAO studentdao = new StudentDAO();
		studentdao.findById(13);
	}
	public static void updateStudentById() {
		StudentDAO studentdao = new StudentDAO();
		studentdao.updateName(14, "KEVIN2");
	}
	
	public static void searchFirstName() {
		StudentDAO studentdao = new StudentDAO();
		studentdao.searchByName("K");
		
	}
	
}
