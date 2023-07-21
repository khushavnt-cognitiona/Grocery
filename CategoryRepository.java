package com.grocery.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.grocery.mapper.CategoryMapper;
import com.grocery.model.Category;
@Repository
public class CategoryRepository {
@Autowired
JdbcTemplate jdbcTemplate;
	public List<Category> getAllCategory()
	{
		String sql="SELECT * FROM grossarymgmt.category";
		List<Category>category=jdbcTemplate.query(sql,new CategoryMapper());
		return category;
		
	}
	public void AddCategoryRepository(List<Category> category) 
	{
		String sql="INSERT INTO `grossarymgmt`.`category` (`category_id`, `categoryname`) VALUES (?,?)";
		jdbcTemplate.batchUpdate(sql,new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setInt(1, category.get(i).getCategoryId());
				ps.setString(2, category.get(i).getCategoryname());
			}
			
			@Override
			public int getBatchSize() {
				
				return category.size();
			}
		});
	}
	public int UpdateCategory(Category category)
	{
		String sql="update grossarymgmt.category set categoryname=? where category_id=? ";  
		return jdbcTemplate.update(sql,category.getCategoryname(),category.getCategoryId());
	}
	public int DeleteCategory(Category category) {
		String sql="delete from grossarymgmt.category where category_id=? ";
		return jdbcTemplate.update(sql, category.getCategoryId());
	}

}
