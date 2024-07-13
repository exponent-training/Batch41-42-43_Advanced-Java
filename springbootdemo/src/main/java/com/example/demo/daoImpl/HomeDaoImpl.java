package com.example.demo.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.HomeDaoi;
import com.example.demo.model.Student;

@Repository
public class HomeDaoImpl implements HomeDaoi{

	@Autowired
	private SessionFactory sf;
	
	@Override
	public void addStudentData(Student student) {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		session.save(student);
		session.beginTransaction().commit();
		System.out.println("Done");
	}

}
