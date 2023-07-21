package com.grocery.model;

import java.time.LocalDate;

public class Order 
{
	private Integer orderId;
	private Double shippingcharges;
	private LocalDate orderdate;
	private Double qntInKg;
	private Double qntInLtr;
	private Integer qntInCount;
	private Double finalamount;
	private Integer productId;
	private Integer customerId;
	private Integer shoppingId;
	private Customer customer;
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Double getShippingcharges() {
		return shippingcharges;
	}
	public void setShippingcharges(Double shippingcharges) {
		this.shippingcharges = shippingcharges;
	}
	public LocalDate getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(LocalDate localDate) {
		this.orderdate = localDate;
	}
	public Double getQntInKg() {
		return qntInKg;
	}
	public void setQntInKg(Double qntInKg) {
		this.qntInKg = qntInKg;
	}
	public Double getQntInLtr() {
		return qntInLtr;
	}
	public void setQntInLtr(Double qntInLtr) {
		this.qntInLtr = qntInLtr;
	}
	public Integer getQntInCount() {
		return qntInCount;
	}
	public void setQntInCount(Integer qntInCount) {
		this.qntInCount = qntInCount;
	}
	public Double getFinalamount() {
		return finalamount;
	}
	public void setFinalamount(Double finalamount) {
		this.finalamount = finalamount;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Integer getShoppingId() {
		return shoppingId;
	}
	public void setShoppingId(Integer shoppingId) {
		this.shoppingId = shoppingId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public ShoppingCart1[] getItems() {
		
		return null;
	}
	
}
