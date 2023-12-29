package com.membership.dao;

import java.sql.*;
import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.membership.model.MembershipVO;

public class MembershipDAO implements IMembershipDAO {

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

	private static final String INSERT_STMT = "INSERT INTO membership (mem_acc, mem_email, mem_pwd, mem_name, mem_gender, mem_birthdate, mem_username, mem_pic, is_acc_ena, is_part_ena, is_host_ena, is_rent_ena, is_msg_ena) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String GET_ALL_STMT = "SELECT * FROM membership";
	private static final String GET_ONE_STMT = "SELECT mem_id, mem_acc, mem_email, mem_pwd, mem_name, mem_gender, mem_birthdate, mem_username, mem_pic, is_acc_ena, is_part_ena, is_host_ena, is_rent_ena, is_msg_ena FROM membership WHERE mem_id = ?";
	private static final String DELETE = "DELETE FROM membership WHERE mem_id = ?";
	private static final String UPDATE = "UPDATE membership SET mem_acc = ?, mem_email = ?, mem_pwd = ?, mem_name = ?, mem_gender = ?, mem_birthdate = ?, mem_username = ?, mem_pic = ?,  is_acc_ena = ?, is_part_ena = ?, is_host_ena = ?, is_rent_ena = ?, is_msg_ena = ? WHERE mem_Id = ?";

	@Override
	public void insert(MembershipVO membershipVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, membershipVO.getMemAcc());
			pstmt.setString(2, membershipVO.getMemEmail());
			pstmt.setString(3, membershipVO.getMemPwd());
			pstmt.setString(4, membershipVO.getMemName());
			pstmt.setByte(5, membershipVO.getMemGender());
			pstmt.setDate(6, membershipVO.getMemBirthdate());
			pstmt.setString(7, membershipVO.getMemUsername());
			pstmt.setBytes(8, membershipVO.getMemPic());
			pstmt.setByte(9, membershipVO.getIsAccEna());
			pstmt.setByte(10, membershipVO.getIsPartEna());
			pstmt.setByte(11, membershipVO.getIsHostEna());
			pstmt.setByte(12, membershipVO.getIsRentEna());
			pstmt.setByte(13, membershipVO.getIsMsgEna());

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
	public void update(MembershipVO membershipVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, membershipVO.getMemAcc());
			pstmt.setString(2, membershipVO.getMemEmail());
			pstmt.setString(3, membershipVO.getMemPwd());
			pstmt.setString(4, membershipVO.getMemName());
			pstmt.setByte(5, membershipVO.getMemGender());
			pstmt.setDate(6, membershipVO.getMemBirthdate());
			pstmt.setString(7, membershipVO.getMemUsername());
			pstmt.setBytes(8, membershipVO.getMemPic());
			pstmt.setByte(9, membershipVO.getIsAccEna());
			pstmt.setByte(10, membershipVO.getIsPartEna());
			pstmt.setByte(11, membershipVO.getIsHostEna());
			pstmt.setByte(12, membershipVO.getIsRentEna());
			pstmt.setByte(13, membershipVO.getIsMsgEna());
			pstmt.setInt(14, membershipVO.getMemId());

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
	public void delete(Integer memId) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, memId);

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
	public MembershipVO findByPrimaryKey(Integer memId) {

		MembershipVO membershipVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, memId);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				membershipVO = new MembershipVO();
				membershipVO.setMemId(rs.getInt("mem_Id"));
				membershipVO.setMemAcc(rs.getString("mem_Acc"));
				membershipVO.setMemEmail(rs.getNString("mem_Email"));
				membershipVO.setMemPwd(rs.getString("mem_Pwd"));
				membershipVO.setMemName(rs.getNString("mem_Name"));
				membershipVO.setMemGender(rs.getByte("mem_Gender"));
				membershipVO.setMemBirthdate(rs.getDate("mem_Birthdate"));
				membershipVO.setMemUsername(rs.getString("mem_Username"));
				membershipVO.setMemPic(rs.getBytes("mem_Pic"));
				membershipVO.setIsAccEna(rs.getByte("is_Acc_Ena"));
				membershipVO.setIsPartEna(rs.getByte("is_Part_Ena"));
				membershipVO.setIsHostEna(rs.getByte("is_Host_Ena"));
				membershipVO.setIsRentEna(rs.getByte("is_Rent_Ena"));
				membershipVO.setIsMsgEna(rs.getByte("is_Msg_Ena"));
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
		return membershipVO;
	}

	@Override
	public List<MembershipVO> getAll() {
		List<MembershipVO> list = new ArrayList<MembershipVO>();
		MembershipVO membershipVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				membershipVO = new MembershipVO();
				membershipVO.setMemId(rs.getInt("mem_Id"));
				membershipVO.setMemAcc(rs.getString("mem_Acc"));
				membershipVO.setMemEmail(rs.getNString("mem_Email"));
				membershipVO.setMemPwd(rs.getString("mem_Pwd"));
				membershipVO.setMemName(rs.getNString("mem_Name"));
				membershipVO.setMemGender(rs.getByte("mem_Gender"));
				membershipVO.setMemBirthdate(rs.getDate("mem_Birthdate"));
				membershipVO.setMemUsername(rs.getString("mem_Username"));
				membershipVO.setMemPic(rs.getBytes("mem_Pic"));
				membershipVO.setIsAccEna(rs.getByte("is_Acc_Ena"));
				membershipVO.setIsPartEna(rs.getByte("is_Part_Ena"));
				membershipVO.setIsHostEna(rs.getByte("is_Host_Ena"));
				membershipVO.setIsRentEna(rs.getByte("is_Rent_Ena"));
				membershipVO.setIsMsgEna(rs.getByte("is_Msg_Ena"));
				list.add(membershipVO); // Store the row in the list
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