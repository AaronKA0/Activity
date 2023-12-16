package com.act.model;

import java.util.*;
import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ActDAO implements ActDAO_interface {

	// 一個應用程式中,針對一個資料庫 ,共用一個DataSource即可
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/project03");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT_ACT = "INSERT INTO activity (mem_id,act_name,act_start_time,act_end_time,act_loc,act_descr,act_upper,act_count,act_status,act_cr_time,reg_start_time,reg_end_time,act_pic,lat,lon) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_ACT = "SELECT mem_id,act_name,act_start_time,act_end_time,act_loc,act_descr,act_upper,act_upper,act_status,act_cr_time,reg_start_time,reg_end_time,act_pic,act_tot_rating,act_rate_count,act_follow_count,lat,lon FROM activity order by act_id";
	private static final String GET_ONE_ACT = "SELECT mem_id,act_name,act_start_time,act_end_time,act_loc,act_descr,act_upper,act_upper,act_status,act_cr_time,reg_start_time,reg_end_time,act_pic,act_tot_rating,act_rate_count,act_follow_count,lat,lon FROM activity where act_id = ?";
	private static final String DELETE = "DELETE FROM activity where act_id = ?";
	private static final String UPDATE = "UPDATE activity set act_name=?, act_start_time=?, act_end_time=?, act_loc=?, act_descr=?, act_cr_time=?, reg_start_time=?, reg_end_time=?, act_pic=?, lat=?, lon=? where act_id = ?";

	@Override
	public void insert(ActVO actVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_ACT);

			pstmt.setString(1, actVO.getAct_name());
			pstmt.setObject(2, actVO.getAct_start_time());
			pstmt.setObject(3, actVO.getAct_end_time());
			pstmt.setString(4, actVO.getAct_loc());
			pstmt.setString(5, actVO.getAct_descr());
			pstmt.setInt(6, actVO.getAct_upper());
			pstmt.setInt(7, actVO.getAct_count());
			pstmt.setByte(8, actVO.getAct_status());
			pstmt.setObject(9, actVO.getAct_cr_time());
			pstmt.setObject(10, actVO.getReg_start_time());
			pstmt.setObject(11, actVO.getReg_end_time());
			pstmt.setBytes(12, actVO.getAct_pic());
			pstmt.setBigDecimal(13, actVO.getLat());
			pstmt.setBigDecimal(14, actVO.getLon());

			pstmt.executeUpdate();

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void update(ActVO actVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, actVO.getAct_name());
			pstmt.setObject(2, actVO.getAct_start_time());
			pstmt.setObject(3, actVO.getAct_end_time());
			pstmt.setString(4, actVO.getAct_loc());
			pstmt.setString(5, actVO.getAct_descr());
			pstmt.setInt(6, actVO.getAct_upper());
			pstmt.setInt(7, actVO.getAct_count());
			pstmt.setByte(8, actVO.getAct_status());
			pstmt.setObject(9, actVO.getAct_cr_time());
			pstmt.setObject(10, actVO.getReg_start_time());
			pstmt.setObject(11, actVO.getReg_end_time());
			pstmt.setBytes(12, actVO.getAct_pic());
			pstmt.setBigDecimal(13, actVO.getLat());
			pstmt.setBigDecimal(14, actVO.getLon());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void delete(Integer act_id) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, act_id);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public ActVO findByPrimaryKey(Integer act_id) {

		ActVO actVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_ACT);

			pstmt.setInt(1, act_id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				actVO = new ActVO();
				actVO.setAct_id(rs.getInt("act_id"));
				actVO.setAct_name(rs.getString("act_name"));
				actVO.setAct_loc(rs.getString("act_loc"));
				
			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return actVO;
	}

	@Override
	public List<ActVO> getAll() {
		List<ActVO> list = new ArrayList<ActVO>();
		ActVO actVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_ACT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// actVO 也稱為 Domain objects
				actVO = new ActVO();
				actVO.setAct_id(rs.getInt("act_id"));
				actVO.setAct_name(rs.getString("act_name"));
				list.add(actVO); // Store the row in the list
				
			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}
}