package com.mis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mis.dto.CusVO;

import com.mis.util.DBManager;

public class CusDAO {
	private CusDAO() {

	}

	private static CusDAO instance = new CusDAO();

	public static CusDAO getInstance() {
		return instance;
	}

	// 고객정보 불러오는 메소드
	public List<CusVO> selectAllCus() {
		String sql = "select * from customer order by cus_no desc";

		List<CusVO> list = new ArrayList<CusVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				CusVO cVo = new CusVO();

				cVo.setCno(rs.getInt("cus_no"));
				cVo.setCname(rs.getString("cus_name"));
				cVo.setCpost(rs.getString("cus_post"));
				cVo.setCaddr(rs.getString("cus_adr"));
				cVo.setCphone(rs.getString("cus_phone"));
				cVo.setCemail(rs.getString("cus_email"));
				
				list.add(cVo);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}

		return list;
	}

	// 고객정보를 DB에 추가하는 메소드
	public void insertCus(CusVO cVo) {

		String sql = "insert into customer(cus_no, cus_name, cus_post, cus_adr, cus_phone, cus_email)"
				+ " values(customer_seq.nextval, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, cVo.getCname());
			pstmt.setString(2, cVo.getCpost());
			pstmt.setString(3, cVo.getCaddr());
			pstmt.setString(4, cVo.getCphone());
			pstmt.setString(5, cVo.getCemail());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}


	// 게시판 글 상세내용보기 : 글 번호로 찾아아온다. : 실패 null
	public CusVO selectOneCusByNo(String cno) {
		String sql = "select * from customer where cus_no=?";

		CusVO cVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cno);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				
				cVo = new CusVO();

				cVo.setCno(rs.getInt("cus_no"));
				cVo.setCname(rs.getString("cus_name"));
				cVo.setCpost(rs.getString("cus_post"));
				cVo.setCaddr(rs.getString("cus_adr"));
				cVo.setCphone(rs.getString("cus_phone"));
				cVo.setCemail(rs.getString("cus_email"));

			}
		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			DBManager.close(conn, pstmt, rs);

		}

		return cVo;
	}

	// DB에 있는 해당 고객정보 수정하는 메소드
	public void updateCus(CusVO cVo) {
		String sql = "update customer set cus_name=?, cus_post=?, cus_adr=?, cus_phone=?, cus_email=? where cus_no=?";
				
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, cVo.getCname());
			pstmt.setString(2, cVo.getCpost());
			pstmt.setString(3, cVo.getCaddr());
			pstmt.setString(4, cVo.getCphone());
			pstmt.setString(5, cVo.getCemail());
			pstmt.setInt(6, cVo.getCno());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	// DB에 있는 해당 고객정보를 삭제하는 메소드
	public void deleteCus(String cno) {
		String sql = "delete customer where cus_no = ? ";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, cno);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
