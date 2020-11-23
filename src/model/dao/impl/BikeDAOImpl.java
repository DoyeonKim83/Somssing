package model.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dao.*;
import model.*;

public class BikeDAOImpl implements BikeDao {

	private JDBCUtil jdbcUtil = null;

	private static String query = "SELECT BIKE.BIKE_ID AS B_ID, " + "       BIKE.RENTAL_NUM AS R_NUM, "
			+ "       BIKE.RENTAL_OK AS R_OK, " + "       BIKE.BROKEN_OK AS B_OK " + "       BIKE.LOST_OK AS L_OK ";

	public BikeDAOImpl() {
		jdbcUtil = new JDBCUtil();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}

	private static Connection getConnection() {
		String url = // "jdbc:oracle:thin:@localhost:1521:xe";
				"jdbc:oracle:thin:@202.20.119.117:1521:orcl";
		String user = "dbprog0105";
		String passwd = "som05";

		// DBMS와의 연결 획득
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, passwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public List<Bike> getBikeList() {
		// TODO Auto-generated method stub
		String allQuery = query + ", " + "BIKE.RENTAL_ID AS R_ID, " + "BIKE.RENTAL_NAME AS R_NAME  "
				+ "FROM BIKE ORDER BY BIKE.BIKE_ID ASC ";
		jdbcUtil.setSql(allQuery);

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<Bike> list = new ArrayList<Bike>(); // BikeDTO 객체들을 담기위한 list 객체
			while (rs.next()) {
				Bike dto = new Bike(); // 하나의 BikeDTO 객체 생성 후 정보 설정
				dto.setBike_id(rs.getString("B_ID"));
				dto.setRental_num(rs.getInt("R_NUM"));
				dto.setRental_ok(rs.getInt("R_OK"));
				dto.setBroken_ok(rs.getInt("B_OK"));
				dto.setLost_ok(rs.getInt("L_OK"));
				dto.setRental_id(rs.getString("R_ID"));
				dto.setRental_name(rs.getString("R_NAME"));

				list.add(dto); // list 객체에 정보를 설정한 BikeDTO 객체 저
			}
			return list; // 학생정보를 저장한 dto 들의 목록을 반환
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close(); // ResultSet, PreparedStatement, Connection ��ȯ
		}
		return null;
	}

