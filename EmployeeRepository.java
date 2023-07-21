package com.grocery.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.grocery.mapper.EmployeeMapper;
import com.grocery.model.Employee;
@Repository
public class EmployeeRepository {
@Autowired
JdbcTemplate jdbcTemplate;
	public List<Employee> getAllEmployee() 
	{
		String sql="SELECT * FROM grossarymgmt.employee";
		List<Employee>employee=jdbcTemplate.query(sql, new EmployeeMapper());
		return employee;
	}
	public void AddEmployeeRepository(List<Employee> employee) {
		String sql="INSERT INTO `grossarymgmt`.`employee` (`emp_id`, `fname`, `lname`, `adhaarno`, `panno`, `address`, `pincode`, `mobileno`, `email`, `card_no`, `username`, `password`, `accountno`, `salary`, `reporting_id`, `birthdate`, `role_id`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.batchUpdate(sql,new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setInt(1,employee.get(i).getEmpId());
				ps.setString(2,employee.get(i).getFname());
				ps.setString(3, employee.get(i).getLname());
				ps.setString(4, employee.get(i).getAdhaarcard());
				ps.setString(5,employee.get(i).getPanno());
				ps.setString(6, employee.get(i).getAddress());
				ps.setString(7, employee.get(i).getPincode());
				ps.setString(8, employee.get(i).getMobiile());
				ps.setString(9,employee.get(i).getEmail());
				ps.setString(10, employee.get(i).getCardno());
				ps.setString(11, employee.get(i).getUsername());
				ps.setString(12, employee.get(i).getPassword());
				ps.setString(13, employee.get(i).getAccountno());
				ps.setDouble(14,employee.get(i).getSalary());
				ps.setInt(15,employee.get(i).getReportingId());
				ps.setString(16, employee.get(i).getDateofbirth());
				ps.setInt(17, employee.get(i).getRoleId());
			}
			
			@Override
			public int getBatchSize() {
				
				return employee.size();
			}
		});
			
	}
	public int UpdateEmployee(Employee employee) 
	{
		String sql="UPDATE grossarymgmt.employee SET fname = ?, lname = ?, adhaarno = ?, panno = ?, address = ?, pincode = ?, mobileno = ?, email = ?, card_no = ?, username = ?, password = ?, accountno = ?, salary = ?, reporting_id = ?, birthdate = ? WHERE emp_id = ?";
		return jdbcTemplate.update(sql,employee.getFname(),employee.getLname(),employee.getAdhaarcard(),employee.getPanno(),
				employee.getAddress(),employee.getPincode(),employee.getMobiile(),employee.getEmail(),
				employee.getCardno(),employee.getUsername(),employee.getPassword(),employee.getAccountno(),
				employee.getSalary(),employee.getReportingId(),employee.getDateofbirth(),employee.getEmpId());
	}
	public int DeleteEmployee(Employee employee) {
		String sql="delete from grossarymgmt.employee where emp_id=? ";
		return jdbcTemplate.update(sql,employee.getEmpId());
	}
	public Employee SearchById(Integer empId) {
		String sql="select * from grossarymgmt.employee where emp_id=? ";
		Object[]param= {empId};
		List<Employee> employee= jdbcTemplate.query(sql, param,new EmployeeMapper());
		return employee.isEmpty() ? null :  employee.get(0);
		
	}
}
