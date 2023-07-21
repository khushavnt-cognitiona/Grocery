package com.grocery.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.grocery.model.Dealer;

public class DealerMapper implements RowMapper<Dealer>
{

	@Override
	public Dealer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Dealer dealer=new Dealer();
		dealer.setDealerId(rs.getInt("dealer_id"));
	    dealer.setFirstName(rs.getString("firstname"));
	    dealer.setLastName(rs.getString("lastname"));
	    dealer.setMobile(rs.getString("mobile"));
	    dealer.setEmail(rs.getString("email"));
	    dealer.setAdharNo(rs.getString("adharno"));
	    dealer.setPanNo(rs.getString("panno"));
	    dealer.setAddress(rs.getString("address"));
	    dealer.setPincode(rs.getString("pincode"));
	    dealer.setAccountNo(rs.getString("accountno"));
	    dealer.setUserName(rs.getString("username"));
	    dealer.setPassword(rs.getString("password"));
	   // dealer.setRoleId(rs.getInt("role_id"));
	    dealer.setRolename(rs.getString("rolename"));
		return dealer;
	}

}
