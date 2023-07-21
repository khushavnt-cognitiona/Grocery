package com.grocery.model;

public class ShoppingCart1 {
	private Integer productId;
	private Double totalKg;
	private Double totalLtr;
	private Integer quantity;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Double getTotalKg() {
		return totalKg;
	}

	public void setTotalKg(Double totalKg) {
		this.totalKg = totalKg;
	}

	public Double getTotalLtr() {
		return totalLtr;
	}

	public void setTotalLtr(Double totalLtr) {
		this.totalLtr = totalLtr;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "ShoppingCart1 [productId=" + productId + ", totalKg=" + totalKg + ", totalLtr=" + totalLtr
				+ ", totalQty=" + quantity + "]";
	}

}