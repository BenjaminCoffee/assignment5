package com.meritamerica.assignment5.model;

public class CDOffering {
	int term;
	double interestRate;
	
	public CDOffering() {
		this.interestRate = 0;
		this.term = 0;
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	
}
