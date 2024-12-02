package com.kh.flightReservation.controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import com.kh.flightReservation.model.AirLineVO;

public class AirLineDAO {
	public static String AIRLINE_SELECT = "SELECT * FROM AIRLINE";
    public static String AIRLINE_INSERT = "INSERT INTO AIRLINE VALUES(?,?,?,?,?)";
    public static String AIRLINE_UPDATE = "UPDATE AIRLINE SET NAME = ?, ENGLISH_NAME = ?, COUNTRY = ? , GRADE = ? WHERE NO = ?";
    public static String AIRLINE_DELETE = "DELETE FROM AIRLINE WHERE NO =?";
    public static String AIRLINE_GRADE_FUNC = "{ ? = CALL AIRLINE_GRADE_FUNC(?)}";
	public boolean airLineUpdate(AirLineVO avo){
		boolean successFlag = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
		con = DBUtility.dbCon();
		
		pstmt = con.prepareStatement(AIRLINE_UPDATE);
			pstmt.setString(1, avo.getName());
			pstmt.setString(2, avo.getEnglishName());
			pstmt.setString(3, avo.getCountry());
			pstmt.setString(4, avo.getGrade());
			pstmt.setInt(5, avo.getNo());
			int result = pstmt.executeUpdate();
			successFlag =(result !=0)?true:false;
		} catch (SQLException e) {
			System.out.println(e.toString());
		}finally {
			
			DBUtility.dbClose(con, pstmt);
		}
		return successFlag;
	}
	public  boolean airLineDelete(AirLineVO avo){
		boolean successFlag = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
		con = DBUtility.dbCon();
		
		pstmt = con.prepareStatement(AIRLINE_DELETE);
			pstmt.setInt(1, avo.getNo());
			int result = pstmt.executeUpdate();
			successFlag = (result != 0) ? true : false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			DBUtility.dbClose(con, pstmt);
		}
		return successFlag;
	}
	public ArrayList<AirLineVO> airLinePrint(){
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<AirLineVO> list = new ArrayList<AirLineVO>();
		try {
		con = DBUtility.dbCon();
		stmt = con.createStatement();
		rs = stmt.executeQuery(AIRLINE_SELECT);
	
		while (rs.next()) {
			int no = rs.getInt("NO");
			String name;
				name = rs.getNString("NAME");
				String englishName = rs.getNString("ENGLISH_NAME");
				String country = rs.getString("country");
				String grade = rs.getString("GRADE");
				AirLineVO avo = new AirLineVO(no, name, englishName, country, grade);
				list.add(avo);
		}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				
				DBUtility.dbClose(con, stmt, rs);
			}

		return list;
	}
	//삽입
		public  boolean airLineInsert(AirLineVO avo){
			boolean successFlag = false;
			Connection con = null;
			PreparedStatement pstmt = null;
			ArrayList<AirLineVO> airLinelist = new ArrayList<AirLineVO>();
			airLinelist = null;
			try {
			con = DBUtility.dbCon();

			pstmt = con.prepareStatement(AIRLINE_INSERT);
			pstmt.setInt(1, avo.getNo());
			pstmt.setString(2, avo.getName());
				pstmt.setString(3, avo.getEnglishName());
				pstmt.setString(4, avo.getCountry());
				pstmt.setString(5, avo.getGrade());
				int result = pstmt.executeUpdate();
				successFlag = (result != 0) ? true : false;
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				
				DBUtility.dbClose(con, pstmt);
			}

			return successFlag;
		}
		//함수
		public boolean airLineFunc(AirLineVO avo){
			boolean successFlag = false;
			Connection con = null;
			CallableStatement cstmt = null;
			try {
			con = DBUtility.dbCon();
			
			cstmt = con.prepareCall(AIRLINE_GRADE_FUNC);
			cstmt.registerOutParameter(1, Types.VARCHAR);
			cstmt.setString(2, avo.getName());
			int result;
				result = cstmt.executeUpdate();
				String message = cstmt.getString(1);
				successFlag = (result != 0) ? true : false;
				System.out.println(message);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}finally {
				
				DBUtility.dbClose(con, cstmt);
			}
			return successFlag;
		}
}
