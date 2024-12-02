package com.kh.flightReservation.model;

public class ReservationVO {
	int no;		//pk
	String id;	//fk
	int flight_no;	//fk
	int quantity;
	
	public ReservationVO() {}

	public ReservationVO(int no, String id, int flight_no, int quantity) {
		super();
		this.no = no;
		this.id = id;
		this.flight_no = flight_no;
		this.quantity = quantity;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getFlight_no() {
		return flight_no;
	}

	public void setFlight_no(int flight_no) {
		this.flight_no = flight_no;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "ReservationVO [no=" + no + ", id=" + id + ", flight_no=" + flight_no + ", quantity=" + quantity + "]";
	}
	
	
	
	
}
