package com.grocery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.model.Transaction;
import com.grocery.service.TransactionService;

@RestController
public class TransactionController {
@Autowired
TransactionService transactionService;
@GetMapping("/get/transaction")
public List<Transaction>getAllTransaction()
{
	return transactionService.getAllTransaction();
	
}
}
