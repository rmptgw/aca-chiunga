package com.mis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.mis.dto.EmpVO;

import com.mis.util.DBManager;

public class EmpDAO {
	private EmpDAO() {
	}

	private static EmpDAO instance = new EmpDAO();

	public static EmpDAO getInstance() {
		return instance;
	}

	Connection getConnection() {
		Connection conn = null;
		Context initContext;

		try {
			initContext = new InitialContext();
			DataSource ds = (DataSource) initContext.lookup("java:/comp/env/jdbc/myoracle");
			conn = ds.getConnection();

		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public List<EmpVO> selectAllEmployees() {
		String sql = "select * from employee order by emp_no desc";
		List<EmpVO> list = new ArrayList<EmpVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				EmpVO pVo = new EmpVO();
				pVo.setEmp_no(rs.getInt("emp_no"));
				pVo.setEmp_name(rs.getString("emp_name"));
				pVo.setEmp_id(rs.getString("emp_id"));
				pVo.setEmp_dept(rs.getString("emp_dept"));
				pVo.setEmp_email(rs.getString("emp_email"));
				list.add(pVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}

	public int userCheck(String emp_id, String emp_pass) {
		int result = 1;
		Connection conn = null;
		String sql = "SELECT * FROM Employee WHERE emp_id =?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp_id);

			rs = pstmt.executeQuery();

			if(rs.next()){
				//아이디가 DB에 있을때
				if(emp_pass.equals(rs.getString("emp_pass"))){
					//비번이 맞을때
						result = 1; 
				}else{  //비밀번호가 다를때
					result = 0;
				}
			}else{  //가입이 안되어 있을때
				result = -1;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public EmpVO geteVo(String emp_id) {
		EmpVO eVo = null;

		Connection conn = null;
		String sql = "select * from Employee where emp_id=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp_id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				eVo = new EmpVO();
				eVo.setEmp_id(rs.getString("emp_id"));
				eVo.setEmp_pass(rs.getString("emp_pass"));
				eVo.setEmp_name(rs.getString("emp_name"));
				eVo.setEmp_dept(rs.getString("emp_dept"));
				eVo.setEmp_email(rs.getString("emp_email"));
				eVo.setEmp_phone(rs.getString("emp_phone"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return eVo;
	}

	public void insertEmp(EmpVO eVo) {
		String sql = "insert into employee VALUES(EMPLOYEE_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?)";
		Connection conn = null;

		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			// ?�� �� ����

			pstmt.setString(1, eVo.getEmp_name());
			pstmt.setString(2, eVo.getEmp_id());
			pstmt.setString(3, eVo.getEmp_pass());
			pstmt.setString(4, eVo.getEmp_dept());
			pstmt.setString(5, eVo.getEmp_email());
			pstmt.setString(6, eVo.getEmp_phone());
			System.out.println(pstmt.executeUpdate());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public int updateEmp(EmpVO eVo) {
		int result = -1;
		String sql = "Update employee set EMP_NAME=?, EMP_PASS=?, EMP_DEPT=?, EMP_PHONE=?, EMP_EMAIL=? delete employee where EMP_NO=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, eVo.getEmp_name());
			pstmt.setString(2, eVo.getEmp_id());
			pstmt.setString(3, eVo.getEmp_pass());
			pstmt.setString(4, eVo.getEmp_dept());
			pstmt.setString(5, eVo.getEmp_email());
			pstmt.setString(6, eVo.getEmp_phone());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public void deleteEmp(int no) {
		String sql = "delete employee where emp_no = ? ";
		
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
	
	public EmpVO selectOneEmpByNo(int emp_no) {
		String sql = "select * from employee where emp_no=?";

		EmpVO eVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, emp_no);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				
				eVo = new EmpVO();

				eVo.setEmp_no(rs.getInt("emp_no"));
				eVo.setEmp_id(rs.getString("emp_id"));
				eVo.setEmp_pass(rs.getString("emp_pass"));
				eVo.setEmp_name(rs.getString("emp_name"));
				eVo.setEmp_dept(rs.getString("emp_dept"));
				eVo.setEmp_phone(rs.getString("emp_phone"));
				eVo.setEmp_email(rs.getString("emp_email"));

			}
		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			DBManager.close(conn, pstmt, rs);

		}

		return eVo;
	}
	public int confirmID(String emp_id) {
		int result = -1;
		String sql = "select emp_id from employee where emp_id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
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
}
