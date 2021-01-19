package com.qintess.dvdrental.entidades;

public class Rental {
	
	private int rentalId;
	private Inventory inventory;
	private Customer customer;
	private Staff staff;
	
	public Rental(int rentalId, Inventory inventory, Customer customer, Staff staff) {
		super();
		this.rentalId = rentalId;
		this.inventory = inventory;
		this.customer = customer;
		this.staff = staff;
	}

	public int getRentalId() {
		return rentalId;
	}

	public void setRentalId(int rentalId) {
		this.rentalId = rentalId;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
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
	
	
	
	
	
}
