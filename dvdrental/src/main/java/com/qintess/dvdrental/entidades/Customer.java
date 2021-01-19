package com.qintess.dvdrental.entidades;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.directory.InvalidAttributesException;

public class Customer {

	private int customerId;
	private String firstName;
	private String lastName;
	private String email;
	private int active;
	private String status;
	private FullAddress fullAddress;
	private Store store;

	public Customer() {}

	public Customer(String firstName, String lastName,String email, int active, FullAddress fullAddress, Store store ) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.active = active;
		this.fullAddress = fullAddress;
		this.store = store;
	}

	public Customer( String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}


	public void preencherCustomer(ResultSet rs) throws SQLException {
		this.customerId = rs.getInt("customer_id");
		this.firstName = rs.getString("first_name");
		this.lastName = rs.getString("last_name");
		this.email = rs.getString("email");

	}

	public Customer (ResultSet rs) {
		try {
			this.customerId = rs.getInt("customer_id");
			this.firstName = rs.getString("first_name");
			this.lastName = rs.getString("last_name");
			this.email = rs.getString("email");
			this.active = rs.getInt("active");

		} catch (SQLException e) {
			System.err.println("Deu erro: " + e);
			e.printStackTrace();
		}
	}

//	public String formataEndereco() throws InvalidAttributesException {
//
//		if(fullAddress == null)
//			throw new InvalidAttributesException("FullAddress está nulo");
//
//		// endereço completo: address, postal_code - cidade - country
//		return fullAddress.getAddress() + ", " 
//		+ fullAddress.getPostalCode() 
//		+ " - " + fullAddress.getCity() 
//		+ " - " + fullAddress.getCountry();
//	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getStatus() {
		return status;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setActive(String status) {
		this.status = status.equals("1") ? "Ativo" : "Inativo"; 
	}

	public FullAddress getFullAddress() {
		return fullAddress;
	}

	public void setFullAddress(FullAddress fullAddress) {
		this.fullAddress = fullAddress;
	}

	@Override
	public String toString() {
		
		if(fullAddress != null) {
			
			return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
					+ email + ", active=" + active + ", status=" + status + ", store="
					+ store + "]" + "\nfullAddress=" + fullAddress;
		}
		return  "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
		+ email + ", active=" + active + ", status=" + status +  ", store="
		+ store + "]";
		
	}


	
	
	


}
