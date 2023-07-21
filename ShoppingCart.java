package com.grocery.model;

public class ShoppingCart {
private Integer shoppingId;
private Double totalprice;
private Integer productId;
private Integer customerId;
 private Integer  Quantity;
private Double TotalLtr;
 private Double  TotalKg;
 private Integer CartId;
 
 
public Integer getQuantity() {
	return Quantity;
}
public void setQuantity(Integer quantity) {
	Quantity = quantity;
}
public Double getTotalLtr() {
	return TotalLtr;
}
public void setTotalLtr(Double totalLtr) {
	TotalLtr = totalLtr;
}
public Double getTotalKg() {
	return TotalKg;
}
public void setTotalKg(Double totalKg) {
	TotalKg = totalKg;
}
public Integer getShoppingId() {
	return shoppingId;
}
public void setShoppingId(Integer shoppingId) {
	this.shoppingId = shoppingId;
}
public Double getTotalprice() {
	return totalprice;
}
public void setTotalprice(Double totalprice) {
	this.totalprice = totalprice;
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

}
