package com.grocery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.model.PaymentMode;
import com.grocery.service.PaymentService;

@RestController
public class PaymentController 
{
@Autowired
PaymentService paymentService;
@GetMapping("/get/payment")
public List<PaymentMode>getAllPayment()
{
	return paymentService.getAllPayment();
}
//post and delete
@PostMapping("/post/payment")
public void AddPayment(@RequestBody List<PaymentMode>paymentMode)
{
	paymentService.AddPayment(paymentMode);
}
@DeleteMapping("/deleteinpayment/{modeId}")
public void DeletePayment(@PathVariable Integer modeId,@RequestBody PaymentMode paymentMode) 
{
	paymentService.DeletePayment(paymentMode);
}
}
