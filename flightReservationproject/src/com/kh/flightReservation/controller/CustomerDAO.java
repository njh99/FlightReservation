package com.kh.flightReservation.controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import com.kh.flightReservation.model.CustomerVO;

public class CustomerDAO {
	public final String CUSTOMER_SELECT = "SELECT * FROM CUSTOMER";
	public final String CUSTOMER_INSERT = "INSERT INTO CUSTOMER(ID,PASSWD,NAME,PASSPORT_NUMBER) VALUES(?,?,?,?)";
	public final String CUSTOMER_UPDATE = "UPDATE CUSTOMER SET PASSWD = ?, NAME = ?, PASSPORT_NUMBER = ? WHERE ID = ?";
	public final String CUSTOMER_DELETE = "DELETE FROM CUSTOMER WHERE ID = ?";
	public final String CUSTOMER_GRADE_PRINT = "{? = call CUSTOMER_GRADE_FUNC(?)}";
	
	public ArrayList<CustomerVO> customerSelect() {
		Connection con = DBUtility.dbCon();
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<CustomerVO> customerList = new ArrayList<CustomerVO>();
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(CUSTOMER_SELECT);
			while(rs.next()) {
				String id = rs.getString("ID");
				String passwd = rs.getString("PASSWD");
				String name = rs.getString("NAME");
				String passportNumber = rs.getString("PASSPORT_NUMBER");
				int mileage = rs.getInt("MILEAGE");
				CustomerVO customerVO = new CustomerVO(id, passwd, name, passportNumber, mileage);
				customerList.add(customerVO);
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		}finally {
			DBUtility.dbClose(con, stmt, rs);
		}
		return customerList;
	}

	public boolean customerInsert(CustomerVO cvo) {
		Connection con = DBUtility.dbCon();
		PreparedStatement pstmt = null;
		ArrayList<CustomerVO> customerList = new ArrayList<CustomerVO>();
		boolean successFlag = false;
		
		try {
			pstmt = con.prepareStatement(CUSTOMER_INSERT);
			pstmt.setString(1, cvo.getId());
			pstmt.setString(2, cvo.getPasswd());
			pstmt.setString(3, cvo.getName());
			pstmt.setString(4, cvo.getPassportNumber());
			int result = pstmt.executeUpdate();
			if(result != 0) {
				successFlag = true;
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		}finally {
			DBUtility.dbClose(con, pstmt);
		}
		return successFlag;
		
	}

	public boolean customerUpdate(CustomerVO cvo) {
		Connection con = DBUtility.dbCon();
		PreparedStatement pstmt = null;
		boolean successFlag = false;
		
		try {
			pstmt = con.prepareStatement(CUSTOMER_UPDATE);
			pstmt.setString(1, cvo.getPasswd());
			pstmt.setString(2, cvo.getName());
			pstmt.setString(3, cvo.getPassportNumber());
			pstmt.setString(4, cvo.getId());
			int result = pstmt.executeUpdate();
			if(result != 0) {
				successFlag = true;
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		}finally {
			DBUtility.dbClose(con, pstmt);
		}
		return successFlag;
	}

	public boolean customerDelete(CustomerVO cvo) {
		Connection con = DBUtility.dbCon();
		PreparedStatement pstmt = null;
		boolean successFlag = false;
		
		try {
			pstmt = con.prepareStatement(CUSTOMER_DELETE);
			pstmt.setString(1, cvo.getId());
			int result = pstmt.executeUpdate();
			if(result != 0) {
				successFlag = true;
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		}finally {
			DBUtility.dbClose(con, pstmt);
		}
		return successFlag;
	}

	public boolean customerGradePrint(CustomerVO cvo) {
		Connection con = DBUtility.dbCon();
		CallableStatement cstmt = null;
		boolean successFlag = false;
		
		try {
			cstmt = con.prepareCall(CUSTOMER_GRADE_PRINT);
			cstmt.registerOutParameter(1, Types.VARCHAR);
			cstmt.setString(2, cvo.getId());
			cstmt.executeUpdate();
			
			String result = cstmt.getString(1);
			
			if(result != null) {
				successFlag = true;
			}
			System.out.println(result);
		} catch (SQLException e) {
			System.out.println(e.toString());
		}finally {
			DBUtility.dbClose(con, cstmt);
		}
		return successFlag; 
		
	}
	
}
