package com.grocery.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.grocery.mapper.DiscountMapper;
import com.grocery.model.Discount;
@Repository
public class DiscountRepository {
@Autowired
JdbcTemplate jdbcTemplate;
	public List<Discount> getAllDiscount() {
		String sql="SELECT * FROM grossarymgmt.discount";
		List<Discount>discount=jdbcTemplate.query(sql, new DiscountMapper());
		return discount;
	}
	public int UpdateDiscount(Discount discount) {
		String sql="Update grossarymgmt.discount set discountname=?,discountpercentage=?,flatdiscount=? where discount_id=? ";
		return jdbcTemplate.update(sql, discount.getDiscountname(),discount.getDiscountpercentage(),
				discount.getFlatdiscount(),discount.getDiscountId());
	}

}
