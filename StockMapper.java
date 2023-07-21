package com.grocery.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.grocery.model.Stock;

public class StockMapper implements RowMapper<Stock>
{

	@Override
	public Stock mapRow(ResultSet rs, int rowNum) throws SQLException {
		Stock stock = new Stock();
		stock.setProductId(rs.getInt("product_id"));
        stock.setProductName(rs.getString("productname"));
        stock.setGuarantee(rs.getBoolean("isguarantee"));
        stock.setWarranty(rs.getBoolean("iswarranty"));
        stock.setGuaranteeDate(rs.getString("guaranteedate"));
        stock.setWarrantyDate(rs.getString("warrantydate"));
        stock.setEntryDate(rs.getString("entrydate"));
        stock.setManufacturingDate(rs.getString("manufacturingdate"));
        stock.setExpiryDate(rs.getString("expirydate"));
        stock.setProvider(rs.getString("provider"));
        stock.setTotalLtr(rs.getDouble("totalltr"));
        stock.setTotalKg(rs.getDouble("totalkg"));
        stock.setTotalCount(rs.getInt("totalcount"));
        stock.setPricePerKg(rs.getDouble("priceperkg"));
        stock.setPricePerLtr(rs.getDouble("priceperltr"));
        stock.setPricePerCount(rs.getDouble("pricepercount"));
        stock.setDiscountedPrice(rs.getDouble("discountedprice"));
        stock.setCategoryId(rs.getInt("category_id"));
        stock.setDiscountId(rs.getInt("discount_id"));
		return stock;
	}
}
