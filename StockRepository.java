package com.grocery.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.grocery.mapper.DealerMapper;
import com.grocery.mapper.StockMapper;
import com.grocery.model.Dealer;
import com.grocery.model.Employee;
import com.grocery.model.Stock;
@Repository
public class StockRepository 
{
@Autowired
JdbcTemplate jdbcTemplate;
	public List<Stock> AllgetStock()
	{
		String sql="SELECT * FROM stock";
		List<Stock>stock=jdbcTemplate.query(sql,new StockMapper());
		return stock;
	}
	
	public void AddStockRepository(List<Stock> stock) {
		String sql="INSERT INTO `grossarymgmt`.`stock` (`product_id`, `productname`, `isguarantee`, `iswarranty`, "
				+ "`guaranteedate`, `warrantydate`, `entrydate`, `manufacturingdate`, "
				+ "`expirydate`, `provider`, `totalltr`, `totalkg`, `totalcount`, "
				+ "`priceperkg`, `priceperltr`, `pricepercount`, `discountedprice`, `category_id`, `discount_id`) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException 
			{
				 ps.setInt(1, stock.get(i).getProductId());
			        ps.setString(2, stock.get(i).getProductName());
			        ps.setBoolean(3, stock.get(i).isGuarantee());
			        ps.setBoolean(4, stock.get(i).isWarranty());
			        ps.setString(5, stock.get(i).getGuaranteeDate());
			        ps.setString(6, stock.get(i).getWarrantyDate());
			        ps.setString(7, stock.get(i).getEntryDate());
			        ps.setString(8, stock.get(i).getManufacturingDate());
			        ps.setString(9, stock.get(i).getExpiryDate());
			        ps.setString(10, stock.get(i).getProvider());
			        ps.setDouble(11, stock.get(i).getTotalLtr());
			        ps.setDouble(12, stock.get(i).getTotalKg());
			        ps.setInt(13, stock.get(i).getTotalCount());
			        ps.setDouble(14, stock.get(i).getPricePerKg());
			        ps.setDouble(15, stock.get(i).getPricePerLtr());
			        ps.setDouble(16, stock.get(i).getPricePerCount());
			        ps.setDouble(17,stock.get(i).getDiscountedPrice());
			        ps.setInt(18, stock.get(i).getCategoryId());
			        ps.setInt(19, stock.get(i).getDiscountId());
	
			}
			
			@Override
			public int getBatchSize() {
				
				return stock.size();
			}
		});
	}
public int UpdateStock(Stock stock)
{
	String sql="update  stock set  product_id=? "
			+ " guaranteedate = ?, warrantydate = ?, entrydate = ?, manufacturingdate = ?, "
			+ "expirydate = ?, provider = ?, totalltr = ?, totalkg = ?, totalcount = ?, "
			+ "priceperkg = ?, priceperltr = ?, pricepercount = ?, discountedprice = ? WHERE product_id = ?";
		return jdbcTemplate.update(sql, stock.getProductName(),stock.getGuaranteeDate(),stock.getWarrantyDate(),
				stock.getEntryDate(),stock.getManufacturingDate(),stock.getExpiryDate(),stock.getProvider(),
				stock.getTotalLtr(),stock.getTotalKg(),stock.getTotalCount(),stock.getPricePerKg(),stock.getPricePerLtr(),
				stock.getPricePerCount(),stock.getDiscountedPrice(),stock.getProductId());
	}
	public int DeleteStock(Integer productId) {
			String sql="delete from grossarymgmt.stock where product_id=? ";
			Object[]productavailable= {productId};
			return jdbcTemplate.update(sql,productavailable);
	}

	public Stock SearchById(Integer productId) {
		String sql="select * from  stock where product_id=? ";
		Object[]param= {productId};
		List<Stock>stock=jdbcTemplate.query(sql, param, new StockMapper());
		return stock.isEmpty()? null:stock.get(0);
	}

	public void updateStockQuantity(Stock stock, int productId) {
	    String updateQuery = "UPDATE stock SET totalltr = ?, totalcount = ?, totalkg = ? WHERE  product_id = ?";

	    jdbcTemplate.update(updateQuery, stock.getTotalLtr(), stock.getTotalCount(), stock.getTotalKg(), stock.getProductId());
	}


	

}
