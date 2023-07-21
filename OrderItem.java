package com.grocery.model;

import java.sql.Date;

public class OrderItem {
    private Integer orderId;
    private Double shippingCharges;
    private Date orderDate;
    private Double quantityInKg;
    private Integer quantityInCount;
    private Double quantityInLtr;
    private Double finalAmount;
    private Integer productId;
    private Double pricePerKg;
    private Double pricePerLtr;
    private Double pricePerCount;
    private Double discountedPrice;
    private Integer customerId;
    private String firstName;
    private String mobile;
    private String email;
    private String adharNo;
    private String address;
    private String pincode;
    private String username;
    private String password;
    private Integer shoppingId;
    private Integer shoppingCustomerId;
    private Double shoppingQuantityInKg;
    private Double shoppingTotalPrice;
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Double getShippingCharges() {
		return shippingCharges;
	}
	public void setShippingCharges(Double shippingCharges) {
		this.shippingCharges = shippingCharges;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Double getQuantityInKg() {
		return quantityInKg;
	}
	public void setQuantityInKg(Double quantityInKg) {
		this.quantityInKg = quantityInKg;
	}
	public Integer getQuantityInCount() {
		return quantityInCount;
	}
	public void setQuantityInCount(Integer quantityInCount) {
		this.quantityInCount = quantityInCount;
	}
	public Double getQuantityInLtr() {
		return quantityInLtr;
	}
	public void setQuantityInLtr(Double quantityInLtr) {
		this.quantityInLtr = quantityInLtr;
	}
	public Double getFinalAmount() {
		return finalAmount;
	}
	public void setFinalAmount(Double finalAmount) {
		this.finalAmount = finalAmount;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Double getPricePerKg() {
		return pricePerKg;
	}
	public void setPricePerKg(Double pricePerKg) {
		this.pricePerKg = pricePerKg;
	}
	public Double getPricePerLtr() {
		return pricePerLtr;
	}
	public void setPricePerLtr(Double pricePerLtr) {
		this.pricePerLtr = pricePerLtr;
	}
	public Double getPricePerCount() {
		return pricePerCount;
	}
	public void setPricePerCount(Double pricePerCount) {
		this.pricePerCount = pricePerCount;
	}
	public Double getDiscountedPrice() {
		return discountedPrice;
	}
	public void setDiscountedPrice(Double discountedPrice) {
		this.discountedPrice = discountedPrice;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdharNo() {
		return adharNo;
	}
	public void setAdharNo(String adharNo) {
		this.adharNo = adharNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getShoppingId() {
		return shoppingId;
	}
	public void setShoppingId(Integer shoppingId) {
		this.shoppingId = shoppingId;
	}
	public Integer getShoppingCustomerId() {
		return shoppingCustomerId;
	}
	public void setShoppingCustomerId(Integer shoppingCustomerId) {
		this.shoppingCustomerId = shoppingCustomerId;
	}
	public Double getShoppingQuantityInKg() {
		return shoppingQuantityInKg;
	}
	public void setShoppingQuantityInKg(Double shoppingQuantityInKg) {
		this.shoppingQuantityInKg = shoppingQuantityInKg;
	}
	public Double getShoppingTotalPrice() {
		return shoppingTotalPrice;
	}
	public void setShoppingTotalPrice(Double shoppingTotalPrice) {
		this.shoppingTotalPrice = shoppingTotalPrice;
	}

    // Constructor, getters, and setters
    
}
