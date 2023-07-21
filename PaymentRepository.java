package com.grocery.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.grocery.mapper.PaymentMapper;
import com.grocery.model.PaymentMode;
@Repository
public class PaymentRepository {
@Autowired
JdbcTemplate jdbcTemplate;
	public List<PaymentMode>getAllPayment() 
	{
		String sql="SELECT * FROM grossarymgmt.paymentmode";
		List<PaymentMode>paymentMode=jdbcTemplate.query(sql, new PaymentMapper());
		return paymentMode;
	}
	public void AddPayment(List<PaymentMode> paymentMode) {
		String sql="INSERT INTO `grossarymgmt`.`paymentmode` (`mode_id`, `name`) VALUES (?, ?)";
		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setInt(1,paymentMode.get(i).getModeId());
				ps.setString(2,paymentMode.get(i).getName());
				
			}
			
			@Override
			public int getBatchSize() {
				
				return paymentMode.size();
			}
		});
		
	}
	public int DeletePayment(PaymentMode paymentMode) {
		String sql="delete from grossarymgmt.paymentmode where mode_id=?";
		return jdbcTemplate.update(sql, paymentMode.getModeId());
	}

}
