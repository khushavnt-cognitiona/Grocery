package com.grocery.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.grocery.model.PaymentMode;

public class PaymentMapper implements RowMapper<PaymentMode>{

	@Override
	public PaymentMode mapRow(ResultSet rs, int rowNum) throws SQLException {
		PaymentMode paymentMode=new PaymentMode();
		paymentMode.setModeId(rs.getInt("mode_id"));
		paymentMode.setName(rs.getString("name"));
		return paymentMode;
	}

}
