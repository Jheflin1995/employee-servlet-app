package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Employees;
import com.revature.util.HibernateUtil;

public class EmployeeDao {
//CRUD
	
	public int insert(Employees e) {
		
		Session ses = HibernateUtil.getSession();
		
		Transaction tx = ses.beginTransaction();
		
		int pk = (int) ses.save(e);
		
		return pk;
		
	}
	
	public List<Employee>findAll(){
		
		Session ses = HibernateUtil.getSession();
		
		//HQL - Hibernate Query Langauge: odd mix of OOP and Native SQL
		
		List<Employees>emps = ses.createQuery("from Employees", Employees.class).list();
		
		return emps;
		
	}
	
	public boolean delete(int id) {
		return false;
	}
	
	public boolean update(Employee e) {
		return false;
	}
}
