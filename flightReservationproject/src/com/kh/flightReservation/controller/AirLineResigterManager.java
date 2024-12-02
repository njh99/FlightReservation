package com.kh.flightReservation.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.flightReservation.model.AirLineVO;

public class AirLineResigterManager {
	public static Scanner sc = new Scanner(System.in);

	// 삽입
	public void insertManager(){
		AirLineDAO adao = new AirLineDAO();
		System.out.print("항공사 번호를 입력하세요>>");
		int no = Integer.parseInt(sc.nextLine());
		System.out.print("항공사 이름을 입력하세요>>");
		String name = sc.nextLine();
		System.out.print("항공사 영문이름을 입력하세요>>");
		String englishName = sc.nextLine();
		System.out.print("항공사의 국가를 입력하세요>>");
		String country = sc.nextLine();
		System.out.print("항공사의 등급을 입력하세요>>");
		String grade = sc.nextLine();
		AirLineVO airLineVO = new AirLineVO(no, name, englishName, country, grade);
		boolean successFlag = adao.airLineInsert(airLineVO);
		if (successFlag == true) {
			System.out.println("삽입 성공");
		} else {
			System.out.println("삽입 실패");
		}
	}

	// 수정
	public static void updateManager(){

		AirLineDAO adao = new AirLineDAO();
		System.out.print("수정할 항공사 번호를 입력하세요>>");
		int no = Integer.parseInt(sc.nextLine());
		System.out.print("수정할 항공사 이름을 입력하세요>>");
		String name = sc.nextLine();
		System.out.print("수정할 항공사 영문이름을 입력하세요>>");
		String englishName = sc.nextLine();
		System.out.print("수정할 항공사의 국가를 입력하세요>>");
		String country = sc.nextLine();
		System.out.print("수정할 항공사의 등급을 입력하세요>>");
		String grade = sc.nextLine();
		AirLineVO avo = new AirLineVO(no, name, englishName, country, grade);
		boolean successFlag = adao.airLineUpdate(avo);
		if (successFlag == true) {
			System.out.println("수정 성공");
		} else {
			System.out.println("수정 실패");
		}
	}

	// 삭제
	public void deleteManager(){
		AirLineDAO adao = new AirLineDAO();
		System.out.println("삭제할 항공사의 번호를 입력하세요");
		int no = Integer.parseInt(sc.nextLine());
		AirLineVO pvo = new AirLineVO();
		pvo.setNo(no);
		boolean successFlag = adao.airLineDelete(pvo);
		if (successFlag == true) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");
		}
	}

	// 출력
	public void listManager(){
		AirLineDAO adao = new AirLineDAO();
		ArrayList<AirLineVO> playerlist = new ArrayList<AirLineVO>();
		playerlist = adao.airLinePrint();
		printairLineList(playerlist);

	}

	// FUNC
	public void funcManager(){
		AirLineDAO adao = new AirLineDAO();
		System.out.println("검색할 항공사이름을 입력하세요");
		String name = sc.nextLine();
		AirLineVO avo = new AirLineVO();
		avo.setName(name);;
		boolean successFlag = adao.airLineFunc(avo);;
		if (successFlag == true) {
			System.out.println("성공적으로 처리되었습니다.");
		} else {
			System.out.println("없는 항공사입니다.");
		}
	}

	// 출력문
	public void printairLineList(ArrayList<AirLineVO> list) {
		System.out.println("==============================================================================");
        System.out.println("항공사 번호\t\t항공사 이름\t\t항공사영문명\t\t항공사국가\t\t항공사등급");
        for (AirLineVO data : list) {
            System.out.println(data.getNo()+"\t\t"+data.getName()+"\t\t"+data.getEnglishName()+"\t\t"+data.getCountry()+"\t\t"+data.getGrade());
        }
        System.out.println("==============================================================================");
    }

}
