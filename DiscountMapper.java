package com.grocery.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.grocery.model.Discount;

public class DiscountMapper implements RowMapper<Discount>{

	@Override
	public Discount mapRow(ResultSet rs, int rowNum) throws SQLException {
		Discount discount=new Discount();
		discount.setDiscountId(rs.getInt("discount_id"));
		discount.setDiscountname(rs.getString("discountname"));
		discount.setDiscountpercentage(rs.getString("discountpercentage"));
		discount.setFlatdiscount(rs.getString("flatdiscount"));
		return discount;
	}

}
