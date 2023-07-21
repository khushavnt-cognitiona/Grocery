package com.grocery.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.grocery.model.Roles;

public class RolesMapper implements RowMapper<Roles>{

	@Override
	public Roles mapRow(ResultSet rs, int rowNum) throws SQLException {
		Roles roles=new Roles();
		roles.setRoleId(rs.getInt("role_id"));
		roles.setRolename(rs.getString("rolename"));
		return roles;
	}

}
