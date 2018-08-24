
package com.capgemini.core.ems.model;

import java.util.List;

import com.capgemini.core.ems.beans.Employee;
import com.capgemini.core.ems.exceptions.EMSExceptions;


public interface EmployeeDAO {
	public int addEmployee(Employee employee) throws EMSExceptions;
	public Employee getEmployee(int id) throws EMSExceptions;
	public void updateEmployee(Employee employee) throws EMSExceptions;
	public Employee removeEmployee(int id) throws EMSExceptions;
	public List<Employee> getAllEmployees() throws EMSExceptions;
}
