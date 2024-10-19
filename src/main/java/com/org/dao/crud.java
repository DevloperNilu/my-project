package com.org.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.org.dto.Student;
import java.util.Scanner;
public class crud {
public void insertStudent(Student std) {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("Nilu");
EntityManager em=emf.createEntityManager();
EntityTransaction et=em.getTransaction();
Scanner sc=new Scanner(System.in);
System.out.println("ENTER YOUR ID");
int id=sc.nextInt();
std.setId(id);
System.out.println("ENTER YOUR AGE");
int age=sc.nextInt();
std.setAge(age);
System.out.println("ENTER YOUR NAME");
String name=sc.next();
std.setName(name);
System.out.println("ENTER YOUR EMAIL ID");
String email=sc.next();
std.setEmail(email);
System.out.println("ENTER YOUR PASSWORD");
String password=sc.next();
std.setPassword(password);
et.begin();
em.persist(std);
et.commit();
System.out.println("DATA INSERTED");
}
public Student fetchStudentById(int id) {
EntityManagerFactory emf=Persistence.createEntityManagerFactory("Nilu");
EntityManager em=emf.createEntityManager();
	Student std=em.find(Student.class, id);
	if(std!=null)
	return std;
	else
	return null;
}
public Student removeStudentById(int id) {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("Nilu");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	Student std=em.find(Student.class, id);
	et.begin();
	em.remove(std);
	et.commit();
	System.out.println("DATA DELETED");
	return std;
}
public void updateStudent(Student std) {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("Nilu");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	Scanner sc=new Scanner(System.in);
	if(std!=null) {
		for(String i="exi";!i.equals("exit");) {
			System.out.println("WHAT DOU YOU WANT TO UPDATE??");
			System.out.println("id,name,age,email,password");
			System.out.println("TO EXIT TYPE exit");
			i=sc.next();
			switch(i) {
			case "id":
				System.out.println("ENTER YOUR ID");
				int id1=sc.nextInt();
				std.setId(id1);
				break;
			case "age":
				System.out.println("ENTER YOUR AGE");
				int age=sc.nextInt();
				std.setAge(age);
				break;
			case "name":
				System.out.println("ENTER YOUR NAME");
				String name=sc.next();
				std.setName(name);
				break;
			case "email":
				System.out.println("ENTER YOUR EMAIL");
				String email=sc.next();
				std.setEmail(email);
				break;
			case "password":
				System.out.println("ENTER YOUR PASSWORD");
				String password=sc.next();
				std.setPassword(password);
				break;
				default:
					System.out.println("DON'T MAKE SPELLING MISTAKES");
					break;
			}
		}
		et.begin();
		em.merge(std);
		et.commit();
		System.out.println("DATA UPDATED");
	}
}
}
