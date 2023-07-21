package com.grocery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.model.Order;
import com.grocery.service.OrderService;

@RestController
public class OrderController 
{
@Autowired
OrderService orderService;
@GetMapping("/get/order")
public List<Order>getAllOrder()
{
	return null;
	
}


}
