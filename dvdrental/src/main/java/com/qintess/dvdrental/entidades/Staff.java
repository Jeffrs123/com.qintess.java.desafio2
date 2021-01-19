package com.qintess.dvdrental.entidades;

public class Staff {
	
	private int staffId;
	private String firstName;
	private String lastName;
	private FullAddress fullAddress;
	private String email;
	private Store store;
	private String username;
	private String password;
	
	
	public Staff(int staffId, String firstName, String lastName, FullAddress fullAddress, String email, Store store,
			String username, String password) {
		super();
		this.staffId = staffId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.fullAddress = fullAddress;
		this.email = email;
		this.store = store;
		this.username = username;
		this.password = password;
	}


	public int getStaffId() {
		return staffId;
	}


	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public FullAddress getFullAddress() {
		return fullAddress;
	}


	public void setFullAddress(FullAddress fullAddress) {
		this.fullAddress = fullAddress;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Store getStore() {
		return store;
	}


	public void setStore(Store store) {
		this.store = store;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	

}
