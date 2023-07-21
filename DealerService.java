package com.grocery.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.grocery.model.Dealer;
import com.grocery.repository.DealerRepository;
@Service
public class DealerService 
{
	@Autowired
	DealerRepository dealerRepository;
	public List<Dealer> getAllDealer(){
    return dealerRepository.getAllDealer();
	}
	public void AddDealerService(List<Dealer>dealer) 
	{
		dealerRepository.AddDealer(dealer);
	}
	public void UpdateDealer(Dealer dealer)
	{
		dealerRepository.UpdateDealer(dealer);
		
	}
	public void DeleteDealer(Dealer dealer) {
		dealerRepository.DeleteDealer(dealer);
		
	}
}
