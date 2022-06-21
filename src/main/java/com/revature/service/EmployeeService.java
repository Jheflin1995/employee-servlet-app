package com.revature.service;

import java.util.List;
import java.util.Optional;

import com.revature.dao.EmployeeDao;
import com.revature.models.Employees;

public class EmployeeService {

	private EmployeeDao edao;
	
	public EmployeeService(EmployeeDao edao) {
		
		this.edao = edao;
	}
	
	public Employees confirmLgoin(String username, String password) {
		
		Optional<Employees> possibleEmp = edao.findAll().stream()
				.filter(e ->(e.getUsername().equals(username) && e.getPassword().equals(password)))
				.findFirst();
		
		return (possibleEmp.isPresent() ? possibleEmp.get() : new Employees());
		
	}
	
	public List<Employees> getAll(){
		
		return edao.findAll();
		}
}


