package com.capgemini.core.ems.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import com.capgemini.core.ems.beans.Employee;
import com.capgemini.core.ems.exceptions.EMSExceptions;
import com.capgemini.core.ems.util.DBUtil;


public class EmployeeDAOImpl implements EmployeeDAO {

	public int addEmployee(Employee employee) throws EMSExceptions {
		
		int employeeId = 0;		
		try (Connection con = DBUtil.getConnection()){
			
			//-----generate empId---------
			Statement stm = con.createStatement();
			ResultSet res = stm.executeQuery("select empId_seq.nextVal from dual");
			
			
			if(res.next() == false) {
				throw new EMSExceptions("Could not generate empId");
				}
			employeeId = res.getInt(1);
			employee.setId(employeeId);
			
			
			//----insert emp details-----
			
			PreparedStatement pstm = con.prepareStatement("insert into Employee values(?,?,?,?,?,?)");
			
			pstm.setInt(1,  employee.getId());
			pstm.setString(2, employee.getName());
			pstm.setDouble(3, employee.getSalary());
			pstm.setString(4, employee.getDepartment());
			pstm.setDate(5, new java.sql.Date(employee.getDateOfBirth().getTime()));
			pstm.setDate(6, new java.sql.Date(employee.getDateOfJoining().getTime()));
			
			
		}		
		catch(Exception e) {
			throw new EMSExceptions(e.getMessage());
		}		
		return employeeId;
	}	
	

	public Employee getEmployee(int id) throws EMSExceptions {
		
		Employee emp = null;
		try(Connection con = DBUtil.getConnection()){
			
			PreparedStatement pstm = con.prepareStatement("select * from Employee where id = ?");
			
			pstm.setInt(1, id);
			ResultSet res = pstm.executeQuery();
			
			if(res.next() == false)
				throw new EMSExceptions("No employee with id " + id);
			
			emp = new Employee();
			
			emp.setId(res.getInt(1));
			emp.setName(res.getString(2));
			emp.setSalary(res.getDouble(3));
			emp.setDepartment(res.getString(4));			
			emp.setDateOfBirth(res.getDate(5));
			emp.setDateOfJoining(res.getDate(6));
		}
		
		catch (Exception e) {
			e.printStackTrace();
		} 
	
		return emp;
	}

	
	
	
	public void updateEmployee(Employee employee) throws EMSExceptions {
		
	}

	
	
	public Employee removeEmployee(int id) throws EMSExceptions {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Employee> getAllEmployees() throws EMSExceptions {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
