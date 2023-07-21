package com.grocery.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.grocery.mapper.RolesMapper;
import com.grocery.model.Roles;
@Repository
public class RolesRepository {
@Autowired
JdbcTemplate jdbcTemplate;
	public List<Roles> getAllRoles()
	{
		String sql="SELECT * FROM grossarymgmt.roles";
		List<Roles>roles=jdbcTemplate.query(sql, new RolesMapper());
		return roles;
		
	}
	public void AddRolesRepository(List<Roles> roles) 
	{
		String sql="INSERT INTO `grossarymgmt`.`roles` (`role_id`, `rolename`) VALUES (?, ?)";
		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setInt(1,roles.get(i).getRoleId());
				ps.setString(2, roles.get(i).getRolename());
				
			}
			
			@Override
			public int getBatchSize() {
				// TODO Auto-generated method stub
				return roles.size();
			}
		});
		
	}
	public int DeleteRoles(Roles roles) {
		String sql="delete from `grossarymgmt`.`roles` where role_id=?";
		return jdbcTemplate.update(sql, roles.getRoleId());
	}

}
