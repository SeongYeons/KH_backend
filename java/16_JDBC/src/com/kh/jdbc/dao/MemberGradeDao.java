package com.kh.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kh.jdbc.vo.MemberGrade;

public class MemberGradeDao {

	public List<MemberGrade> findAll() {
		List<MemberGrade> grades = new ArrayList<>();
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			connection = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "C##KH", "KH");
			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT * FROM MEMBER_GRADE");
			
			while(rs.next()) {
				MemberGrade grade = new MemberGrade();
				
				grade.setGradeCode(rs.getInt("GRADE_CODE"));
				grade.setGradeName(rs.getString("GRADE_NAME"));
				grade.setCreateDate(rs.getDate("CREATE_DATE"));				
				
				grades.add(grade);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return grades;
	}

	public MemberGrade findByCode(int code) {
		MemberGrade grade = null;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT * FROM MEMBER_GRADE WHERE GRADE_CODE = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			connection = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "C##KH", "KH");
			pstmt = connection.prepareStatement(query);
			
			pstmt.setInt(1, code);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				grade = new MemberGrade();
				
				grade.setGradeCode(rs.getInt(1));
				grade.setGradeName(rs.getString(2));
				grade.setCreateDate(rs.getDate(3));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		
		return grade;
	}

	public int insert(String gradeName) {
		int result = 0;
		Connection connection = null;
		PreparedStatement pstmt = null;
		String query = "INSERT INTO MEMBER_GRADE "
				     + "VALUES(SEQ_GCODE.NEXTVAL, ?, DEFAULT)";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			connection = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "C##KH", "KH");
			pstmt = connection.prepareStatement(query);
			
			pstmt.setString(1, gradeName);
			
			result = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	public int update(int gradeCode, String gradeName, String createDate) {
		int result = 0;
		Connection connection = null;
		PreparedStatement pstmt = null;
		String query = "UPDATE MEMBER_GRADE "
				     + "SET GRADE_NAME = ?, "
				     + "    CREATE_DATE = ? "
				     + "WHERE GRADE_CODE = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			connection = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "C##KH", "KH");
			pstmt = connection.prepareStatement(query);
			
			pstmt.setString(1, gradeName);
			pstmt.setString(2, createDate);
			pstmt.setInt(3, gradeCode);
			
			result = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		
		return result;
	}

	public int delete(int gradeCode) {
		int result = 0;
		Connection connection = null;
		PreparedStatement pstmt = null;
		String query = "DELETE FROM MEMBER_GRADE WHERE GRADE_CODE = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			connection = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "C##KH", "KH");
			pstmt = connection.prepareStatement(query);
			
			pstmt.setInt(1, gradeCode);
			
			result = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
				
		return result;
	}
}
