package com.grocery.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.grocery.model.Customer;

public class CustomerMapper implements RowMapper<Customer>
{
	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
	Customer custmer=new Customer();
	custmer.setCustomerId(rs.getInt("custmer_id"));
	custmer.setFirstname(rs.getString("firstname"));
	custmer.setLastname(rs.getString("lastname"));
	custmer.setMobile(rs.getString("mobile"));
    custmer.setEmail(rs.getString("email"));
    custmer.setAdharno(rs.getString("adharno"));
    custmer.setAddress(rs.getString("address"));
    custmer.setPincode(rs.getString("pincode"));
    custmer.setUsername(rs.getString("username"));
    custmer.setPassword(rs.getString("password"));
    custmer.setRoleId(rs.getInt("role_id"));
		return custmer;
	}
}
