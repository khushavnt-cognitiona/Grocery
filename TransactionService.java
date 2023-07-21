package com.grocery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grocery.model.Transaction;
import com.grocery.repository.TransactionRepository;
@Service
public class TransactionService 
{
@Autowired
TransactionRepository transactionRepository;
	public List<Transaction> getAllTransaction() {
		
		return transactionRepository.getAllTransaction();
	}

}
