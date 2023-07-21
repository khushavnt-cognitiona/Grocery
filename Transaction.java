package com.grocery.model;

public class Transaction 
{
	private Integer transactionId;
	private String transactiondate;
	private String transactiontime; 
	private Double cashback;
	private Double transactionamount;
	private Integer customerId;
	private Integer modeId;
	private Integer orderId;
	public Integer getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}
	public String getTransactiondate() {
		return transactiondate;
	}
	public void setTransactiondate(String transactiondate) {
		this.transactiondate = transactiondate;
	}
	public String getTransactiontime() {
		return transactiontime;
	}
	public void setTransactiontime(String transactiontime) {
		this.transactiontime = transactiontime;
	}
	public Double getCashback() {
		return cashback;
	}
	public void setCashback(Double cashback) {
		this.cashback = cashback;
	}
	public Double getTransactionamount() {
		return transactionamount;
	}
	public void setTransactionamount(Double transactionamount) {
		this.transactionamount = transactionamount;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Integer getModeId() {
		return modeId;
	}
	public void setModeId(Integer modeId) {
		this.modeId = modeId;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	
}
