package com.visa.training.domain;

public class CurrentAccount extends Account{
	float odLimit ;

	public float getOdLimit() {
		return odLimit;
	}

	public void setOdLimit(float odLimit) {
		this.odLimit = odLimit;
	}

	public CurrentAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CurrentAccount(float balance,float odLimit) {
		super(balance) ;
		this.odLimit = odLimit ;
	}

}
// account type is the discriminator 
