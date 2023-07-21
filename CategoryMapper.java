package com.grocery.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.grocery.model.Category;

public class CategoryMapper implements RowMapper<Category>{

	@Override
	public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
		Category category=new Category();
		category.setCategoryId(rs.getInt("category_id"));
		category.setCategoryname(rs.getString("categoryname"));
		return category;
	}

}
