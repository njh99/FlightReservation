package com.kh.flightReservation.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.kh.flightReservation.model.ReservationAllVO;
import com.kh.flightReservation.model.ReservationVO;

public class ReservationRegisterManager {
	public Scanner sc = new Scanner(System.in);

	public void selectManager() {
		ReservationDAO rdao = new ReservationDAO();
		ArrayList<ReservationVO> reservationList = new ArrayList<ReservationVO>();

		reservationList = rdao.reservationSelect();
		if (reservationList.size() != 0) {
			printReservationList(reservationList);
		} else {
			System.out.println("출력할 데이터가 없습니다.");
			return;
		}
	}

	public void insertManager() {
		System.out.println("예약 가능한 항공편 정보");
		FlightRegisterManager frm = new FlightRegisterManager();
		frm.selectManager();
		ReservationDAO rdao = new ReservationDAO();
		System.out.print("예약번호를 입력하시오 : ");
		int no = Integer.parseInt((sc.nextLine()).trim());
		System.out.print("고객 아이디를 입력하시오 : ");
		String id = (sc.nextLine()).trim();
		System.out.print("항공편을 입력하시오 : ");
		int flight_no = Integer.parseInt((sc.nextLine()).trim());
		System.out.print("예매매수를 입력하시오 : ");
		int quantity = Integer.parseInt((sc.nextLine()).trim());

		ReservationVO rvo = new ReservationVO(no, id, flight_no, quantity);
		boolean successFlag = rdao.reservationInsert(rvo);

		if (successFlag == true) {
			System.out.println("입력 성공하였습니다.");
		} else {
			System.out.println("입력 실패하였습니다.");
		}
	}

	public void deleteManager() {
		ReservationDAO rdao = new ReservationDAO();
		ReservationVO rvo = new ReservationVO();

		ArrayList<ReservationVO> reservationList = new ArrayList<ReservationVO>();

		reservationList = rdao.reservationSelect();
		if (reservationList.size() != 0) {
			printReservationList(reservationList);
		} else {
			System.out.println("출력할 데이터가 없습니다.");
			return;
		}

		System.out.print("삭제할 데이터의 예약번호를 입력해주세요 : ");
		int no = Integer.parseInt((sc.nextLine()).trim());
		rvo.setNo(no);

		boolean successFlag = rdao.reservationDelete(rvo);

		if (successFlag == true) {
			System.out.println("삭제 완료 하였습니다.");
		} else {
			System.out.println("삭제에 실패하였습니다.");
		}
	}

	public void updateManager() {
		ReservationDAO rdao = new ReservationDAO();
		ReservationVO rvo = new ReservationVO();
		ArrayList<ReservationVO> reservationList = new ArrayList<ReservationVO>();

		reservationList = rdao.reservationSelect();
		if (reservationList.size() != 0) {
			printReservationList(reservationList);
		} else {
			System.out.println("출력할 데이터가 입력해주세요.");
			return;
		}

		System.out.print("수정할 데이터의 예약번호를 입력해주세요 : ");
		int no = Integer.parseInt(sc.nextLine().trim());

		System.out.print("고객 아이디를 입력해주세요 : ");
		String id = (sc.nextLine()).trim();

		System.out.print("항공편을 입력해주세요 : ");
		int flight_no = Integer.parseInt(sc.nextLine().trim());

		System.out.print("예매 매수를 입력해주세요 : ");
		int quantity = Integer.parseInt(sc.nextLine().trim());

		rvo = new ReservationVO(no, id, flight_no, quantity);
		boolean successFlag = rdao.reservationUpdate(rvo);

		if (successFlag == true) {
			System.out.println("수정 완료하였습니다.");
		} else {
			System.out.println("수정에 실패하였습니다.");
		}
	}

	public void selectAllManager() {
		ReservationDAO rdao = new ReservationDAO();
		ArrayList<ReservationAllVO> reservationAllList = new ArrayList<ReservationAllVO>();

		reservationAllList = rdao.reservationAllSelect();
		if (reservationAllList.size() != 0) {
			printAllReservationList(reservationAllList);
		} else {
			System.out.println("출력할 데이터가 없습니다.");
			return;
		}
	}

	private void printAllReservationList(ArrayList<ReservationAllVO> reservationAllList) {
		System.out.println("===========================================================================================================================================================================================================================================");
		System.out.println("예약번호\t\t항공편\t\t항공사번호\t\t고객아이디\t\t비밀번호\t\t고객이름\t\t여권번호\t\t마일리지\t\t좌석\t\t출발날짜\t\t출발공항\t\t도착공항\t\t예매매수\t\t가격");
		for (ReservationAllVO rv : reservationAllList) {
			System.out.println(rv.getNo()+"\t\t"+rv.getFlight_no()+"\t\t"+rv.getA_no()+"\t\t"+rv.getId()+"\t\t"+rv.getPasswd()+"\t\t"+rv.getName()+"\t\t"+rv.getPassport_number()+"\t"+rv.getMileage()+"\t\t"+rv.getSeat()+"\t\t"+rv.getDeparture_date()+"\t"+rv.getDeparture_airport()+"\t\t"+rv.getArrival_airport()+"\t\t"+rv.getQuantity()+"\t\t"+rv.getPrice());
		}
		System.out.println("==========================================================================================================================================================================================================================================");
	}

	private void printReservationList(ArrayList<ReservationVO> reservationList) {
		System.out.println("================================================================================");
		System.out.println("예약번호\t\t고객아이디\t\t항공편\t\t예매매수");
		for (ReservationVO rv : reservationList) {
			System.out.println(rv.getNo()+"\t\t"+rv.getId()+"\t\t"+rv.getFlight_no()+"\t\t"+rv.getQuantity());
		}
		System.out.println("================================================================================");
	}
}