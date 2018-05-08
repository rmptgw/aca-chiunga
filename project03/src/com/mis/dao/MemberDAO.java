package com.mis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mis.dto.MemberVO;
import com.mis.util.DBManager;

public class MemberDAO {
	private MemberDAO() {
	}

	private static MemberDAO instance = new MemberDAO();

	public static MemberDAO getInstance() {
		return instance;
	}

	// 사용자 인증시 사용하는 메소드
	public int userCheck(String emp_id, String emp_pass) {
		int result = -1;
		String sql = "select emp_pass from employee where emp_id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp_id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getString("emp_pass") != null
						&& rs.getString("emp_pass").equals(emp_pass)) {
					result = 2;
				} else {
					result = 0;
				}
			} else {
				result = -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	// 아이디로 회원 정보 가져오는 메소드
	public MemberVO getMember(String emp_id) {
		MemberVO mVo = null;
		String sql = "select * from employee where emp_id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp_id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				mVo = new MemberVO();
				mVo.setEmp_name(rs.getString("emp_name"));
				mVo.setEmp_id(rs.getString("emp_id"));
				mVo.setEmp_pass(rs.getString("emp_pass"));
				mVo.setEmp_dept(rs.getString("emp_dept"));
				mVo.setEmp_phone(rs.getString("emp_phone"));
				mVo.setEmp_email(rs.getString("emp_email"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return mVo;
	}

	public int confirmID(String emp_id) {
		int result = -1;
		String sql = "select emp_id from employee where emp_id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp_id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = 1;
			} else {
				result = -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public int insertMember(MemberVO mVo) {
		int result = -1;
		String sql = "insert into employee values(EMPLOYEE_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mVo.getEmp_name());
			pstmt.setString(2, mVo.getEmp_id());
			pstmt.setString(3, mVo.getEmp_pass());
			pstmt.setString(4, mVo.getEmp_dept());
			pstmt.setString(5, mVo.getEmp_phone());
			pstmt.setString(6, mVo.getEmp_email());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public int updateMember(MemberVO mVo) {
		int result = -1;
		String sql = "update employee set emp_pass=?, emp_email=?,"
				+ "emp_phone=?, emp_dept=? where emp_id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mVo.getEmp_pass());
			pstmt.setString(2, mVo.getEmp_email());
			pstmt.setString(3, mVo.getEmp_phone());
			pstmt.setString(4, mVo.getEmp_dept());
			pstmt.setString(5, mVo.getEmp_id());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	public void deleteMember(int no) {
		String sql = "delete employee where no = ? ";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
