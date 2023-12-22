//package com.venue.model;
//
//import java.util.*;
//import java.math.BigDecimal;
//import java.sql.*;
//import java.time.LocalDateTime;
//
//public class VenueJDBCDAO implements VenueDAO_interface {
//	String driver = util.Util.DRIVER;
//	String url = util.Util.URL;
//	String userid = util.Util.USERID;
//	String passwd = util.Util.PASSWD;
//
//	private static final String INSERT_STMT = 
//		"INSERT INTO venue (ven_name, ven_type_id, ven_descr, ven_loc, ven_price, ven_status, ven_mod_time, ven_tot_rating, ven_rate_count) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
//	private static final String GET_ALL_STMT = 
//		"SELECT ven_name, v.ven_type_id,ven_loc,ven_price,ven_status,ven_tot_rating,ven_rate_count FROM venue v JOIN venue_type vt order by ven_name";
//	private static final String GET_ONE_STMT = 
//			"SELECT ven_name, v.ven_type_id,ven_loc,ven_price,ven_status,ven_tot_rating,ven_rate_count FROM venue v JOIN venue_type vt WHERE ven_id = ?";
//	private static final String DELETE = 
//		"DELETE FROM venue where ven_id = ?";
//	private static final String UPDATE = 
//		"UPDATE venue set ven_name=? where ven_id = ?";
//
//	@Override
//	public void insert(VenueVO venueTypeVO) {
//
//		Connection con = null;
//		PreparedStatement pstmt = null;
//
//		try {
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
//			pstmt = con.prepareStatement(INSERT_STMT);
//
//			pstmt.setString(1, venueTypeVO.getVenName());
//			pstmt.setInt(2, venueTypeVO.getVenTypeId());
//			pstmt.setString(3, venueTypeVO.getVenDescr());
//			pstmt.setString(4, venueTypeVO.getVenLoc());
//			pstmt.setBigDecimal(5, venueTypeVO.getVenPrice());
//			pstmt.setByte(6, venueTypeVO.getVenStatus());
//			pstmt.setObject(7, venueTypeVO.getVenModTime());
//			pstmt.setDouble(8, venueTypeVO.getVenTotRating());
//			pstmt.setInt(9, venueTypeVO.getVenRateCount());
//			
//			pstmt.executeUpdate();
//
//			// Handle any driver errors
//		} catch (ClassNotFoundException e) {
//			throw new RuntimeException("Couldn't load database driver. "
//					+ e.getMessage());
//			// Handle any SQL errors
//		} catch (SQLException se) {
//			throw new RuntimeException("A database error occured. "
//					+ se.getMessage());
//			// Clean up JDBC resources
//		} finally {
//			if (pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException se) {
//					se.printStackTrace(System.err);
//				}
//			}
//			if (con != null) {
//				try {
//					con.close();
//				} catch (Exception e) {
//					e.printStackTrace(System.err);
//				}
//			}
//		}
//	}
//
//	@Override
//	public void update(VenueVO venueVO) {
//
//		Connection con = null;
//		PreparedStatement pstmt = null;
//
//		try {
//
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
//			pstmt = con.prepareStatement(UPDATE);
//
//			pstmt.setString(1, venueVO.getVenName());
//			pstmt.setInt(2, venueVO.getVenId());
//
//			pstmt.executeUpdate();
//
//			// Handle any driver errors
//		} catch (ClassNotFoundException e) {
//			throw new RuntimeException("Couldn't load database driver. "
//					+ e.getMessage());
//			// Handle any SQL errors
//		} catch (SQLException se) {
//			throw new RuntimeException("A database error occured. "
//					+ se.getMessage());
//			// Clean up JDBC resources
//		} finally {
//			if (pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException se) {
//					se.printStackTrace(System.err);
//				}
//			}
//			if (con != null) {
//				try {
//					con.close();
//				} catch (Exception e) {
//					e.printStackTrace(System.err);
//				}
//			}
//		}
//
//	}
//
//	@Override
//	public void delete(Integer venueId) {
//
//		Connection con = null;
//		PreparedStatement pstmt = null;
//
//		try {
//
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
//			pstmt = con.prepareStatement(DELETE);
//
//			pstmt.setInt(1, venueId);
//
//			pstmt.executeUpdate();
//
//			// Handle any driver errors
//		} catch (ClassNotFoundException e) {
//			throw new RuntimeException("Couldn't load database driver. "
//					+ e.getMessage());
//			// Handle any SQL errors
//		} catch (SQLException se) {
//			throw new RuntimeException("A database error occured. "
//					+ se.getMessage());
//			// Clean up JDBC resources
//		} finally {
//			if (pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException se) {
//					se.printStackTrace(System.err);
//				}
//			}
//			if (con != null) {
//				try {
//					con.close();
//				} catch (Exception e) {
//					e.printStackTrace(System.err);
//				}
//			}
//		}
//
//	}
//
//	@Override
//	public VenueVO findByPrimaryKey(Integer venueId) {
//
//		VenueVO venueVO = null;
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		try {
//
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
//			pstmt = con.prepareStatement(GET_ONE_STMT);
//
//			pstmt.setInt(1, venueId);
//
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				// empVo �]�٬� Domain objects
//				venueVO = new VenueVO();
//				venueVO.setVenTypeId(rs.getInt("ven_type_id"));
//				venueVO.setVenName(rs.getString("ven_name"));
//				venueVO.setVenLoc(rs.getString("ven_loc"));
//				venueVO.setVenPrice(rs.getBigDecimal("ven_price"));
//				venueVO.setVenStatus(rs.getByte("ven_status"));
//				venueVO.setVenTotRating(rs.getDouble("ven_tot_rating"));
//				venueVO.setVenRateCount(rs.getInt("ven_rate_count"));				
//			}
//
//			// Handle any driver errors
//		} catch (ClassNotFoundException e) {
//			throw new RuntimeException("Couldn't load database driver. "
//					+ e.getMessage());
//			// Handle any SQL errors
//		} catch (SQLException se) {
//			throw new RuntimeException("A database error occured. "
//					+ se.getMessage());
//			// Clean up JDBC resources
//		} finally {
//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException se) {
//					se.printStackTrace(System.err);
//				}
//			}
//			if (pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException se) {
//					se.printStackTrace(System.err);
//				}
//			}
//			if (con != null) {
//				try {
//					con.close();
//				} catch (Exception e) {
//					e.printStackTrace(System.err);
//				}
//			}
//		}
//		return venueVO;
//	}
//
//	@Override
//	public List<VenueVO> getAll() {
//		List<VenueVO> list = new ArrayList<VenueVO>();
//		VenueVO venueVO = null;
//
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		try {
//
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
//			pstmt = con.prepareStatement(GET_ALL_STMT);
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				// empVO �]�٬� Domain objects
//				venueVO = new VenueVO();
//				venueVO.setVenTypeId(rs.getInt("ven_type_id"));
//				venueVO.setVenName(rs.getString("ven_name"));
//				venueVO.setVenLoc(rs.getString("ven_loc"));
//				venueVO.setVenPrice(rs.getBigDecimal("ven_price"));
//				venueVO.setVenStatus(rs.getByte("ven_status"));
//				venueVO.setVenTotRating(rs.getDouble("ven_tot_rating"));
//				venueVO.setVenRateCount(rs.getInt("ven_rate_count"));	
//				list.add(venueVO); // Store the row in the list
//			}
//
//			// Handle any driver errors
//		} catch (ClassNotFoundException e) {
//			throw new RuntimeException("Couldn't load database driver. "
//					+ e.getMessage());
//			// Handle any SQL errors
//		} catch (SQLException se) {
//			throw new RuntimeException("A database error occured. "
//					+ se.getMessage());
//			// Clean up JDBC resources
//		} finally {
//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException se) {
//					se.printStackTrace(System.err);
//				}
//			}
//			if (pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException se) {
//					se.printStackTrace(System.err);
//				}
//			}
//			if (con != null) {
//				try {
//					con.close();
//				} catch (Exception e) {
//					e.printStackTrace(System.err);
//				}
//			}
//		}
//		return list;
//	}
//
//	public static void main(String[] args) {
//
//		VenueJDBCDAO dao = new VenueJDBCDAO();
//
//		// insert
//		VenueVO venueVO1 = new VenueVO();
//		venueVO1.setVenTypeId(1);
//		venueVO1.setVenName("venue 3");
//		venueVO1.setVenDescr("ven_descr");
//		venueVO1.setVenLoc("loc 1");
//		venueVO1.setVenPrice(new BigDecimal(1000));
//		venueVO1.setVenStatus((byte)2);
//		venueVO1.setVenTotRating(4.5);
//		venueVO1.setVenRateCount(100);
////		venueVO1.setVenModTime(LocalDateTime.now());
//		dao.insert(venueVO1);
//
//		// update
//		VenueVO venueVO2 = new VenueVO();
//		venueVO2.setVenId(1);
//		venueVO2.setVenName("venue 300");
//		dao.update(venueVO2);
//
//		// get one
//		VenueVO venueVO3 = dao.findByPrimaryKey(2);
//		System.out.print(venueVO3.getVenId() + ",");
//		System.out.print(venueVO3.getVenName() + ",");
//		System.out.println("---------------------");
//
//		// get all
//		List<VenueVO> list = dao.getAll();
//		for (VenueVO venue : list) {
//			System.out.print(venue.getVenId() + ",");
//			System.out.print(venue.getVenName() + ",");
//			System.out.println();
//		}
//	}
//
//	@Override
//	public boolean isVenueUsed(String venueName) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//}
