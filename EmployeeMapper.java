package com.grocery.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.grocery.model.Employee;

public class EmployeeMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
	Employee employee=new Employee();
	employee.setEmpId(rs.getInt("emp_id"));
	employee.setFname(rs.getString("fname"));
	employee.setLname(rs.getString("lname"));
	employee.setAdhaarcard(rs.getString("adhaarno"));
	employee.setPanno(rs.getString("panno"));
	employee.setAddress(rs.getString("address"));
	employee.setPincode(rs.getString("pincode"));
	employee.setMobiile(rs.getString("mobileno"));
	employee.setEmail(rs.getString("email"));
	employee.setCardno(rs.getString("card_no"));
	employee.setUsername(rs.getString("username"));
	employee.setPassword(rs.getString("password"));
	employee.setAccountno(rs.getString("accountno"));
	employee.setSalary(rs.getDouble("salary"));
	employee.setReportingId(rs.getInt("reporting_id"));
	employee.setDateofbirth(rs.getString("birthdate"));
	employee.setRoleId(rs.getInt("role_id"));
		return employee;
	}

}
