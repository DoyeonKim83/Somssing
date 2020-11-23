package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.SomUser;

public class SomUserDao {
	private static ConnectionManager cm = new ConnectionManager();

	/* 수정 */
	public static int update(SomUser user) {
		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;

		String sql = "UPDATE SOM_USER " + "SET password=?, username=?, email=?, phone=?, addr=?, birth=?, gender=? "
				+ "WHERE user_id=?";

		try {
			conn = cm.getConnection();
			
			conn.setAutoCommit(false);
			
			pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, user.getPassword());
			pStmt.setString(2, user.getUserName());
			pStmt.setString(3, user.getEmail());
			pStmt.setString(4, user.getPhone());
			pStmt.setString(5, user.getAddr());
			pStmt.setDate(6, new java.sql.Date(user.getBirth().getTime()));
			pStmt.setString(7, user.getGender());
			pStmt.setString(8, user.getUser_id());

			int result = pStmt.executeUpdate(); // update 문 실행
			if (result != 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
			return result;
		} catch (SQLException ex) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ex.printStackTrace();
		} finally { // 자원 반납
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		return 0;
	}

	/**
	 * 사용자 ID에 해당하는 사용자를 삭제.
	 */
	public static int remove(String userId) {
		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		int result = -1;

		String sql = "DELETE FROM RENT WHERE user_id=?"; //rent에서 삭제 되게(user_id가 기본키)
		String sql2 = "DELETE FROM MESSAGE WHERE receiver_id=?"; //message에서 삭제 되게 (기본키는 아님)
		String sql3 = "SELECT comm_id FROM POST WHERE user_id = ?";
		String sql4 = "DELETE FROM COMMUNITY WHERE comm_id=?"; //community 내에서 해당 comm_id 삭제 되게(post의 기본키가 기본키)
		String sql5 = "DELETE FROM POST WHERE user_id=?"; //post에서도 삭제 되게(user_id가 기본키)
		String sql6 = "DELETE FROM SOM_USER WHERE user_id=?";

		try {
			conn = cm.getConnection();
			conn.setAutoCommit(false);
			
			pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, userId);
			int result1 = pStmt.executeUpdate(); // delete 문 실행
			pStmt.close();
			
			pStmt = conn.prepareStatement(sql2);
			pStmt.setString(1, userId);
			int result2 = pStmt.executeUpdate(); // delete 문 실행
			pStmt.close();
			
			pStmt = conn.prepareStatement(sql5);
			pStmt.setString(1, userId);
			int result4 = pStmt.executeUpdate(); // delete 문 실행
			pStmt.close();
			
			pStmt = conn.prepareStatement(sql3);
			pStmt.setString(1, userId);
			rs = pStmt.executeQuery();
			String comm_id ="";
			if (rs.next())
				comm_id = rs.getString("comm_id");
			pStmt.close();
			
			pStmt = conn.prepareStatement(sql4);
			pStmt.setString(1, comm_id);
			int result3 = pStmt.executeUpdate(); // delete 문 실행
			pStmt.close();
			
			pStmt = conn.prepareStatement(sql6);
			pStmt.setString(1, userId);
			int result5 = pStmt.executeUpdate(); // delete 문 실행
		
			if (result5 != 0) {
				conn.commit();
				result = 1;
			} else {
				conn.rollback();
			}
			System.out.println(result);
			return result;
		} catch (SQLException ex) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ex.printStackTrace();
		} finally { // 자원 반납
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		return 0;
	}

	/**
	 * 주어진 사용자 ID에 해당하는 사용자 정보를 데이터베이스에서 찾아 User 도메인 클래스에 저장하여 반환.
	 */
	public static SomUser findUser(String userId) {
		updateGrade(userId);

		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;

		String sql = "SELECT password, username, email, phone, addr, birth, gender, grade, remain_time, count(r.bike_id) AS numofid "
				+ "FROM SOM_USER s, RENT r " + "WHERE s.user_id=? and s.user_id = r.user_id (+) "
				+ "GROUP BY password, username, email, phone, addr, birth, gender, grade, remain_time";

		try {
			conn = cm.getConnection();
			pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, userId);

			rs = pStmt.executeQuery(); // query 실행
			if (rs.next()) { // 학생 정보 발견
				SomUser user = new SomUser( // User 객체를 생성하여 학생 정보를 저장
						userId, rs.getString("password"), rs.getString("username"), rs.getString("email"),
						rs.getString("phone"), rs.getString("addr"), rs.getDate("birth"), rs.getString("gender"),
						rs.getString("grade"), rs.getInt("remain_time"), rs.getInt("numofid"));
				
				return user;
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

	/* 자전거 대여 기록 테이블의 column 개수를 이용해 Grade 결정 */
	public static void updateGrade(String userId) {
		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		String grade = "";

		String sql = "SELECT count(bike_id) AS numofid " + "FROM RENT " + "WHERE user_id=?";
		String sql2 = "UPDATE SOM_USER " + "SET grade=? " + "WHERE user_id=?";

		try {
			conn = cm.getConnection();
			conn.setAutoCommit(false);
			pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, userId);

			rs = pStmt.executeQuery();
			int res = -1;
			if (rs.next())
				res = rs.getInt("numofid");

			if (res >= 0)
				grade = "BRONZE";
			if (res >= 6)
				grade = "SILVER";
			if (res >= 15)
				grade = "GOLD";
			
			pStmt.close();
			
			pStmt = conn.prepareStatement(sql2);
			pStmt.setString(1, grade);
			pStmt.setString(2, userId);
			int result = pStmt.executeUpdate(); // update 문 실행
			
			if (result != 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (SQLException ex) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ex.printStackTrace();
		} finally { // 자원 반납
			try {
				conn.setAutoCommit(true); //다른 데에선 트랜잭션 사용 안 할 수도 있으니 true로 설정해주고 끝냄
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
	}

	public static boolean create(SomUser user) throws SQLException {
		Connection conn = null;
		PreparedStatement pStmt = null; // PreparedStatment 참조 변수 생성
		ResultSet rs = null;

		String query = "insert into SOM_USER values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			conn = cm.getConnection();
			pStmt = conn.prepareStatement(query);
			pStmt.setString(1, user.getUser_id());
			pStmt.setString(2, user.getPassword());
			pStmt.setString(3, user.getUserName());
			pStmt.setString(4, user.getEmail());
			pStmt.setString(5, user.getPhone());
			pStmt.setString(6, user.getAddr());
			pStmt.setDate(7, new java.sql.Date(user.getBirth().getTime()));
			pStmt.setString(8, user.getGender());
			pStmt.setString(9, user.getGrade());
			pStmt.setInt(10, user.getRemain_time());

			rs = pStmt.executeQuery();

			System.out.println("findDeptInfo 수행 완료 ");
			return true;

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
		return false;
	}

	public static void updateUserRemainTime(String user_id, int time) {

		// 기존과 동일
		Connection conn = null;
		PreparedStatement pStmt = null; // PreparedStatment 참조 변수 생성
		ResultSet rs = null;

		String query = "update SOM_USER" + " set remain_time = remain_time " + time + " where user_id = ?";

		try {
			conn = cm.getConnection();
			pStmt = conn.prepareStatement(query);
			pStmt.setString(1, user_id);

			rs = pStmt.executeQuery();
			System.out.println("updateUserRemainTime 수행 완료 ");

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

	}
	public static boolean existedUser(String userId) {
		
		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;

		String sql = "SELECT count(*) FROM SOM_USER WHERE user_id=?";

		try {
			conn = cm.getConnection();
			pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, userId);

			rs = pStmt.executeQuery(); 
			if (rs.next()) { 
				int count = rs.getInt(1);
				return (count == 1 ? true : false);
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally { 
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
		return false;
	}
}
