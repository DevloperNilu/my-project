package com.org.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.org.dao.crud;
import com.org.dto.Student;

import java.util.Scanner;
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
EntityManagerFactory emf=Persistence.createEntityManagerFactory("Nilu");
EntityManager em=emf.createEntityManager();
EntityTransaction et=em.getTransaction();
Scanner s=new Scanner(System.in);
Student std=new Student();
crud c=new crud();
for(int i=1;i!=5;) {
	System.out.println("---------------------WELCOME TO MY APP-----------------------");
	System.out.println("IF YOU WANT TO INSERT THEN PRESS 1");
	System.out.println("IF YOU WANT TO FETCH THEN PRESS 2");
	System.out.println("IF YOU WANT TO UPDATE THEN PRESS 3");
	System.out.println("IF YOU WANT TO DELETE THEN PRESS 4");
	System.out.println("IF YOU WANT TO EXIT THEN PRESS 5");
	i=s.nextInt();
	switch(i) {
	case 1:
		c.insertStudent(std);
		break;
	case 2:
		System.out.println("ENTER YOUR ID");
		int id=s.nextInt();
	std=em.find(Student.class, id);
	if(std!=null) {
	std=c.fetchStudentById(id);
	 System.out.println("-------DETAILS-------");
	System.out.println("STUDENT ID : "+	std.getId());
	System.out.println("STUDENT NAME : "+std.getName());
	System.out.println("STUDENT AGE : " +std.getAge());
	System.out.println(	"STUDENT EMAIL : "+std.getEmail());
	System.out.println("STUDENT PASSWORD : "+std.getPassword());
	}
	else
		System.out.println("404 NOT FOUND");
		break;
	case 3:
		System.out.println("ENTER THE ID");
		id=s.nextInt();
		std=em.find(Student.class, id);
		if(std!=null) {
			c.updateStudent(std);
		}
		else
			System.out.println("404 NOT FOUND");
		break;
	case 4:
		System.out.println("ENTER YOUR ID");
		id=s.nextInt();
		std=em.find(Student.class, id);
		if(std!=null) {
			c.removeStudentById(id);
		}
		else
			System.out.println("404 NOT FOUND");
		break;
	case 5:
		System.out.println("EXITING");
		break;
		default:
			System.out.println("Enter a valid number to do crud operation");
			break;
	}
}
System.out.println("------THANKS FOR VISITING------");
	}

}
