package com.grocery.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.grocery.model.ShoppingCart;

public class ShoppingCartMapper implements RowMapper<ShoppingCart>{

	@Override
	public ShoppingCart mapRow(ResultSet rs, int rowNum) throws SQLException {
		ShoppingCart shoppingCart=new ShoppingCart();
		shoppingCart.setShoppingId(rs.getInt("shopping_id"));
		shoppingCart.setTotalprice(rs.getDouble(2));
		shoppingCart.setProductId(rs.getInt(3));
		shoppingCart.setCustomerId(rs.getInt(4));
		return shoppingCart;
	}

}
