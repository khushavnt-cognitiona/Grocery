package com.grocery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grocery.allexception.ProductNotFoundException;
import com.grocery.model.Stock;
import com.grocery.repository.StockRepository;
@Service
public class StockService 
{
	@Autowired
	StockRepository stockRepository;

	public List<Stock> AllgetStock() 
	{
		return stockRepository.AllgetStock();
	}

	public void AddStockService(List<Stock> stock) 
	{
		stockRepository.AddStockRepository(stock);
	}
public void UpdateStock(Stock stock) throws ProductNotFoundException 
{
	int a=stockRepository.UpdateStock(stock);
	if(a==0) 
	{
		throw new ProductNotFoundException("please enter valid product_id");
	}
		
	}

	public void DeleteStock(Integer productId) throws ProductNotFoundException 
	{
		int productavailable=stockRepository.DeleteStock(productId);
		if(productavailable==0) 
		{
			throw new ProductNotFoundException("please enter valid product_id :"+productId);
		}
		
	}

	public Stock SearchById(Integer product_id) {
		Stock stock=stockRepository.SearchById(product_id);
		if(stock==null) 
		{
			System.out.println("product is unavailable");
		}
		return stock;
	}

	
}