	public Bike getBikeByBikeId(String bike_id) {
		String searchQuery = query + ", " + "RENTALOFFICE.R_ID AS R_ID, " + "RENT.R_NAME AS R_NAME "
				+ "FROM BIKE, RENTALOFFICE, RENT " + "WHERE BIKE.BIKE_ID = ? AND "
				+ "BIKE.R_ID = RENTALOFFICE.R_ID AND " + "BIKE.R_NAME = RENT.R_NAME ";

		jdbcUtil.setSql(searchQuery);
		Object[] param = new Object[] { bike_id };
		jdbcUtil.setParameters(param);

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			Bike dto = new Bike();
			if (rs.next()) { // while/if
				dto.setBike_id(rs.getString("B_ID"));
				dto.setRental_num(rs.getInt("R_NUM"));
				dto.setRental_ok(rs.getInt("R_OK"));
				dto.setBroken_ok(rs.getInt("B_OK"));
				dto.setLost_ok(rs.getInt("L_OK"));
				dto.setRental_id(rs.getString("R_ID"));
				dto.setRental_name(rs.getString("R_NAME"));
			}
			return dto;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

	public int insertBike(Bike bike) {
		// TODO Auto-generated method stub
		int result = 0;
		String insertQuery = "INSERT INTO BIKE (BIKE_ID, RENTAL_NUM, RENTAL_OK, BROKEN_OK, LOST_OK, RENTAL_ID, RENTAL_NAME) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?) ";

		DAOFactory factory = new DAOFactory();

		RentalOfficeDao RentOffDAO = factory.getRentalOfficeDAO();
		RentalOffice RentOffDTO = RentOffDAO.getRentalOfficeById(bike.getRental_id());
		String Rental_id = RentOffDTO.getRental_id();
		if (Rental_id == null) {
			System.out.println("해당 Rent Office가 없습니다." + bike.getRental_id());
			return 0;
		}

		RentDao rentDAO = factory.getRentDAO();
		Rent rentDTO = rentDAO.getRentOfficeByBikeId(bike.getRental_name());
		String Rental_name = rentDTO.getBike_id();
		if (Rental_name == null) {
			System.out.println("해당 Rent Office가 없습니다.");
			return 0;
		}

		Object[] param = new Object[] { bike.getBike_id(), bike.getRental_num(), bike.getRental_ok(),
				bike.getBroken_ok(), bike.getLost_ok(), Rental_id, Rental_name };
		jdbcUtil.setSql(insertQuery);
		jdbcUtil.setParameters(param);

		try {
			result = jdbcUtil.executeUpdate();
			System.out.println(bike.getBike_id() + " 자전거정보가 삽입되었습니다.");
		} catch (SQLException ex) {
			System.out.println("입력오류 발생!!!");
			if (ex.getErrorCode() == 1)
				System.out.println("동일한 자전거정보가 이미 존재합니다.");
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // ResultSet, PreparedStatement, Connection 반환
		}
		return result; // insert 에 의해 반영된 레코드 수 반환
	}

	public int deleteBike(String bikeID) {
		// TODO Auto-generated method stub
		String deleteQuery = "DELETE FROM BIKE WHERE STU_NO = ?";

		jdbcUtil.setSql(deleteQuery);
		Object[] param = new Object[] { bikeID };
		jdbcUtil.setParameters(param);

		try {
			int result = jdbcUtil.executeUpdate();
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return 0;
	}

	// 유저아이디로 이용중인 자전거 정보와 시간 찾기
	public BikeTime getProfByUserId(String user_id) {
		Connection conn = null;
		PreparedStatement pStmt = null; // PreparedStatment 참조 변수 생성
		ResultSet rs = null;

		String query = "SELECT bike_id, remain_time " + "FROM SOM_USER u, RENT r " + "WHERE u.user_id = r.user_id = ? ";

		try {
			conn = getConnection();
			pStmt = conn.prepareStatement(query);
			pStmt.setString(1, user_id);
			rs = pStmt.executeQuery();

			if (rs.next()) {

				int remain_time = rs.getInt("remain_time");
				String bike_id = rs.getString("bike_id");

				BikeTime biketime = new BikeTime(remain_time, bike_id);

				return biketime;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally { // 자원 반납
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			if (pStmt != null)
				try {
					pStmt.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
		}

		return null;
	}

	@Override
	// 내가 고장 신고접수한 자전거list 상세정보 보기
	public List<BikeBrokenOrLost> getBikeBrokenOrLostList(String user_id) {

		Connection conn = null;
		PreparedStatement pStmt = null; // PreparedStatment 참조 변수 생성
		ResultSet rs = null;

		String query = "SELECT bike_id, rental_name, rental_id, broken_ok, lost_ok " + "FROM BIKE b, RENT r"
				+ "WHERE user_id = ? and b.bike_id = r.bike_id";

		try {
			conn = getConnection();
			pStmt = conn.prepareStatement(query);
			pStmt.setString(1, user_id);
			rs = pStmt.executeQuery();

			List<BikeBrokenOrLost> list = new ArrayList<BikeBrokenOrLost>();
			while (rs.next()) {
				String bike_id = rs.getString("bike_id");
				String rental_name = rs.getString("rental_name");
				String rental_id = rs.getString("rental_id");
				String why_broken = rs.getString("why_broken");

				BikeBrokenOrLost bikebroken = new BikeBrokenOrLost(bike_id, rental_name, rental_id, why_broken);
				list.add(bikebroken);
			}
			return list;
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally { // 자원 반납
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			if (pStmt != null)
				try {
					pStmt.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
		}
		return null;
	}

}
