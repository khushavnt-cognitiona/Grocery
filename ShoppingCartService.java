package com.grocery.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grocery.allexception.ProductNotFoundException;
import com.grocery.model.ShoppingCart;
import com.grocery.model.ShoppingCart1;
import com.grocery.model.Stock;
import com.grocery.repository.ShoppingCartRepository;
import com.grocery.repository.StockRepository;
import com.grocery.shoppingcart.ShoppingCartItemsRepository;

@Service
public class ShoppingCartService {
    @Autowired
    StockRepository stockRepository;
    @Autowired
    ShoppingCartItemsRepository cartItemsRepository;
    @Autowired
    ShoppingCartRepository cartRepository;

    public void addCart(Integer customerId, List<ShoppingCart1> items) throws ProductNotFoundException {
        ShoppingCart existingCart = cartRepository.getUserShoppingCartDetails(customerId);
        Integer shoppingId;

        if (existingCart != null) {
            shoppingId = existingCart.getShoppingId();
        } else {
            ShoppingCart newCart = new ShoppingCart();
            newCart.setCustomerId(customerId);
            newCart.setTotalKg(0.0); // Set the initial total price for the cart
            cartRepository.addCart(newCart);
            shoppingId = newCart.getShoppingId();
        }

        for (ShoppingCart1 cartItem : items) {
            int productId = cartItem.getProductId();
            int quantity = cartItem.getQuantity();
            Double totalLtr = cartItem.getTotalLtr();
            Double totalKg = cartItem.getTotalKg();

            // Check if the inserted product exists or not
            Optional<Stock> optionalStock = stockRepository.AllgetStock().stream()
                    .filter(stock -> stock.getProductId() == productId)
                    .findFirst();

            if (!optionalStock.isPresent()) {
                // Product does not exist, throw an exception or perform error handling operations
                throw new ProductNotFoundException("Product with ID " + productId + " does not exist.");
            }

            Stock stock = optionalStock.get();
            double totalPrice = 0.0;

            if (totalLtr != null) {
                totalPrice = stock.getPricePerLtr() * totalLtr;
            } else if (totalKg != null) {
                totalPrice = stock.getPricePerKg() * totalKg;
            } else {
                totalPrice = stock.getPricePerCount() * quantity;
            }

            ShoppingCart shoppingCart = new ShoppingCart();
            shoppingCart.setShoppingId(shoppingId);
            shoppingCart.setCustomerId(customerId);
            shoppingCart.setProductId(productId);
            shoppingCart.setQuantity(quantity);
            shoppingCart.setTotalKg(totalPrice);

            cartItemsRepository.insertCartItem(shoppingCart);

            // Update the stock quantity
            if (totalLtr != null || totalKg != null || quantity > 0) {
                // If total ltr, total kg, or quantity is provided and greater than zero,
                // update the stock quantity
                updateStockQuantity(productId, quantity, totalLtr, totalKg);
            } else {
                // If total ltr, total kg, and quantity are zero, delete the product
                deleteProduct(productId);
            }
        }
    }

    private void updateStockQuantity(int productId, int quantity, Double totalLtr, Double totalKg) throws ProductNotFoundException {
        // Retrieve the stock for the given product
        Optional<Stock> optionalStock = stockRepository.AllgetStock().stream()
                .filter(stock -> stock.getProductId() == productId)
                .findFirst();

        if (optionalStock.isPresent()) {
            Stock stock = optionalStock.get();
             if(totalLtr!=null) {
            	 Double updatedTotalLtr=stock.getTotalLtr()-totalLtr;
            	 if(updatedTotalLtr>=0) {
            		 stock.setTotalLtr(updatedTotalLtr);
            	 
            	 } else 
            		throw new ProductNotFoundException("the Product Not Available in your stock with Totalltr ");
            		
            	 }
            	 
            	 
            	 
            	 else if (totalKg!=null) {
            		Double updatedTotalKg=stock.getTotalKg()-totalKg;
            		if(updatedTotalKg>=0) {
            			stock.setTotalKg(updatedTotalKg);
            		}else {
            			throw new ProductNotFoundException("the product is Not avilable with TOtalkg in your stock "+productId);
            		}
            	 }  else { 
            		 Integer updatedtotalCount=stock.getTotalCount()-quantity;
            		 if(updatedtotalCount>=0) {
            			   stock.setTotalCount(updatedtotalCount);
            		 }else {
						throw new ProductNotFoundException("Product Not Avilaible in Your stock");
					}
            	 }
					stockRepository.updateStockQuantity(stock, productId);	
					}
					
				
             }
            	 
             
        
    private void deleteProduct(int productId) {
        // Delete the product from the stock
        stockRepository.DeleteStock(productId);
        
        
        
    }

	public void removeCartItems(Integer customerId, Integer productId) {
		ShoppingCart cart=cartRepository.getUserShoppingCartDetails(customerId);
		if(cart!=null) {
			cartRepository.removeCartItems(cart.getShoppingId(), productId);
		}
		
	}

	public void addCart(Integer customerId, ShoppingCart1[] items) {
		// TODO Auto-generated method stub
		
	}
}