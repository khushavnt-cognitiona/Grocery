package com.grocery.service;



import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grocery.allexception.ProductNotFoundException;
import com.grocery.model.Order;
import com.grocery.model.ShoppingCart1;
import com.grocery.model.Stock;
import com.grocery.repository.OrderRepository;
import com.grocery.repository.StockRepository;
import com.grocery.shoppingcart.ShoppingCartItemsRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private StockRepository stockRepository;
    @Autowired
    ShoppingCartItemsRepository cartItemsRepository;

    public Order createOrder(Order order) throws ProductNotFoundException {
        // Check if the customer and shopping cart exist before placing the order
        shoppingCartService.addCart(order.getCustomerId(), order.getItems());

        // Calculate the final amount for the order
        calculateFinalAmount(order);

        // Set the order date
        order.setOrderdate(LocalDate.now());

        // Save the order details in the database
        Integer orderId = orderRepository.saveOrder(order);

        order.setOrderId(orderId);

        return order;
    }

    // Add other methods for updating, deleting, and getting orders

    // Helper method to calculate the final amount based on shipping charges and item prices
    private void calculateFinalAmount(Order order) throws ProductNotFoundException {
        double totalPrice = 0.0;

        // Calculate the total price based on the items in the order
        for (ShoppingCart1 item : order.getItems()) {
            int productId = item.getProductId();
            int quantity = item.getQuantity();
            Double totalLtr = item.getTotalLtr();
            Double totalKg = item.getTotalKg();

            // Retrieve the stock for the given product
            Optional<Stock> optionalStock = Optional.of(stockRepository.SearchById(productId));

            if (!optionalStock.isPresent()) {
                throw new ProductNotFoundException("Product with ID " + productId + " does not exist.");
            }

            Stock stock = optionalStock.get();
            double pricePerItem = 0.0;

            if (totalLtr != null) {
                pricePerItem = totalLtr * stock.getPricePerLtr();
            } else if (totalKg != null) {
                pricePerItem = totalKg * stock.getPricePerKg();
            } else {
                pricePerItem = quantity * stock.getPricePerCount();
            }

            totalPrice += pricePerItem;
        }

        // Add shipping charges to the total price to get the final amount
        order.setFinalamount(totalPrice + order.getShippingcharges());
    }
}
