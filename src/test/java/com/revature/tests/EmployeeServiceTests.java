package com.revature.tests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.revature.dao.EmployeeDao;
import com.revature.models.Employee;
import com.revature.service.EmployeeService;

public class EmployeeServiceTests {

	private EmployeeService eserv;
	private EmployeeDao mockdao;
	
	@Before
	public void setup() {
		mockdao = mock(EmployeeDao.class);
		eserv = new EmployeeService(mockdao);
		
		
	}
	
	@After
	public void teardown() {
		
		mockdao = null;
		eserv = null;
	}
	
	@Test
	public void testConfrimLogin_success() {
		
		
//		1.Create a fake list of employees 
//		this is the dummy data we feed to Mockito
		
		Employee e1 = new Employee(20, "Bruce", "Banner", "thehulk", "green");
		Employee e2 = new Employee(20, "Clint", "Barton", "hawkeye", "arrows");
		
		List<Employee> emps = new ArrayList<Employee>();
		emps.add(e1);
		emps.add(e2);
//		
//		2. Set up the mock dao's behavior
//		findAll() method's behavior to provide fake data
		
		when(mockdao.findAll()).thenReturn(emps);
		
//		capture the actual output of the method
		
		Employee actual = eserv.confirmLogin("thehulk", "green");
//		capture the expected output of the method
//		
		Employee expected = e1;
//		asser that they're equal
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void testConfrimLogin_failure() {
		
		
//		1.Create a fake list of employees 
//		this is the dummy data we feed to Mockito
		
		Employee e1 = new Employee(20, "Bruce", "Banner", "thehulk", "green");
		Employee e2 = new Employee(20, "Clint", "Barton", "hawkeye", "arrows");
		
		List<Employee> emps = new ArrayList<Employee>();
		emps.add(e1);
		emps.add(e2);
//		
//		2. Set up the mock dao's behavior
//		findAll() method's behavior to provide fake data
		
		when(mockdao.findAll()).thenReturn(emps);
		
//		capture the actual output of the method
		
		Employee actual = eserv.confirmLogin("failman", "ufail");
//		capture the expected output of the method
//		
		Employee expected = new Employee();
//		asser that they're equal
		
		assertEquals(expected,actual);
	}
}
