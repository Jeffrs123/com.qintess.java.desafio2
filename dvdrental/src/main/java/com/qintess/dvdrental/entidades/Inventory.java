package com.qintess.dvdrental.entidades;

public class Inventory {
	
	private int inventoryId;
	private Film film;
	private Store store;
	
	
	
	
	public Inventory(int inventoryId, Film film, Store store) {
		super();
		this.inventoryId = inventoryId;
		this.film = film;
		this.store = store;
	}
	
	public int getInventoryId() {
		return inventoryId;
	}
	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}
	public Film getFilm() {
		return film;
	}
	public void setFilm(Film film) {
		this.film = film;
	}
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	
	
	

}
