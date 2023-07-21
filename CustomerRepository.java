package com.grocery.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.grocery.mapper.CustomerMapper;
import com.grocery.model.Customer;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

@Repository
public class CustomerRepository
{
	 @Autowired 
	 JdbcTemplate jdbcTemplate; 
	  
	 @Autowired 
	 NamedParameterJdbcTemplate template; 
	 
	 public List<Customer> getCustomer() { 
	  //String sql = "Select * from user"; 
	  String sql="SELECT c.custmer_id, c.firstname, c.lastname, c.mobile, c.email, c.adharno,c.address, c.pincode, c.username, c.password, r.rolename from custmer c JOIN roles r ON c.role_id = r.role_id " ; 
	    
	  List<Customer> response = jdbcTemplate.query(sql, new CustomerMapper()); 
	  return response; 
	 } 
	 
	 public void addCustomer(Customer cust) { 
	  String sql = "insert into grossarymgmt.custmer values(?,?,?,?,?,?,?,?,?,?,?)"; 
	  // jdbcTemplate.update(sql, 
	  // cust.getEmpId(),emp.getEmpFName(),emp.getEmpLName(),emp.getEmpMobNO(),emp.getEmpPosition(),emp.getEmpSalary()); 
	  jdbcTemplate.update(sql, cust.getCustomerId(), cust.getFirstname(), cust.getLastname(), cust.getMobile(), 
	    cust.getEmail(), cust.getAdharno(), cust.getAddress(), cust.getPincode(), cust.getUsername(), 
	    cust.getPassword(), cust.getRoleId()); 
	 
	 } 
	 //"SELECT d.dealerid, d.firstname, d.lastname, d.mobileno, d.email, d.adhaarno, d.panno, " 
	 //// + "d.accountno, d.address, d.pincode, d.username, d.password, r.rolename from dealer d " 
	  //+ "JOIN role r ON d.roleid = r.roleid_d " ; 
	 
	 
	 public Customer userLogin(String email, String password) { 
	  String sql="SELECT * FROM grossarymgmt.custmer where email=:email and password=:password"; 
	  //String sql="SELECT u.emailid,u.password FROM  
	  MapSqlParameterSource param = new MapSqlParameterSource("email", "%gmail.com%"); 
	  param.addValue("password",password); 
	  param.addValue("email", email); 
	  List<Customer> result = template.query(sql, param, new CustomerMapper()); 
	  return (CollectionUtils.isEmpty(result) ? null : result.get(0));    
	 } 
	 
	 public Integer updateUser(Customer cust) { 
	  String sql = "UPDATE grossarymgmt.custmer SET firstname=?,lastname=?,mobile=?,email=?,adharno=?,address=?,pincode=?,username=?,password=?,role_id=? WHERE custmer_id=?"; 
	  return jdbcTemplate.update(sql, cust.getFirstname(), cust.getLastname(), cust.getMobile(), cust.getEmail(), 
	    cust.getAdharno(), cust.getAddress(), cust.getPincode(), cust.getUsername(), cust.getPassword(), 
	    cust.getRoleId(), cust.getCustomerId()); 
	 } 
	 
	 public void deleteUser(Customer cust) { 
	  String sql = "Delete from grossarymgmt.custmer WHERE custmer_id=?"; 
	  jdbcTemplate.update(sql, new Object[] { cust.getCustomerId() }); 
	 }

	public Customer getCustomerById(Integer customerId) {
		// TODO Auto-generated method stub
		return null;
	}   
}
