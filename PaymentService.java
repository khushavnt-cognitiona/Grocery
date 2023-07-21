package com.grocery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grocery.model.PaymentMode;
import com.grocery.repository.PaymentRepository;
@Service
public class PaymentService
{
@Autowired
PaymentRepository paymentRepository;
	public List<PaymentMode> getAllPayment() {
		
		return paymentRepository.getAllPayment();
	}
	public void AddPayment(List<PaymentMode> paymentMode) 
	{
		 paymentRepository.AddPayment(paymentMode);
		
	}
	public void DeletePayment(PaymentMode paymentMode) 
	{
		int a=paymentRepository.DeletePayment(paymentMode);
		if(a==0) 
		{
			System.out.println("please check your amount");
		}
		
	}

}
