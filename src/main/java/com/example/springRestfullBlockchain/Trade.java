package com.example.springRestfullBlockchain;

public class Trade {
	
	private String sendAddress;
	private String recieveAddress;
	private int amount;
	
	public Trade(String sendAddress, String recieveAddress, int amount) {
		super();
		this.sendAddress = sendAddress;
		this.recieveAddress = recieveAddress;
		this.amount = amount;
	}
	public String getSendAddress() {
		return sendAddress;
	}
	public void setSendAddress(String sendAddress) {
		this.sendAddress = sendAddress;
	}
	public String getRecieveAddress() {
		return recieveAddress;
	}
	public void setRecieveAddress(String recieveAddress) {
		this.recieveAddress = recieveAddress;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public String toString() {
		return this.sendAddress + this.recieveAddress + this.amount;
	}
	

}
