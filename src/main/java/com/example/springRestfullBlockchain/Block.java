package com.example.springRestfullBlockchain;


public class Block {
	
	private String createDate;
	private String data;
	private int hash;
	private int previousHash;
	
	public String getData() {
		return data;
	}

	public int calculateHash() {

		return createDate.hashCode() + data.hashCode();
	}

	public void setData(String data) {
		this.data = data;
	}


	public Block(String createDate, String data) {
		this.createDate = createDate;
		this.data = data;
		this.hash = this.calculateHash();
	}
	

	public String getCreateDate() {
		return createDate;
	}


	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public int getHash() {
		return hash;
	}

	public void setHash(int hash) {
		this.hash = hash;
	}

	public int getPreviousHash() {
		return previousHash;
	}

	public void setPreviousHash(int previousHash) {
		this.previousHash = previousHash;
	}

	public String toString() {
		return String.valueOf(calculateHash());
	}
}
