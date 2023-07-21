package com.grocery.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.grocery.model.ShoppingCart;
import com.grocery.model.ShoppingCart1;

@Repository
public class ShoppingCartRepository {
	@Autowired
	JdbcTemplate jdbctemplate;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	//public List<ShoppingCart> getCart() {
		// String sql="SELECT s.total_ltr, s.total_kg, s.total_count, s.price_per_kg,
		// s.price_per_ltr, s.price_per_count from stock_management s JOIN shoppingcart
		// c ON s.product_id = c.product_id " ;
		//String sql = "select sc.shoppingcartid,u.customerid,sc.totalprice from user as u join shoppingcart as sc on u.customerid=sc.customerid where u.customerid = ? ";

		/*List<ShoppingCart> response = jdbctemplate.query(sql,
				new Object[] { SecurityContextHolder.getContext().getAuthentication().getPrincipal() },
				new ShoppingCartMapper());
		return response;
	}

	public void addCart(ShoppingCart cart) {
		String sql = "INSERT INTO shoppingcart (customerid,totalprice) values (?,?)";
		jdbctemplate.update(sql, SecurityContextHolder.getContext().getAuthentication().getPrincipal(),
				cart.getTotalprice());
	}
*///	      public List<ShoppingCart> Totalprice(StockManagementService sms)  
//	      { 
	// String sql="SELECT sm.product_id,
	// SUM((sm.price_per_kg,sm.price_per_ltr,sm.price_per_count)) *
	// (sum(sm.total_ltr,sm.total_kg,sm.total_count) AS totalprice FROM
	// stock_management as sm JOIN shoppingcart sc ON sm.product_id = sc.productid
	// WHERE sm.product_id = ? GROUP BY sm.product_id " ;
	// List<ShoppingCart> response=jdbctemplate.query(sql, new
	// ShoppingCartMapper());
	// return response;
	// }

	/*
	 * public ShoppingCart getUserShoopingCartDetails() { String sql =
	 * "SELECT * FROM shoppingcart where customerid=?"; List<ShoppingCart> cartList
	 * = jdbctemplate.query(sql, new Object[] {
	 * SecurityContextHolder.getContext().getAuthentication().getPrincipal() }, new
	 * ShoppingCartMapper()); if (cartList.size() > 0) return cartList.get(0);
	 * return null; }
	 * 
	 * public void addProductToCart(Stock product, Integer customerId) { String sql
	 * = "update shoppingcart set totalprice = ? where customerid = ?";
	 * 
	 * }
	 */

	/*
	 * public void updateCart(ShoppingCart cart) { String sql =
	 * "update shoppingcart set totalprice = ? where customerid = ?";
	 * jdbctemplate.update(sql, cart.getTotalprice(),
	 * SecurityContextHolder.getContext().getAuthentication().getPrincipal());
	 * 
	 * }
	 */
	 public void addCartItems(Integer customerId, List<ShoppingCart1> items) {
	        String insertSql = "INSERT INTO shoppingcart( quantity, product_id, customer_id, quantityinltr, quantityinkg) VALUES (?,?,?,?,?)";

	        KeyHolder keyHolder = new GeneratedKeyHolder(); 
	         // Create a KeyHolder to retrieve generated keys

	        jdbctemplate.batchUpdate(insertSql, new BatchPreparedStatementSetter() {
	            @Override
	            public void setValues(PreparedStatement ps, int i) throws SQLException {
	               // ps.setInt(1, items.get(i)); 
	                ps.setInt(1, items.get(i).getQuantity());
	                ps.setInt(2, items.get(i).getProductId());
	                ps.setInt(3, customerId);

	                Double totalLtr = items.get(i).getTotalLtr();
	                if (totalLtr != null) {
	                    ps.setDouble(4, totalLtr);
	                } else {
	                    ps.setNull(4, java.sql.Types.DOUBLE);
	                }

	                Double totalKg = items.get(i).getTotalKg();
	                if (totalKg != null) {
	                    ps.setDouble(5, totalKg);
	                } else {
	                    ps.setNull(5, java.sql.Types.DOUBLE);
	                }
	            }

	            public int getBatchSize() {
	                return items.size();
	            }
	        }); // Pass the KeyHolder to the batchUpdate method

	        // Now you can retrieve the generated keys if needed
	        List<Map<String, Object>> generatedKeys = keyHolder.getKeyList();
	        for (Map<String, Object> keyMap : generatedKeys) {
	            // Assuming the generated key column is called "shopping_id"
	            Integer generatedId = (Integer) keyMap.get("shopping_id");
	            // Do something with the generatedId if needed
	            System.out.println("Generated Shopping ID: " + generatedId);
	        }
	    }
	 public ShoppingCart getUserShoppingCartDetails(Integer customerId) {
		    String sql = "SELECT * FROM shoppingcart WHERE customer_id = ?";
		    return jdbctemplate.queryForObject(sql, new Object[]{customerId}, (rs, rowNum) -> {
		        ShoppingCart shoppingCart = new ShoppingCart();
		        shoppingCart.setShoppingId(rs.getInt("shopping_id"));
		        shoppingCart.setCustomerId(rs.getInt("customer_id"));
		        shoppingCart.setTotalKg(rs.getDouble("total_price"));
		        // Set other properties as needed
		        return shoppingCart;
		    });
		}
	public void addCart(ShoppingCart newCart) {
		
		
		    String sql = "INSERT INTO shoppingcart (customer_id, total_price) VALUES (?, ?)";
		    jdbctemplate.update(sql, newCart.getCustomerId(), newCart.getTotalprice());
		}
	
	public void removeCartItems(Integer shoppingId,Integer productId) {
		 String sql = "DELETE FROM  cart_items  WHERE shopping_id = ? AND product_id = ?";
	        jdbctemplate.update(sql, shoppingId, productId);
	    }
		
	}

	

	
	



