package com.capgemini.core.ems.service;

import java.util.List;

import com.capgemini.core.ems.beans.Employee;
import com.capgemini.core.ems.exceptions.EMSExceptions;

public interface EmployeeService {

	public int addEmployee(Employee employees) throws EMSExceptions;
	
	public Employee getEmployee(int id) throws EMSExceptions;
	
	public void updateEmployee(Employee employees) throws EMSExceptions;

	public Employee removeEmployee(int id) throws EMSExceptions;
	
	public List<Employee> getAllEmployees() throws EMSExceptions;

	public boolean isValid(Employee employees) throws EMSExceptions;
}
