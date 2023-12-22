package com.venue.model;

import java.io.FileInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class VenueDAO implements VenueDAO_interface {

	private static final String INSERT_STMT = 
			"INSERT INTO venue (ven_name, ven_type_id, ven_descr, ven_loc, ven_price, ven_status, ven_mod_time, ven_tot_rating, ven_rate_count, ven_pic) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		private static final String GET_ALL_STMT = 
			"SELECT ven_id, ven_name, ven_type_id,ven_loc,ven_price,ven_status,ven_tot_rating,ven_rate_count,ven_pic,ven_descr FROM venue order by ven_name";
		private static final String GET_ONE_STMT = 
				"SELECT ven_id, ven_name, ven_type_id,ven_loc,ven_price,ven_status,ven_tot_rating,ven_rate_count,ven_pic,ven_descr FROM venue WHERE ven_id = ?";
		private static final String DELETE = 
			"DELETE FROM venue where ven_id = ?";
		private static final String UPDATE = 
			"UPDATE venue set ven_name=?, ven_pic=?, ven_type_id=?, ven_descr=?, ven_loc=?, ven_price=?, ven_status=? where ven_id = ?";
		private static final String GET_VENUE_BY_NAME = 
				"SELECT * FROM venue WHERE ven_name = ?";
		
		
		
		private static DataSource ds = null;
		static {
			try {
				Context ctx = new InitialContext();
				ds = (DataSource) ctx.lookup("java:comp/env/jdbc/project03");
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
		
		

		@Override
		public Integer insert(VenueVO venueVO) {

			Connection con = null;
			PreparedStatement pstmt = null;
			
			String[] cols = { "ven_id" }; // 或 int cols[] = {1};
			int key;

			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(INSERT_STMT, cols);

				pstmt.setString(1, venueVO.getVenName());
				pstmt.setInt(2, venueVO.getVenTypeId());
				pstmt.setString(3, venueVO.getVenDescr());
				pstmt.setString(4, venueVO.getVenLoc());
				pstmt.setBigDecimal(5, venueVO.getVenPrice());
				pstmt.setByte(6, venueVO.getVenStatus());
				pstmt.setObject(7, venueVO.getVenModTime());
				pstmt.setDouble(8, venueVO.getVenTotRating());
				pstmt.setInt(9, venueVO.getVenRateCount());
				pstmt.setBytes(10, venueVO.getVenPic());
				
				pstmt.executeUpdate();

				ResultSet rs = pstmt.getGeneratedKeys();
				rs.next();
				key = rs.getInt(1); // MySQL驅動只支援欄位索引值取得自增主鍵值



				// Handle any driver errors
			} catch (SQLException se) {
				throw new RuntimeException("A database error occured. "
						+ se.getMessage());
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
			return key;
		}

		@Override
		public void update(VenueVO venueVO) {

			Connection con = null;
			PreparedStatement pstmt = null;

			try {

				con = ds.getConnection();
				pstmt = con.prepareStatement(UPDATE);

				pstmt.setString(1, venueVO.getVenName());
				pstmt.setBytes(2, venueVO.getVenPic());
				pstmt.setInt(3, venueVO.getVenTypeId());
				pstmt.setString(4, venueVO.getVenDescr());
				pstmt.setString(5, venueVO.getVenLoc());
				pstmt.setBigDecimal(6, venueVO.getVenPrice());
				pstmt.setByte(7, venueVO.getVenStatus());
				pstmt.setInt(8, venueVO.getVenId());

				pstmt.executeUpdate();

				// Handle any driver errors
			} catch (SQLException se) {
				throw new RuntimeException("A database error occured. "
						+ se.getMessage());
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
		public void delete(Integer venueId) {

			Connection con = null;
			PreparedStatement pstmt = null;

			try {

				con = ds.getConnection();
				pstmt = con.prepareStatement(DELETE);

				pstmt.setInt(1, venueId);

				pstmt.executeUpdate();

				// Handle any driver errors
			} catch (SQLException se) {
				throw new RuntimeException("A database error occured. "
						+ se.getMessage());
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
		public VenueVO findByPrimaryKey(Integer venueId) {

			VenueVO venueVO = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {

				con = ds.getConnection();
				pstmt = con.prepareStatement(GET_ONE_STMT);

				pstmt.setInt(1, venueId);

				rs = pstmt.executeQuery();
				
				ResultSetMetaData rsmd = rs.getMetaData();      // Create a ResultSetMetaData object  1 

				while (rs.next()) {

					venueVO = new VenueVO();
					venueVO.setVenId(rs.getInt("ven_id"));
					venueVO.setVenTypeId(rs.getInt("ven_type_id"));
					venueVO.setVenName(rs.getString("ven_name"));
					venueVO.setVenLoc(rs.getString("ven_loc"));
					venueVO.setVenPrice(rs.getBigDecimal("ven_price"));
					venueVO.setVenStatus(rs.getByte("ven_status"));
					venueVO.setVenTotRating(rs.getDouble("ven_tot_rating"));
					venueVO.setVenRateCount(rs.getInt("ven_rate_count"));	
					venueVO.setVenPic(rs.getBytes("ven_pic"));	
					venueVO.setVenDescr(rs.getString("ven_descr"));	
				}

				// Handle any driver errors
			} catch (SQLException se) {
				throw new RuntimeException("A database error occured. "
						+ se.getMessage());
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
			return venueVO;
		}

		@Override
		public List<VenueVO> getAll() {
			List<VenueVO> list = new ArrayList<VenueVO>();
			VenueVO venueVO = null;

			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {

				con = ds.getConnection();
				pstmt = con.prepareStatement(GET_ALL_STMT);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					venueVO = new VenueVO();
					venueVO.setVenId(rs.getInt("ven_id"));
					venueVO.setVenTypeId(rs.getInt("ven_type_id"));
					venueVO.setVenName(rs.getString("ven_name"));
					venueVO.setVenLoc(rs.getString("ven_loc"));
					venueVO.setVenPrice(rs.getBigDecimal("ven_price"));
					venueVO.setVenStatus(rs.getByte("ven_status"));
					venueVO.setVenTotRating(rs.getDouble("ven_tot_rating"));
					venueVO.setVenRateCount(rs.getInt("ven_rate_count"));	
					venueVO.setVenPic(rs.getBytes("ven_pic"));	
					venueVO.setVenDescr(rs.getString("ven_descr"));	
					
					list.add(venueVO); // Store the row in the list
				}

				// Handle any driver errors
			} catch (SQLException se) {
				throw new RuntimeException("A database error occured. "
						+ se.getMessage());
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
		
		
		
		@Override
		public boolean isVenueUsed(String venueName) {

			VenueVO venueVO = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {

				con = ds.getConnection();
				pstmt = con.prepareStatement(GET_VENUE_BY_NAME);

				pstmt.setString(1, venueName);

				rs = pstmt.executeQuery();
				
				ResultSetMetaData rsmd = rs.getMetaData();      // Create a ResultSetMetaData object  1 

				return rs.isBeforeFirst();

				// Handle any driver errors
			} catch (SQLException se) {
				throw new RuntimeException("A database error occured. "
						+ se.getMessage());
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
		}

}
