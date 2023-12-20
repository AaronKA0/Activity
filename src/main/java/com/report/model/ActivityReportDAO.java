package com.report.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ActivityReportDAO implements ActivityReportDAO_interface {

	// String driver = "com.mysql.cj.jdbc.Driver";
//	String url = "jdbc:mysql://localhost:3306/project03?serverTimezone=Asia/Taipei";
//	String userid = "root";
//	String passwd = "s840104";

	// �@�����ε{����,�w��@�Ӹ�Ʈw ,�@�Τ@��DataSource�Y�i
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB3");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT_STMT = "INSERT INTO activity_report "
			+ "(act_id, mem_id, emp_id, rep_title, rep_content, rep_time) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT rep_id, act_id, mem_id, emp_id, rep_title, "
			+ "rep_content, rep_pic, rep_status, rep_time FROM activity_report order by rep_id";
	private static final String GET_ONE_STMT = "SELECT rep_id, act_id, mem_id, emp_id, rep_title,"
			+ "rep_content, rep_pic, rep_status, rep_time FROM activity_report WHERE rep_id = ?";
	private static final String DELETE = "DELETE FROM activity_report WHERE rep_id = ?";
	private static final String UPDATE = "UPDATE activity_report set rep_status=? WHERE rep_id = ?";

	@Override
	public void insert(ActivityReportVO activityReportVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, activityReportVO.getActId());
			pstmt.setInt(2, activityReportVO.getMemId());
			pstmt.setInt(3, activityReportVO.getEmpId());
			pstmt.setString(4, activityReportVO.getRepTitle());
			pstmt.setString(5, activityReportVO.getRepContent());
			pstmt.setTimestamp(6, activityReportVO.getRepTime());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void update(ActivityReportVO activityReportVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, activityReportVO.getRepStatus());
			pstmt.setInt(2, activityReportVO.getRepId());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public void delete(Integer repId) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, repId);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public ActivityReportVO findByPrimaryKey(Integer repId) {

		ActivityReportVO activityReportVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, repId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				activityReportVO = new ActivityReportVO();
				activityReportVO.setRepId(rs.getInt("rep_id"));
				activityReportVO.setActId(rs.getInt("act_id"));
				activityReportVO.setMemId(rs.getInt("mem_id"));
				activityReportVO.setEmpId(rs.getInt("emp_id"));
				activityReportVO.setRepTitle(rs.getString("rep_title"));
				activityReportVO.setRepContent(rs.getString("rep_content"));
				activityReportVO.setRepPic(rs.getBytes("rep_pic"));
				activityReportVO.setRepStatus(rs.getInt("rep_status"));
				activityReportVO.setRepTime(rs.getTimestamp("rep_time"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return activityReportVO;
	}

	@Override
	public List<ActivityReportVO> getAll() {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<ActivityReportVO> list = new ArrayList<ActivityReportVO>();

		try {
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ActivityReportVO activityReportVO = new ActivityReportVO();
				activityReportVO.setRepId(rs.getInt("rep_id"));
				activityReportVO.setActId(rs.getInt("act_id"));
				activityReportVO.setMemId(rs.getInt("mem_id"));
				activityReportVO.setEmpId(rs.getInt("emp_id"));
				activityReportVO.setRepTitle(rs.getString("rep_title"));
				activityReportVO.setRepContent(rs.getString("rep_content"));
				activityReportVO.setRepPic(rs.getBytes("rep_pic"));
				activityReportVO.setRepStatus(rs.getInt("rep_status"));
				activityReportVO.setRepTime(rs.getTimestamp("rep_time"));
				list.add(activityReportVO);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

//	public static void main(String[] args) {

//		ActivityReportDAO_interface activityReportDAO = new ActivityReportDAO();

	// �s�W
//		ActivityReportVO activityReportVO = new ActivityReportVO();
//		activityReportVO.setActId(1);
//		activityReportVO.setMemId(2);
//		activityReportVO.setEmpId(3);
//		activityReportVO.setRepTitle("�w�w");
//		activityReportVO.setRepContent("�w�w�A�n");
//		activityReportVO.setRepTime(Timestamp.valueOf(LocalDateTime.now()));
//		activityReportDAO.insert(activityReportVO);

	// �d����
//		 List<ActivityReportVO> list = activityReportDAO.getAll();

//		for (ActivityReportVO activityReport : list) {
//			System.out.println(activityReport.getActId());
//			System.out.println(activityReport.getMemId());
//			System.out.println(activityReport.getRepTitle());
//			System.out.println(activityReport.getRepContent());
//			System.out.println(activityReport.getRepPic());
//			System.out.println(activityReport.getRepStatus());
//			System.out.println(activityReport.getRepTime().toLocalDateTime()
//					.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
//		}

	// �d��@
//		ActivityReportVO activityReportVO = activityReportDAO.findByPrimaryKey(1);

//		System.out.println(activityReportVO.getRepId());
//		System.out.println(activityReportVO.getActId());
//		System.out.println(activityReportVO.getMemId());
//		System.out.println(activityReportVO.getEmpId());
//		System.out.println(activityReportVO.getRepTitle());
//		System.out.println(activityReportVO.getRepContent());
//		System.out.println(activityReportVO.getRepPic());
//		System.out.println(activityReportVO.getRepStatus());
//		System.out.println(activityReportVO.getRepTime());

	// �R��
//		activityReportDAO.delete(1);

	// �ק�
//		ActivityReportVO activityReportVO = new ActivityReportVO();
//		activityReportVO.setRepStatus(2);
//		activityReportVO.setRepID(2);

//		activityReportDAO.update(activityReportVO);
//	}

}
