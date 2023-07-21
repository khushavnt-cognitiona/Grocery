package com.grocery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.allexception.ProductNotFoundException;
import com.grocery.model.Employee;
import com.grocery.model.Stock;
import com.grocery.service.StockService;

@RestController
public class StockController 
{
	@Autowired
	StockService stockService;
	@GetMapping("/get/stock")
	public List<Stock>AllgetStock()
	{
		return stockService.AllgetStock();	
	}
	@PostMapping("/post/stock")
	public void addStock(@RequestBody List<Stock>stock) 
	{
		stockService.AddStockService(stock);
	}
//update ,delete,searchbyid
	@PutMapping("/putstock/{productId}")
	public void UpdateStock(@PathVariable Integer productId,@RequestBody Stock stock) throws ProductNotFoundException 
	{
		stock.setProductId(productId);
		stockService.UpdateStock(stock);
	}
	@DeleteMapping("/deleteStock/{productId}")
	public void DeleteStock(@PathVariable Integer productId) throws ProductNotFoundException 
	{
		stockService.DeleteStock(productId);
	}
	@GetMapping("/serchstock/{productId}")
	public Stock SearchById(@PathVariable Integer productId ) 
	{
		return stockService.SearchById(productId);
		
	}
	
}
