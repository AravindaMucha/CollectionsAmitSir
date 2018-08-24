package com.capgemini.core.ems.service;

import java.util.List;

import com.capgemini.core.ems.beans.Employee;
import com.capgemini.core.ems.exceptions.EMSExceptions;
import com.capgemini.core.ems.model.EmployeeDAO;
import com.capgemini.core.ems.model.EmployeeDAOImpl;

public class EmployeeServiceImpl implements EmployeeService {

	//loose coupling - done by INTERFACE
	private EmployeeDAO empDAO;
	
	public EmployeeServiceImpl() {
		//association - (link) --- done by CONSTRUCTOR 
		empDAO = new EmployeeDAOImpl();
	}
	
	public int addEmployee(Employee employees) throws EMSExceptions {
		
		int empId = 0;
		
		if(isValid(employees)) //----if validation is required----
			empId = empDAO.addEmployee(employees);
		
		return empId;
	}

	public Employee getEmployee(int id) throws EMSExceptions {
		
		Employee employee = null;
		
		employee = empDAO.getEmployee(id);
		
		return employee;
	}

	public void updateEmployee(Employee employees) throws EMSExceptions {
		empDAO.updateEmployee(employees);

	}

	public Employee removeEmployee(int id) throws EMSExceptions {
		
		Employee employees = null;
		
		employees = empDAO.removeEmployee(id);
		
		return employees;
	}

	public List<Employee> getAllEmployees() throws EMSExceptions {
		
		List<Employee> employees = null;
		
		employees = empDAO.getAllEmployees();
				
		return employees;
		
	}

	public boolean isValid(Employee employees) throws EMSExceptions {
		// TODO Auto-generated method stub
		return true; //---Assuming that validation has occured---else it could be false
	}

}
