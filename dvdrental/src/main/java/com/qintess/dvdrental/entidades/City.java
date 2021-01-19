package com.qintess.dvdrental.entidades;

public class City {

	private int cityId;
	private String city;
	private Country country;
	
	
	public City(int cityId, String city, Country country) {
		super();
		this.cityId = cityId;
		this.city = city;
		this.country = country;
	}


	public int getCityId() {
		return cityId;
	}


	public void setCityId(int cityId) {
		this.cityId = cityId;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public Country getCountry() {
		return country;
	}


	public void setCountry(Country country) {
		this.country = country;
	}
	
	
	
	
}
