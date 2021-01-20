package com.account.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.account.model.Account;
import com.account.model.AccountName;
import com.account.repository.AccountRepository;


@Service
public class AccountService {
	
	@Autowired
	AccountRepository accountRepository;
	
	public List<AccountName> getAmount(String accid, String transaction_type, String lowerdate, String upperdate) 
	{
		Date lowerdate_date = null;
		Date upperdate_date  = null;
		try {
			 lowerdate_date =new SimpleDateFormat("yyyy-MM-dd").parse(lowerdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		try {
			 upperdate_date =new SimpleDateFormat("yyyy-MM-dd").parse(upperdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	return accountRepository.getAccountList(accid, transaction_type, lowerdate_date, upperdate_date);
	
	}
	
	public Account getTotalBalance(String accid) 
	{
		return accountRepository.getAccount(accid);
		
	}

}
