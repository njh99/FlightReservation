package com.kh.flightReservation.model;

public class CustomerVO {
	String id;					//pk
	String passwd;
	String name;
	String passportNumber;		//uk
	int mileage;
	
	public CustomerVO() {
		super();
	}
	
	public CustomerVO(String id, String passwd, String name, String passportNumber, int mileage) {
		super();
		this.id = id;
		this.passwd = passwd;
		this.name = name;
		this.passportNumber = passportNumber;
		this.mileage = mileage;
	}
	
	public CustomerVO(String id, String passwd, String name, String passportNumber) {
		this.id = id;
		this.passwd = passwd;
		this.name = name;
		this.passportNumber = passportNumber;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	
	@Override
	public String toString() {
		return String.format("%-16s", id) + String.format("%-17s", passwd) + String.format("%-17s", name) + String.format("%-17s", passportNumber) 
		+String.format("%-16s", mileage);
	}
}
