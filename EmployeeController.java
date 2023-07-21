package com.grocery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.grocery.model.Employee;
import com.grocery.service.EmployeeService;

@RestController
public class EmployeeController 
{
@Autowired
EmployeeService employeeService;
@GetMapping("/get/employee")
public List<Employee>getAllEmployee()
{
	return employeeService.getAllEmployee();
}
@PostMapping("/post/employee")
public void AddEmployee(@RequestBody List<Employee>employee) 
{
	employeeService.AddEmployeeService(employee);
}
@PutMapping("/put/{empId}")
public void UpdateEmployee(@PathVariable Integer empId,@RequestBody Employee employee) 
{
	employee.setEmpId(empId);
	employeeService.UpdateEmployee(employee);
}
@DeleteMapping("//delete/{empId}")
public void DeleteEmployee(@PathVariable Integer empId,@RequestBody Employee employee) 
{
	employeeService.DeleteEmployee(employee);
}
@GetMapping("/search/{empId}")
public Employee searchById(@PathVariable Integer empId)
{
	 return employeeService.SearchById(empId);
	
}


}
