package com.meritamerica.assignment5.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.meritamerica.assignment5.exceptions.NoSuchResourceFoundExcepetion;
import com.meritamerica.assignment5.model.AccountHolder;
import com.meritamerica.assignment5.model.CDAccounts;
import com.meritamerica.assignment5.model.CDOffering;
import com.meritamerica.assignment5.model.CheckingAccount;
import com.meritamerica.assignment5.model.SavingsAccount;
	
@RestController
public class MeritBankController {

	List<String> temp = new ArrayList<String>();
	List<CDOffering> cdOfferings = new ArrayList<CDOffering>();
	List<AccountHolder> accHolders = new ArrayList<AccountHolder>();
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "/AccountHolders")
	public AccountHolder addAcc(@RequestBody AccountHolder acc){
		accHolders.add(acc);
		return acc;
	}
	@GetMapping(value = "/AccountHolders")
	 public List<AccountHolder> getAccs() {
		 return accHolders;
	 }
	
	@GetMapping(value = "/AccountHolders/{id}")
	public AccountHolder getAccById(@PathVariable int id) throws NoSuchResourceFoundExcepetion{
		if(id > accHolders.size()) {
			
			throw new NoSuchResourceFoundExcepetion("invalid id");
		}
		
		return accHolders.get(id - 1);
	}
	
	@PostMapping(value = "/AccountHolders/{id}/CheckingAccounts")
	public CheckingAccount addCheckingByAccId(@PathVariable int id, @RequestBody CheckingAccount acc) {
		accHolders.get(id - 1).addChecking(acc);
		return acc;
	}
	
	@GetMapping(value = "/AccountHolders/{id}/CheckingAccounts")
	public List<CheckingAccount> getCheckingByAccountId(@PathVariable int id) {
		return accHolders.get(id - 1).getCheckingAccount();
	}
	
	
	@PostMapping(value = "/AccountHolders/{id}/SavingsAccounts")
	public SavingsAccount addSavingsByAccId(@PathVariable int id, @RequestBody SavingsAccount acc) {
		accHolders.get(id - 1).addSavings(acc);
		return acc;
	}
	
	@GetMapping(value = "/AccountHolders/{id}/SavingsAccounts")
	public List<SavingsAccount> getSavingsByAccountId(@PathVariable int id) {
		return accHolders.get(id - 1).getSavingsAccount();
	}
	
	
	@PostMapping(value = "/AccountHolders/{id}/CDAccounts")
	public CDAccounts addCDAccountByAccId(@PathVariable int id, @RequestBody CDAccounts acc) {
		accHolders.get(id - 1).addCDAccounts(acc);
		return acc;
	}
	
	@GetMapping(value = "/AccountHolders/{id}/CDAccounts")
	public List<CDAccounts> getCDAccountsByAccountId(@PathVariable int id) {
		return accHolders.get(id - 1).getCDAccount();
	}
	
	
	@PostMapping(value = "/AccountHolders/CDOfferings")
	public CDOffering addCDOffering(@RequestBody CDOffering off) {
		cdOfferings.add(off);
		return off;
	}
	
	@PostMapping(value = "/AccountHolders/CDOfferings")
	public List<CDOffering> getCDOfferings() {
		return cdOfferings;
	}
	
	
	
}
