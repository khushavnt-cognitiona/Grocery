package com.grocery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.grocery.model.Employee;
import com.grocery.repository.EmployeeRepository;
@Service
public class EmployeeService 
{
@Autowired
EmployeeRepository employeeRepository;
	public List<Employee> getAllEmployee() {
		
		return employeeRepository.getAllEmployee();
	}
	public void AddEmployeeService(List<Employee> employee) {
		employeeRepository.AddEmployeeRepository(employee);
		
	}
	public void UpdateEmployee(Employee employee) 
	{
		int a=employeeRepository.UpdateEmployee(employee);
		if(a==0) 
		{
			System.out.println("please enter valid id");
		}
	}
	public void DeleteEmployee(Employee employee) {
		
		int a=employeeRepository.DeleteEmployee(employee);
		if(a==0) 
		{
			System.out.println("please enter valid id");
		}
	}
	public Employee SearchById(Integer empId) {
		
		 Employee employee= employeeRepository.SearchById(empId);
		 if( employee == null) 
		 { 
			 System.out.println("No employee Id is found ");
		 }
		return employee ;
	}

}
