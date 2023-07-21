package com.grocery.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.grocery.mapper.DealerMapper;
import com.grocery.model.Dealer;
@Repository
public class DealerRepository 
{
	@Autowired
JdbcTemplate jdbcTemplate;
	public List<Dealer> getAllDealer()
	{
		String sql="SELECT d.dealer_id, d.firstname, d.lastname, d.mobile, d.email, d.adharno, d.panno,"
				+ "			       d.accountno, d.address, d.pincode, d.username, d.password, r.rolename  "
				+ "			       FROM dealer d"
				+ "			       JOIN roles r ON d.role_id = r.role_id;";
		List<Dealer>dealer=jdbcTemplate.query(sql,new DealerMapper());
		return dealer;
		
	}
	public void AddDealer(List<Dealer>dealer) 
	{
		String sql="INSERT INTO `grossarymgmt`.`dealer` (`dealer_id`, `firstname`, `lastname`, `mobile`, `email`, `adharno`, `panno`, `accountno`, `address`, `pincode`, `username`, `password`, `role_id`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
		
		@Override
		public void setValues(PreparedStatement ps, int i) throws SQLException {
			ps.setInt(1, dealer.get(i).getDealerId());
			ps.setString(2,dealer.get(i).getFirstName());
			ps.setString(3, dealer.get(i).getLastName());
			ps.setString(4, dealer.get(i).getMobile());
			ps.setString(5, dealer.get(i).getEmail());
			ps.setString(6, dealer.get(i).getAdharNo());
			ps.setString(7, dealer.get(i).getPanNo());
			ps.setString(8, dealer.get(i).getAccountNo());
			ps.setString(9, dealer.get(i).getAddress());
			ps.setString(10, dealer.get(i).getPincode());
			ps.setString(11, dealer.get(i).getUserName());
			ps.setString(12, dealer.get(i).getPassword());
			ps.setString(13, dealer.get(i).getRolename());
	
		}
		
		@Override
		public int getBatchSize() {
			
			return dealer.size();
		}
	});
	}
	public int UpdateDealer(Dealer dealer) {
		String sql="update grossarymgmt.dealer set firstname=?, lastname=?, mobile=?, email=?, adharno=?, panno=?, accountno=?, address=?, pincode=?, username=?, password=? where dealer_id=? ";
		return jdbcTemplate.update(sql, dealer.getFirstName(),dealer.getLastName(),
				dealer.getMobile(),dealer.getEmail(),dealer.getAdharNo(),dealer.getPanNo(),
				dealer.getAccountNo(),dealer.getAddress(),dealer.getPincode(),dealer.getUserName(),
				dealer.getPassword(),dealer.getDealerId());
	}
	public int DeleteDealer(Dealer dealer) {
		String sql="delete from grossarymgmt.dealer where dealer_id=? ";
		return jdbcTemplate.update(sql,dealer.getDealerId());
	}

}
