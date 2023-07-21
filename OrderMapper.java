package com.grocery.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.grocery.model.Order;

public class OrderMapper implements RowMapper<Order>
{

	@Override
	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		Order order=new Order();
		order.setOrderId(rs.getInt("order_id"));
		order.setShippingcharges(rs.getDouble("shippingcharges"));
		order.setOrderdate(rs.getString("orderdate"));
		order.setQntInKg(rs.getDouble("qty_in_kg"));
		order.setQntInLtr(rs.getDouble("qty_in_ltr"));
		order.setQntInCount(rs.getInt("qty_in_count"));
		order.setFinalamount(rs.getDouble("finalamount"));
		order.setProductId(rs.getInt("product_id"));
		order.setCustomerId(rs.getInt("custmer_id"));
		order.setShoppingId(rs.getInt("shopping_id"));
		return order;
	}

}
