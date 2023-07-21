package com.grocery.model;

public class Stock 
{ 
private Integer productId;
private String productName;
private Boolean isGuarantee;
private Boolean isWarranty;
private String guaranteeDate;
private String warrantyDate;
private String entryDate;
private String manufacturingDate;
private String expiryDate;
private String provider;
private Double totalLtr;
private Double totalKg;
private Integer totalCount;
private Double pricePerKg;
private Double pricePerLtr;
private Double pricePerCount;
private Double discountedPrice;
private Integer categoryId;
private Integer discountId;

public Integer getProductId() {
	return productId;
}
public void setProductId(Integer productId) {
	this.productId = productId;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public boolean isGuarantee() {
	return isGuarantee;
}
public void setGuarantee(boolean isGuarantee) {
	this.isGuarantee = isGuarantee;
}
public boolean isWarranty() {
	return isWarranty;
}
public void setWarranty(boolean isWarranty) {
	this.isWarranty = isWarranty;
}
public String getGuaranteeDate() {
	return guaranteeDate;
}
public void setGuaranteeDate(String guaranteeDate) {
	this.guaranteeDate = guaranteeDate;
}
public String getWarrantyDate() {
	return warrantyDate;
}
public void setWarrantyDate(String warrantyDate) {
	this.warrantyDate = warrantyDate;
}
public String getEntryDate() {
	return entryDate;
}
public void setEntryDate(String entryDate) {
	this.entryDate = entryDate;
}
public String getManufacturingDate() {
	return manufacturingDate;
}
public void setManufacturingDate(String manufacturingDate) {
	this.manufacturingDate = manufacturingDate;
}
public String getExpiryDate() {
	return expiryDate;
}
public void setExpiryDate(String expiryDate) {
	this.expiryDate = expiryDate;
}
public String getProvider() {
	return provider;
}
public void setProvider(String provider) {
	this.provider = provider;
}
public double getTotalLtr() {
	return totalLtr;
}
public void setTotalLtr(double totalLtr) {
	this.totalLtr = totalLtr;
}
public double getTotalKg() {
	return totalKg;
}
public void setTotalKg(double totalKg) {
	this.totalKg = totalKg;
}
public Integer getTotalCount() {
	return totalCount;
}
public void setTotalCount(Integer totalCount) {
	this.totalCount = totalCount;
}
public double getPricePerKg() {
	return pricePerKg;
}
public void setPricePerKg(double pricePerKg) {
	this.pricePerKg = pricePerKg;
}
public double getPricePerLtr() {
	return pricePerLtr;
}
public void setPricePerLtr(double pricePerLtr) {
	this.pricePerLtr = pricePerLtr;
}
public double getPricePerCount() {
	return pricePerCount;
}
public void setPricePerCount(double pricePerCount) {
	this.pricePerCount = pricePerCount;
}
public double getDiscountedPrice() {
	return discountedPrice;
}
public void setDiscountedPrice(double discountedPrice) {
	this.discountedPrice = discountedPrice;
}
public Integer getCategoryId() {
	return categoryId;
}
public void setCategoryId(Integer categoryId) {
	this.categoryId = categoryId;
}
public Integer getDiscountId() {
	return discountId;
}
public void setDiscountId(Integer discountId) {
	this.discountId = discountId;
}
public Stock orElseThrow(Object object) {
	// TODO Auto-generated method stub
	return null;
}

}
