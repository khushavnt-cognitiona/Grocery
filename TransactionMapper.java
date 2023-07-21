package com.grocery.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.grocery.model.Transaction;

public class TransactionMapper implements RowMapper<Transaction> {

	@Override
	public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {
	Transaction transaction=new Transaction();
	transaction.setTransactionId(rs.getInt("transaction_id"));
	transaction.setTransactiondate(rs.getString("transaction_date"));
	transaction.setTransactiontime(rs.getString("transaction_time"));
	transaction.setCashback(rs.getDouble("cashback"));
	transaction.setTransactionamount(rs.getDouble("transaction_amount"));
	transaction.setCustomerId(rs.getInt("custmer_id"));
	transaction.setModeId(rs.getInt("mode_id"));
	transaction.setOrderId(rs.getInt("order_id"));
		return transaction;
	}

}
