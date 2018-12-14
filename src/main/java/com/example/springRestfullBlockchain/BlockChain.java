package com.example.springRestfullBlockchain;

import java.util.ArrayList;
import java.util.List;

public class BlockChain {
	
	
	public List<Block> arraychain = new ArrayList<Block>();
	
	 public BlockChain() {
		 Block genericBlock = new Block("01/01/2018", "1000");
		 genericBlock.setPreviousHash(0);
		 //genericBlock.setHash(genericBlock.calculateHash());
		 arraychain.add(genericBlock);
	}
	
	 
	 public Block lastBlock() {
			return arraychain.get(arraychain.size()-1);
	}
	 
	public void createNewBlock(Block newBlock) {
		newBlock.setPreviousHash(this.lastBlock().getHash());
		//newBlock.setHash(newBlock.calculateHash());
		arraychain.add(newBlock);
	}
	
	public boolean checkBlockContrainst() {
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

}
