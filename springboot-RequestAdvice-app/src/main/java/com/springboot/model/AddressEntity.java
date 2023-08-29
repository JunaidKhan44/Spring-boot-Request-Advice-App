/**
 * 
 */
package com.springboot.model;

import java.io.Serializable;

/**
 * @author Junaid.khan
 *
 */
public class AddressEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String city;
	private String doorNo;
	private String state;
	private String street;
	private String zipCode;
	
	public AddressEntity() {
		super();
	
	}

	public AddressEntity(String city, String doorNo, String state, String street, String zipCode) {
		super();
		this.city = city;
		this.doorNo = doorNo;
		this.state = state;
		this.street = street;
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	
	

}
