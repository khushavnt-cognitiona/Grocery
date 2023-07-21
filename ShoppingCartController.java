package com.grocery.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.allexception.ProductNotFoundException;
import com.grocery.model.ShoppingCart;
import com.grocery.model.ShoppingCart1;
import com.grocery.repository.ShoppingCartRepository;
import com.grocery.service.ShoppingCartService;

@RestController
public class ShoppingCartController {
	  @Autowired
	  ShoppingCartService shoppingcartservice;

//	     @Autowired 
//	     StockManagementService stockmanagement; 
//	      
	  @Autowired
	  ShoppingCartRepository shoppingcartrepository;

		/*
		 * @GetMapping("/get/shoppingcart") public List<ShoppingCart> getcart() { return
		 * shoppingcartservice.getCart(); }
		 */
//	     @GetMapping("/totalprice") 
//	    public List<ShoppingCart> Totalprice( @RequestBody StockManagementService sms) 
//	    { 
//	       
//	       return shoppingcartservice.TotalPrice(sms); 
	//  
//	    } 

	  @PostMapping("/addtocart/{customerId}")
	  public void addCart(@PathVariable Integer customerId,
			  @RequestBody List<ShoppingCart1> items) throws ProductNotFoundException {
	    
	    shoppingcartservice.addCart(customerId, items);
	  }
	  @DeleteMapping("/{customerId}/items")
	  public ResponseEntity<String> removeCartitems(@PathVariable("customerId")Integer customerId,@RequestParam("productId") Integer productId ){
		  shoppingcartservice.removeCartItems(customerId,productId);
		     return new ResponseEntity<>("Items remove frome Cart" ,HttpStatus.OK);
		  
	  }
	  
}
