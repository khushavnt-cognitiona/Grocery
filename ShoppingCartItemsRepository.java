package com.grocery.shoppingcart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.grocery.allexception.ProductNotFoundException;
import com.grocery.model.ShoppingCart;

@Repository
public class ShoppingCartItemsRepository 
{
	@Autowired
	JdbcTemplate jdbctemplate;

	public void insertCartItems(List<ShoppingCart> cartItems) throws ProductNotFoundException{
        String sql = "INSERT INTO cart_items (shopping_id, product_id, quantity) VALUES (?, ?, ?)";
        int[][] batchUpdateResult = jdbctemplate.batchUpdate(sql, cartItems, cartItems.size(),
                (ps, cartItem) -> {
                    ps.setInt(1, cartItem.getShoppingId());
                    ps.setInt(2, cartItem.getProductId());
                    ps.setInt(3, cartItem.getQuantity());
                });
        
}

	public void insertCartItem(ShoppingCart shoppingCart) {
	
		    String sql = "INSERT INTO cart_items (shopping_id, product_id, quantity, customer_id) VALUES (?, ?, ?, ?)";
		    jdbctemplate.update(sql, shoppingCart.getShoppingId(), shoppingCart.getProductId(), shoppingCart.getQuantity(), shoppingCart.getCustomerId());
		}
	}

	


