package com.example.springRestfullBlockchain;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlockChainRestController {
	
	public static BlockChain  blockChain = new BlockChain();
	
	static {
		Block block2 = new Block("02/01/2018", "350");
		blockChain.createNewBlock(block2);
		
		Block block3 = new Block("05/01/2018", "200");
		blockChain.createNewBlock(block3);
		
	}
	
	@RequestMapping(value = "/blocks", method = RequestMethod.GET)
	public ResponseEntity<Object> blocks() {
		 return new ResponseEntity<>(blockChain.arraychain.toString(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/addBlocks", method = RequestMethod.POST)
	public ResponseEntity<Object> addNewBlock(@RequestBody Block newBlock) {
		blockChain.createNewBlock(newBlock);
		return new ResponseEntity<>("Add new block ok!", HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/checkContrainstTrue", method = RequestMethod.GET)
	@ResponseBody
	public Boolean checkContrainstTrue() {
		return  blockChain.checkBlockContrainst();
	}
	
	@RequestMapping(value = "/checkContrainstFalse", method = RequestMethod.GET)
	@ResponseBody
	public Boolean checkContrainstFalse() {
		blockChain.arraychain.get(2).setData("350");
		return  blockChain.checkBlockContrainst();
	}
	
	
}
