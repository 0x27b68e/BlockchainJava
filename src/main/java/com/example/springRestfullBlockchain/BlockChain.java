package com.example.springRestfullBlockchain;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlockChain {
	
	
	public List<Block> arraychain = new ArrayList<Block>();
	public List<Trade> pendingTrade = new ArrayList<Trade>();
	private int rewardcoin = 100;
	
	 public BlockChain() {
		 Block genericBlock;
		try {
			genericBlock = new Block(new Date("01/01/2018"), "1000");
			arraychain.add(genericBlock);
			genericBlock.setPreviousHash("");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	
	 
	 public Block lastBlock() {
			return arraychain.get(arraychain.size()-1);
	}
	 
	 // create miningCoin function
	 
	 public void miningCoin(String receiveAddress) throws NoSuchAlgorithmException {
		 Block newBlock = new Block(new Date(), this.pendingTrade, lastBlock().getHash());
		 
		 newBlock.miningBlock("00000");
		 arraychain.add(newBlock);
		 
		 this.pendingTrade.add(new Trade(null, receiveAddress, this.getRewardcoin()));
		 
	 }
	 
	 //check money in wallet
	 public int checkMoney(String checkedaddress) {
		 int moneyInAddress = 0;
		 for (int i = 0; i < arraychain.size(); i++) {
			for (int j = 0; j < arraychain.get(i).getListTrade().size(); j++) {
				Trade trade = arraychain.get(i).getListTrade().get(j);
				if(trade.getSendAddress() == checkedaddress) {
					moneyInAddress -= trade.getAmount();
				}
				
				if(trade.getRecieveAddress() == checkedaddress) {
					moneyInAddress += trade.getAmount();
				}
			}
		}
		 return moneyInAddress;
	 }
	 
	 // create trading
	 public void createTrading(Trade newTrade) {
		 this.pendingTrade.add(newTrade);
	 }
	 
	 
	public void createNewBlock(Block newBlock) throws NoSuchAlgorithmException {
		newBlock.setPreviousHash(this.lastBlock().getHash());
		//newBlock.setHash(newBlock.calculateHash());
		newBlock.miningBlock("00");
		arraychain.add(newBlock);
	}
	
	public boolean checkBlockContrainst() throws NoSuchAlgorithmException {
		for (int i = 1; i < arraychain.size(); i++) {
			Block currentBlock = arraychain.get(i);
			Block lastBlock = arraychain.get(i-1);
			//Kiểm tra lại Hash của toàn bộ Block hiện tại và Hash đã lưu xem có trùng nhau không.
			if(currentBlock.getHash() != currentBlock.calculateHash()) 
				return false; //Nếu không trùng tức là Dữ liệu trong Block hiện tại đã bị chỉnh sửa, hàm checkBlockContrainst sẽ trả về false luôn.
			//Lấy Hash hiện tại và Hash phần tử trước đó đã lưu xem có trùng nhau không.
			if(currentBlock.getPreviousHash() != lastBlock.getHash()) 
				return false; //Nếu không trùng tức là Hash của Block hiện tại đã bị chỉnh sửa, hàm KiemTraToanVen sẽ trả về false luôn.
		}
		return true; //Nếu kiểm tra hết toàn bộ trong vòng For mà không vấn đề gì thì tức là Blockchain vẫn toàn vẹn, chưa bị sửa đổi.
	}


	public int getRewardcoin() {
		return rewardcoin;
	}


	public void setRewardcoin(int rewardcoin) {
		this.rewardcoin = rewardcoin;
	}


	public List<Block> getArraychain() {
		return arraychain;
	}


	public void setArraychain(List<Block> arraychain) {
		this.arraychain = arraychain;
	}


	public List<Trade> getPendingTrade() {
		return pendingTrade;
	}


	public void setPendingTrade(List<Trade> pendingTrade) {
		this.pendingTrade = pendingTrade;
	}

}
