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

import com.mis.dto.OrdVO;

import com.mis.util.DBManager;

public class OrdDAO {
	private OrdDAO() {
	}

	private static OrdDAO instance = new OrdDAO();

	public static OrdDAO getInstance() {
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

	public void insertOrder(OrdVO orders) {
		String sql = "insert into orders VALUES(ORDERS_SEQ.NEXTVAL, ?, ?)";
		Connection conn = null;

		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			// ?�� �� ����
			pstmt.setInt(1, orders.getCus_no());
			pstmt.setTimestamp(2, orders.getOrd_date());
			pstmt.setInt(3, orders.getEmp_no());
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

	public List<OrdVO> selectAllOrders() {
		String sql = "select ord_no, cus_name, cus_phone, cus_email, emp_name, ord_date from orderlist_view";
		List<OrdVO> list = new ArrayList<OrdVO>();
		System.out.println(list);
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				OrdVO oVo = new OrdVO();
				oVo.setOrd_no(rs.getInt("ord_no"));
				oVo.setCus_name(rs.getString("cus_name"));
				oVo.setCus_phone(rs.getString("cus_phone"));
				oVo.setCus_email(rs.getString("cus_email"));
				oVo.setEmp_name(rs.getString("emp_name"));
				oVo.setOrd_date(rs.getTimestamp("ord_date"));
				
				list.add(oVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		System.out.println(list);
		return list;
	}

	public ArrayList<Integer> selectSeqOrderIng() {
		ArrayList<Integer> oseqList = new ArrayList<Integer>();
		String sql = "select distinct odr_no from orderlist_view where result='1' order by odr_no desc";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				oseqList.add(rs.getInt(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		return oseqList;
	}



	public OrdVO selectOneProByNo(String ord_no) {
		String sql = "select * from orders where ord_no=?";

		OrdVO oVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ord_no);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				oVo = new OrdVO();
				oVo.setOrd_no(rs.getInt("ord_no"));
				oVo.setCus_no(rs.getInt("cus_no"));
				oVo.setEmp_no(rs.getInt("emp_no"));
				oVo.setPro_no(rs.getInt("pro_no"));
				oVo.setPro_price(rs.getInt("pro_price"));
				oVo.setOrd_qtt(rs.getInt("ord_qtt"));
				oVo.setPro_qtt(rs.getInt("pro_qtt"));
				oVo.setCus_name(rs.getString("cus_name"));
				oVo.setCus_phone(rs.getString("cus_phone"));
				oVo.setCus_email(rs.getString("cus_email"));
				oVo.setEmp_name(rs.getString("emp_name"));
				
				
				
			}
		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			DBManager.close(conn, pstmt, rs);

		}

		return oVo;
	}
	
	
	/*
	 * 수정 보류 public void updatePro(ProVO pVo) { String sql =
	 * "update product set pro_name=?, pro_price=?, pro_stock=? where pro_no=?";
	 * 
	 * Connection conn = null; PreparedStatement pstmt = null;
	 * 
	 * try { conn = DBManager.getConnection();
	 * 
	 * pstmt = conn.prepareStatement(sql);
	 * 
	 * 
	 * pstmt.setString(1, pVo.getPro_name()); pstmt.setInt(2,
	 * pVo.getPro_price()); pstmt.setInt(3, pVo.getPro_stock()); pstmt.setInt(4,
	 * pVo.getPro_no());
	 * 
	 * pstmt.executeUpdate();
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } finally {
	 * DBManager.close(conn, pstmt); } }
	 */
	/*
	 * 삭제 보류 public void deletePro(String pro_no) { String sql =
	 * "delete product where pro_no = ? ";
	 * 
	 * Connection conn = null; PreparedStatement pstmt = null;
	 * 
	 * try { conn = DBManager.getConnection(); pstmt =
	 * conn.prepareStatement(sql);
	 * 
	 * pstmt.setString(1, pro_no);
	 * 
	 * pstmt.executeUpdate(); } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * }
	 */
}
