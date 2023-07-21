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

import com.grocery.model.Dealer;
import com.grocery.service.DealerService;

@RestController
public class DealerController 
{
	@Autowired
	DealerService dealerService;
	@GetMapping("/get/dealers")
public List<Dealer>getAllDealer()
{
	return dealerService.getAllDealer();

}
	@PostMapping("/post/dealers")
	public void addDealer(@RequestBody List<Dealer> dealer) {
		
		dealerService.AddDealerService(dealer);
	}
@PutMapping("/update/{dealerId}")
public void UpdateDealer(@PathVariable Integer dealerId,@RequestBody Dealer dealer) 
{
	dealerService.UpdateDealer(dealer);
}
@DeleteMapping("/Delete/{dealerId}")
public void DeleteDealer(@PathVariable Integer dealerId,@RequestBody Dealer dealer) 
{
	dealerService.DeleteDealer(dealer);	
}
}
