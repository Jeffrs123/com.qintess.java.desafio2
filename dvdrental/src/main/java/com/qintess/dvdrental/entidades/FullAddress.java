package com.qintess.dvdrental.entidades;

public class FullAddress {

	private int id;
	private String address;
	private String addressB;
	private String district;
	private String city;
	private String country;
	private int postalCode;
	private int phone;


	public FullAddress() {}


	public FullAddress(int id, String address,String addressB, String district, String city, String country, int postalCode) {
		super();
		this.id = id;
		this.address = address;
		this.addressB = addressB;
		this.district = district;
		this.city = city;
		this.country = country;
		this.postalCode = postalCode;
	}


	public FullAddress(int id, String address, String district, String city, String country, int postalCode) {
		super();
		this.id = id;
		this.address = address;
		this.district = district;
		this.city = city;
		this.country = country;
		this.postalCode = postalCode;
	}





	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public int getPostalCode() {
		return postalCode;
	}



	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}





	public String getDistrict() {
		return district;
	}





	public void setDistrict(String district) {
		this.district = district;
	}





	public int getPhone() {
		return phone;
	}





	public void setPhone(int phone) {
		this.phone = phone;
	}


	@Override
	public String toString() {
		return "FullAddress [id=" + id + ", address=" + address + ", addressB=" + addressB + ", district=" + district
				+ ", city=" + city + ", country=" + country + ", postalCode=" + postalCode + ", phone=" + phone + "]";
	}






}
