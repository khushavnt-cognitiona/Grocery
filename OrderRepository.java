package com.grocery.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.grocery.mapper.OrderMapper;
import com.grocery.model.Order;
@Repository
public class OrderRepository 
{
@Autowired
JdbcTemplate jdbcTemplate;
	public List<Order> getAllOrder() {
		String sql="SELECT * FROM grossarymgmt.ordermgmt";
		List<Order>order=jdbcTemplate.query(sql,new OrderMapper());
		return order;
	}
	public Integer saveOrder(Order order) {
		return null;
		// TODO Auto-generated method stub
		
	}

}
