package com.account.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.account.model.Account;
import com.account.model.AccountName;
import com.account.service.AccountService;

@RestController
@RequestMapping("/api")
public class TransactionController {

	@Autowired
	AccountService accountService;
	
	@GetMapping("/amount")
	private List<AccountName> getAmount(@RequestParam Map<String, String> customQuery) 
	{
		String accid ="";
		String transactionType="";
		String lowerdate="";
		String upperdate="";
		if(customQuery.containsKey("accid")) {
			accid = customQuery.get("accid");
		}
		if(customQuery.containsKey("transactionType")) {
			transactionType = customQuery.get("transactionType");
		}
		if(customQuery.containsKey("lowerdate")) {
			lowerdate = customQuery.get("lowerdate");
		}
		if(customQuery.containsKey("upperdate")) {
			upperdate = customQuery.get("upperdate");
		}
		
	return accountService.getAmount(accid, transactionType, lowerdate, upperdate);
	}
	
	@GetMapping("/balance")
	private Account getTotalBalance(@RequestParam Map<String, String> customQuery) 
	{
		String accid ="";
		if(customQuery.containsKey("accid")) {
			accid = customQuery.get("accid");
		}
		return accountService.getTotalBalance(accid);
	}
	

}
