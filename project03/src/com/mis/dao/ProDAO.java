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

import com.mis.dto.ProVO;

import com.mis.util.DBManager;

public class ProDAO {
	private ProDAO() {
	}
	
	private static ProDAO instance = new ProDAO();
	
	public static ProDAO getInstance() {
		return instance;
	}

	Connection getConnection(){
		Connection conn = null;
		Context initContext;
		
		try{
			initContext = new InitialContext();
			DataSource ds = (DataSource)initContext.lookup("java:/comp/env/jdbc/myoracle");
			conn = ds.getConnection();
			
		}catch(NamingException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return conn;
	}
	
	
	
	public void insertProduct(ProVO products) {
		String sql = "insert into PRODUCT VALUES(PRODUCT_SEQ.NEXTVAL, ?, ?, ?)";		
		Connection conn = null;

		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			// ?�� �� ����
			pstmt.setString(1, products.getPro_name());
			pstmt.setInt(2, products.getPro_price());
			pstmt.setInt(3, products.getPro_stock());
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

	
	public List<ProVO> selectAllProducts() {
		String sql = "select * from product order by pro_no desc";
		List<ProVO> list = new ArrayList<ProVO>();
		System.out.println(list);
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				ProVO pVo = new ProVO();
				System.out.println(list);
				pVo.setPro_no(rs.getInt("pro_no"));
				pVo.setPro_name(rs.getString("pro_name"));
				pVo.setPro_price(rs.getInt("pro_price"));
				pVo.setPro_stock(rs.getInt("pro_stock"));
				list.add(pVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		System.out.println(list);
		return list;
	}
	
	public ProVO selectOneProByNo(String pro_no) {
		String sql = "select * from product where pro_no=?";

		ProVO pVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pro_no);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				
				pVo = new ProVO();

				pVo.setPro_no(rs.getInt("pro_no"));
				pVo.setPro_name(rs.getString("pro_name"));
				pVo.setPro_price(rs.getInt("pro_price"));
				pVo.setPro_stock(rs.getInt("pro_stock"));

			}
		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			DBManager.close(conn, pstmt, rs);

		}

		return pVo;
	}
	public void updatePro(ProVO pVo) {
		String sql = "update product set pro_name=?, pro_price=?, pro_stock=? where pro_no=?";
				
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			
			pstmt = conn.prepareStatement(sql);

			
			pstmt.setString(1, pVo.getPro_name());
			pstmt.setInt(2, pVo.getPro_price());
			pstmt.setInt(3, pVo.getPro_stock());
			pstmt.setInt(4, pVo.getPro_no());
			
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	public void deletePro(String pro_no) {
		String sql = "delete product where pro_no = ? ";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, pro_no);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
