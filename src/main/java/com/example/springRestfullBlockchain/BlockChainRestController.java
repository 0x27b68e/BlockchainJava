package com.example.springRestfullBlockchain;

import java.security.NoSuchAlgorithmException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.db.dialect.MySQLDialect;

@RestController
public class BlockChainRestController  {
	
	public static BlockChain  blockChain = new BlockChain();
	public String myaddress ="myaddress";
	
	static {
		/*Block block2 = new Block("02/01/2018", "350");
		blockChain.createNewBlock(block2);
		
		Block block3 = new Block("05/01/2018", "200");
		blockChain.createNewBlock(block3);*/
		
		blockChain.createTrading(new Trade("AAddress", "BAddress", 350));
		blockChain.createTrading(new Trade("BAddress", "CAddress", 200));	
		System.out.println("start to tranding!");
	}
	
	@RequestMapping(value = "/blocks", method = RequestMethod.GET)
	public ResponseEntity<Object> blocks() {
		 return new ResponseEntity<>(blockChain.arraychain.toString(), HttpStatus.OK);
	}
	
	// mining coin using my laptop
	@RequestMapping(value = "miningBlocks", method = RequestMethod.POST)
	public ResponseEntity<Object> miningNewBlock() throws NoSuchAlgorithmException {
		blockChain.miningCoin(myaddress);
		return new ResponseEntity<>("mining new block success", HttpStatus.CREATED);
	}
	
	// checkMoney
	@RequestMapping(value = "checkMoney")
	public int checkMoney() {
		return blockChain.checkMoney("CAddress");
	}
	
	
	@RequestMapping(value = "/addBlocks", method = RequestMethod.POST)
	public ResponseEntity<Object> addNewBlock(@RequestBody Block newBlock) throws NoSuchAlgorithmException {
		blockChain.createNewBlock(newBlock);
		return new ResponseEntity<>("Add new block ok!", HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/checkContrainstTrue", method = RequestMethod.GET)
	@ResponseBody
	public Boolean checkContrainstTrue() throws NoSuchAlgorithmException  {
		return  blockChain.checkBlockContrainst();
	}
	
	@RequestMapping(value = "/checkContrainstFalse", method = RequestMethod.GET)
	@ResponseBody
	public Boolean checkContrainstFalse() throws NoSuchAlgorithmException{
		blockChain.arraychain.get(2).setData("350");
		return  blockChain.checkBlockContrainst();
	}
	
	
}
