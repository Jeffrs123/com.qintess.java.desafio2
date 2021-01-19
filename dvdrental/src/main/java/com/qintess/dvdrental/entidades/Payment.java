package com.qintess.dvdrental.entidades;

public class Payment {
	
	private int paymentID;
	private Customer customer;
	private Staff staff;
	private Rental rental;
	private double amount;
	
	public Payment(int paymentID, Customer customer, Staff staff, Rental rental, double amount) {
		super();
		this.paymentID = paymentID;
		this.customer = customer;
		this.staff = staff;
		this.rental = rental;
		this.amount = amount;
	}

	public int getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public Rental getRental() {
		return rental;
	}

	public void setRental(Rental rental) {
		this.rental = rental;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	
	
	

}
