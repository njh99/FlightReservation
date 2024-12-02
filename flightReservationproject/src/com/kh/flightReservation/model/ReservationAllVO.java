package com.kh.flightReservation.model;

import java.sql.Date;

public class ReservationAllVO {
	int no;						//예약번호 R
	int flight_no;				//항공편 R
	int a_no;					//항공사번호 F
	String id;					//고객아이디 R
	String passwd;				//비밀번호 C
	String name;				//고객이름 C
	String passport_number;		//여권번호 C
	int mileage;				//마일리지 C
	String seat;				//좌석 F
	Date departure_date;		//출발날짜 F
	String departure_airport;	//출발공항 F
	String arrival_airport;		//도착공항 F
	int quantity;				//예매매수 R
	int price;					//가격 F
	public ReservationAllVO(int no, int flight_no, int a_no, String id, String passwd, String name,
			String passport_number, int mileage, String seat, Date departure_date, String departure_airport,
			String arrival_airport, int quantity, int price) {
		super();
		this.no = no;
		this.flight_no = flight_no;
		this.a_no = a_no;
		this.id = id;
		this.passwd = passwd;
		this.name = name;
		this.passport_number = passport_number;
		this.mileage = mileage;
		this.seat = seat;
		this.departure_date = departure_date;
		this.departure_airport = departure_airport;
		this.arrival_airport = arrival_airport;
		this.quantity = quantity;
		this.price = price;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getFlight_no() {
		return flight_no;
	}
	public void setFlight_no(int flight_no) {
		this.flight_no = flight_no;
	}
	public int getA_no() {
		return a_no;
	}
	public void setA_no(int a_no) {
		this.a_no = a_no;
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
	public String getPassport_number() {
		return passport_number;
	}
	public void setPassport_number(String passport_number) {
		this.passport_number = passport_number;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	public Date getDeparture_date() {
		return departure_date;
	}
	public void setDeparture_date(Date departure_date) {
		this.departure_date = departure_date;
	}
	public String getDeparture_airport() {
		return departure_airport;
	}
	public void setDeparture_airport(String departure_airport) {
		this.departure_airport = departure_airport;
	}
	public String getArrival_airport() {
		return arrival_airport;
	}
	public void setArrival_airport(String arrival_airport) {
		this.arrival_airport = arrival_airport;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "ReservationAllVO [no=" + no + ", flight_no=" + flight_no + ", a_no=" + a_no + ", id=" + id + ", passwd="
				+ passwd + ", name=" + name + ", passport_number=" + passport_number + ", mileage=" + mileage
				+ ", seat=" + seat + ", departure_date=" + departure_date + ", departure_airport=" + departure_airport
				+ ", arrival_airport=" + arrival_airport + ", quantity=" + quantity + ", price=" + price + "]";
	}
	
	
}
