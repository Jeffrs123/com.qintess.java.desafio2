package com.qintess.dvdrental.entidades;

import java.util.Scanner;

public class Store {
	
	private int id;
	private int staffId;
	private FullAddress fullAddress;
	
	
	public Store(int id, int staffId, FullAddress fullAddress) {
		super();
		this.id = id;
		this.staffId = staffId;
		this.fullAddress = fullAddress;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getStaffId() {
		return staffId;
	}


	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}


	public FullAddress getFullAddress() {
		return fullAddress;
	}


	public void setFullAddress(FullAddress fullAddress) {
		this.fullAddress = fullAddress;
	}
	
	
	public void defineStore() {
		
		
	}
	
	
	
	
	

}
