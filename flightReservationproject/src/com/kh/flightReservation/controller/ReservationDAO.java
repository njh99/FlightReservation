package com.kh.flightReservation.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kh.flightReservation.model.ReservationAllVO;
import com.kh.flightReservation.model.ReservationVO;

public class ReservationDAO {
	public final String RESERVATION_SELECT="SELECT * FROM RESERVATION";
	public final String RESERVATION_INSERT="INSERT INTO RESERVATION VALUES(?, ?, ?, ?)";
	public final String RESERVATION_UPDATE="UPDATE RESERVATION SET ID = ?, FLIGHT_NO = ?, QUANTITY = ? WHERE NO = ?";
	public final String RESERVATION_DELETE="DELETE FROM RESERVATION WHERE NO = ?";
	public final String RESERVATION_JOIN="SELECT R.NO AS NO, R.FLIGHT_NO AS FLIGHT_NO, F.A_NO AS A_NO, R.ID AS ID, C.PASSWD AS PASSWD, C.NAME AS NAME, C.PASSPORT_NUMBER AS PASSPORT_NUMBER, C.MILEAGE AS MILEAGE, F.SEAT AS SEAT, F.DEPARTURE_DATE AS DEPARTURE_DATE, F.DEPARTURE_AIRPORT AS DEPARTURE_AIRPORT, F.ARRIVAL_AIRPORT AS ARRIVAL_AIRPORT, R.QUANTITY AS QUANTITY, F.PRICE AS PRICE FROM RESERVATION R INNER JOIN CUSTOMER C ON R.ID=C.ID INNER JOIN FLIGHT F ON R.FLIGHT_NO=F.NO";

	

	public ArrayList<ReservationVO> reservationSelect() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<ReservationVO> reservationList=new ArrayList<ReservationVO>();
		try {
			con=DBUtility.dbCon();
			pstmt=con.prepareStatement(RESERVATION_SELECT);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int no=rs.getInt("NO");
				String id=rs.getString("ID");
				int flight_no=rs.getInt("FLIGHT_NO");
				int quantity=rs.getInt("QUANTITY");
				ReservationVO reservationVO=new ReservationVO(no, id, flight_no, quantity);
				reservationList.add(reservationVO);
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBUtility.dbClose(con, pstmt, rs);
		}
		return reservationList;
	}
	
	public boolean reservationInsert(ReservationVO rvo) {
 		boolean successFlag=false;
 		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=DBUtility.dbCon();
			pstmt=con.prepareStatement(RESERVATION_INSERT);
			pstmt.setInt(1, rvo.getNo());
			pstmt.setString(2, rvo.getId());
			pstmt.setInt(3, rvo.getFlight_no());
			pstmt.setInt(4, rvo.getQuantity());
			int count=pstmt.executeUpdate();
			successFlag=(count!=0)?(true):(false);
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBUtility.dbClose(con, pstmt);
		}
		return successFlag;
 	}
	
	public boolean reservationUpdate(ReservationVO rvo) {
 		boolean successFlag=false;
 		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=DBUtility.dbCon();
			pstmt=con.prepareStatement(RESERVATION_UPDATE);
			pstmt.setString(1, rvo.getId());
			pstmt.setInt(2, rvo.getFlight_no());
			pstmt.setInt(3, rvo.getQuantity());
			pstmt.setInt(4, rvo.getNo());
			int count=pstmt.executeUpdate();
			successFlag=(count!=0)?(true):(false);
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBUtility.dbClose(con, pstmt);
		}
		return successFlag;
 	}
	
	public boolean reservationDelete(ReservationVO rvo) {
 		boolean successFlag=false;
 		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=DBUtility.dbCon();
			pstmt=con.prepareStatement(RESERVATION_DELETE);
			pstmt.setInt(1, rvo.getNo());
			int count=pstmt.executeUpdate();
			successFlag=(count!=0)?(true):(false);
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBUtility.dbClose(con, pstmt);
		}
		return successFlag;
 	}
	
	public ArrayList<ReservationAllVO> reservationAllSelect() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<ReservationAllVO> ReservationAllList = new ArrayList<ReservationAllVO>();
		con = DBUtility.dbCon();
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(RESERVATION_JOIN);
			if(rs.next()) {
				do{
					int no=rs.getInt("NO");
					int flight_no=rs.getInt("FLIGHT_NO");
					int a_no=rs.getInt("A_NO");
					String id=rs.getString("ID");
					String passwd=rs.getString("PASSWD");
					String name=rs.getString("NAME");
					String passport_number=rs.getString("PASSPORT_NUMBER");
					int mileage=rs.getInt("MILEAGE");
					String seat=rs.getString("SEAT");
					Date departure_date=rs.getDate("DEPARTURE_DATE");
					String departure_airport=rs.getString("DEPARTURE_AIRPORT");
					String arrival_airport=rs.getString("ARRIVAL_AIRPORT");
					int quantity=rs.getInt("QUANTITY");
					int price=rs.getInt("PRICE");
					ReservationAllVO res = new ReservationAllVO(no, flight_no, a_no, id, passwd, name, passport_number, mileage, seat, departure_date, departure_airport, arrival_airport, quantity, price);
					ReservationAllList.add(res);
				}while (rs.next());
			}else {
				ReservationAllList = null; 
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBUtility.dbClose(con, stmt, rs);
		}
		return ReservationAllList;
	}
	
}
