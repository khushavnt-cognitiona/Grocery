package com.grocery.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.grocery.mapper.TransactionMapper;
import com.grocery.model.Transaction;
@Repository
public class TransactionRepository {
@Autowired
JdbcTemplate jdbcTemplate;
	public List<Transaction> getAllTransaction() {
	String sql="SELECT * FROM grossarymgmt.transaction";
	List<Transaction>transaction=jdbcTemplate.query(sql, new TransactionMapper());
		return transaction;
	}

}
