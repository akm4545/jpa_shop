package com.jpa_shop.domain;

import javax.persistence.Embeddable;

@Embeddable
//값 타입으로 사용
public class Address {
	
	private String city;
	
	private String street;
	
	private String zipcode;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
}
