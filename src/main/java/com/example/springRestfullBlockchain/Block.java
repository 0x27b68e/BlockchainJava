package com.example.springRestfullBlockchain;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.DatatypeConverter;




public class Block {
	
	private Date createDate;
	private Date date;
	private String data;
	private String hash;
	private String previousHash;
	Long random = Long.MIN_VALUE;
	public List<Trade> listTrade = new ArrayList<Trade>();
	
	public Block(Date createDate, String data) throws NoSuchAlgorithmException {
		this.createDate = createDate;
		this.data = data;
		this.hash = this.calculateHash();
	}
	
	public Block(Date createDate, List<Trade> listTrade, String hash) throws NoSuchAlgorithmException {
		//this.date = date;
		this.createDate = createDate;
		this.listTrade = listTrade;
		this.hash = this.calculateHash();
	}
	
	public void miningBlock(String diff) throws NoSuchAlgorithmException {

		while(!this.hash.startsWith(diff) || this.hash == this.previousHash) {
			random = (long)(Math.random() * Long.MAX_VALUE + 1);
			this.hash = this.calculateHash();
			System.out.println(random);
		}
			System.out.println("Find new block!" + this.hash);
	}
	
	/*public String calculateHash() {
		String valueOf = String.valueOf(this.autoIncreate.hashCode());
		String md5 = DigestUtils.md5Hex(valueOf);
		return  md5;
	}*/
	
	// convert String to HASH
	public  String calculateHash() throws NoSuchAlgorithmException{
		String valueOf = String.valueOf(this.random.hashCode());
		
	    MessageDigest md = MessageDigest.getInstance("MD5");
	    md.update(valueOf.getBytes());
	    byte[] digest = md.digest();
	    
	    String myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
		return myHash;
	}
	
	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}
	

	public Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getPreviousHash() {
		return previousHash;
	}

	public void setPreviousHash(String previousHash) {
		this.previousHash = previousHash;
	}

	public List<Trade> getListTrade() {
		return listTrade;
	}

	public void setListTrade(List<Trade> listTrade) {
		this.listTrade = listTrade;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}	
	public String toString() {
		return hash.toString() + "ListTrace" + this.listTrade.toString();
	}
}
