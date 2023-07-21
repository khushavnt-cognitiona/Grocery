package com.grocery.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grocery.model.Discount;
import com.grocery.repository.DiscountRepository;

@Service
public class DiscountService 
{
@Autowired
DiscountRepository discountRepository;
	public List<Discount> getAllDiscount() {
		
		return discountRepository.getAllDiscount() ;
	}
	public void UpdateDiscount(Discount discount) {
		int a=discountRepository.UpdateDiscount(discount);
		if(a==0) 
		{
			System.out.println("please enter valid id");
		}
	}

}
