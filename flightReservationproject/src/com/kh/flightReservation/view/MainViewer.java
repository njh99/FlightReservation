package com.kh.flightReservation.view;

public class MainViewer {
	
	public static void mainMenuView(){
		System.out.println("===============================메인 메뉴===============================");
		System.out.println("1. 고객 정보 관리 2. 항공사 관리 3. 항공편 관리 4. 항공편 예약 관리 5. 프로그램 종료");
		System.out.print("번호를 선택하세요>>");
	}

	public static void customerMenuView() {
		System.out.println("===============================고객 관리===============================");
		System.out.println("1. 고객 조회하기 2. 고객 등록하기 3. 고객 수정하기 4. 고객 삭제하기 5. 고객 등급 조회하기 6. 메인 메뉴로 돌아가기");
		System.out.print("번호를 선택하세요>>");
	}

	public static void airLineMenuView() {
		System.out.println("===============================항공사 관리===============================");
		System.out.println("1. 항공사 조회하기 2. 항공사 등록하기 3. 항공사 수정하기 4. 항공사 삭제하기 5. 항공사 등급 조회하기 6. 메인 메뉴로 돌아가기");
		System.out.print("번호를 선택하세요>>");
	}

	public static void flightMenuView() {
		System.out.println("===============================항공편 관리===============================");
		System.out.println("1. 항공편 조회하기 2. 항공편 등록하기 3. 항공편 수정하기 4. 항공편 삭제하기 5. 정렬하기 6. 항공편 가격 수정하기 7. 메인 메뉴로 돌아가기");
		System.out.print("번호를 선택하세요>>");
	}

	public static void reservationMenuView() {
		System.out.println("===============================항공권 예약 관리===============================");
		System.out.println("1. 항공권 조회하기 2. 항공권 예약하기 3. 항공권 수정하기 4. 항공권 삭제하기 5. 항공권 상세보기 6. 메인 메뉴로 돌아가기");
		System.out.print("번호를 선택하세요>>");
	}
	
}
