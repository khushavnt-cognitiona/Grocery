package com.grocery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.model.Discount;
import com.grocery.service.DiscountService;

@RestController
public class DiscountController 
{
	@Autowired
	DiscountService discountService;
	@GetMapping("/get/discount")
	public List<Discount>getAllDiscount()
	{
		return discountService.getAllDiscount();	
	}
	@PutMapping("/updatein/{discountId}")
	public void UpdateDiscount(@PathVariable Integer discountId,@RequestBody Discount discount) 
	{
		discount.setDiscountId(discountId);
		discountService.UpdateDiscount(discount);
	}

}
