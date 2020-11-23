package model.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dao.*;
import model.*;

public class MessageDAOImpl implements MessageDao {
	
private JDBCUtil jdbcUtil = null;
	
	private static String query = "SELECT MESSAGE.MSG_ID AS M_ID, " +
								  "       MESSAGE.MSG_CONTENT AS M_CON, " +
//								  "       MESSAGE.RECEIVE_TIME AS R_TIME, " +
//								  "       MESSAGE.SEND_TIME AS S_TIME " +
								  "       MESSAGE.RECEIVER_ID AS R_ID " +
								  "       MESSAGE.SENDER_ID AS S_ID ";
		
	public MessageDAOImpl() {
		jdbcUtil = new JDBCUtil();
	}


	public List<MessageSent> getMessageSentList(String user_id) {
		// TODO Auto-generated method stub
		String allQuery = query + ", " + "MESSAGE.SEND_TIME AS S_TIME " +
		    "FROM MESSAGE " +
			"WHERE USER_ID = ? ";
		
			jdbcUtil.setSql(allQuery);		// JDBCUtil 에 query 설정
		
		try { 
			ResultSet rs = jdbcUtil.executeQuery();		// query 문 실행			
			List<MessageSent> list = new ArrayList<MessageSent>();		// MessageSentDTO 객체들을 담기위한 list 객체
			while (rs.next()) {	
			MessageSent dto = new MessageSent();		// 하나의 MessageSentDTO 객체 생성 후 정보 설정
			dto.setMsg_id(rs.getInt("M_ID"));
			dto.setMsg_content(rs.getString("M_CON"));
			dto.setSend_time(rs.getDate("S_TIME"));
			dto.setReceiver_id(rs.getString("R_ID"));
			dto.setSender_id(rs.getString("S_ID"));
			
			list.add(dto);		// list 객체에 정보를 설정한 MessageSentDTO 객체 저장
		}
		return list;		// message정보를 저장한 dto 들의 목록을 반환
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection 반환
		}		
		return null;
	}


	public List<MessageReceive> getMessageReceiveList(String user_id) {
		// TODO Auto-generated method stub
		String allQuery = query + ", " + "MESSAGE.RECEIVE_TIME AS R_TIME " +
			    "FROM MESSAGE " +
				"WHERE USER_ID = ? ";
			
				jdbcUtil.setSql(allQuery);		// JDBCUtil 에 query 설정
			
			try { 
				ResultSet rs = jdbcUtil.executeQuery();		// query 문 실행			
				List<MessageReceive> list = new ArrayList<MessageReceive>();		// MessageReceiveDTO 객체들을 담기위한 list 객체
				while (rs.next()) {	
				MessageReceive dto = new MessageReceive();		// 하나의 MessageSentDTO 객체 생성 후 정보 설정
				dto.setMsg_id(rs.getInt("M_ID"));
				dto.setMsg_content(rs.getString("M_CON"));
				dto.setReceive_time(rs.getDate("R_TIME"));
				dto.setReceiver_id(rs.getString("R_ID"));
				dto.setSender_id(rs.getString("S_ID"));
				
				list.add(dto);		// list 객체에 정보를 설정한 MessageSentDTO 객체 저장
			}
			return list;		// message정보를 저장한 dto 들의 목록을 반환
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				jdbcUtil.close();		// ResultSet, PreparedStatement, Connection 반환
			}		
			return null;
	}


	public int insertMessageSend(MessageSend msg_send) {
		// TODO Auto-generated method stub
		int result = 0;
		String insertQuery = "INSERT INTO BIKE (MSG_ID, MSG_CONTENT, SEND_TIME, RECEIVER_ID, SENDER_ID) " +
							 "VALUES (?, ?, ?, ?, ?) ";
		
		DAOFactory factory = new DAOFactory();		// 교수정보와 학과정보를 알아오기 위해 DAO 객체를 생성하는 factory 객체 생성
		
//		// ProfDAO 객체를 생성하여 학생정보에 포함되어 있는 지도교수의 교수코드를 알아옴
//		MessageDAO MessageDAO = factory.getMessageDAO();		// factory 를 통해 message에 대한 DAO 획득
//		MessageSendDTO MessageSendDTO = MessageDAO.getMessageByUserId(msg_send.getSender_id());		// 교수 DAO 의 이름을 사용하여 교수코드를 얻어오는 메소드 사용
//		String Msg_id = MessageSendDTO.getMsg_id();		// 교수코드를 설정
//		if (Rental_id == null) {
//			System.out.println("해당 Rent Office가 없습니다." + bike.getRental_id());
//			return 0;
//		}
//		
//		// DeptDAO 객체를 생성하여 학생정보에 포함되어 있는 학과의 학과코드를 알아옴
//		RentDAO rentDAO = factory.getRentDAO();		// factory 를 통해 학과에 대한 DAO 획득
//		RentDTO rentDTO = rentDAO.getRentByBikeId(bike.getRental_name());		// 학과 DAO 의 학과명을 사용하여 학과코드를 얻어오는 메소드 사용
//		String Rental_name = rentDTO.getBike_id();			// 학과코드를 설정
//		if (Rental_name == null) {
//			System.out.println("해당 Rent가 없습니다.");
//			return 0;
//		}
		// query 문에 사용할 매개변수 값을 갖는 매개변수 배열 생성
		Object[] param = new Object[] {msg_send.getMsg_id(),
				msg_send.getMsg_content(), msg_send.getSend_time(), msg_send.getReceiver_id(), msg_send.getSender_id()};		
		jdbcUtil.setSql(insertQuery);			// JDBCUtil 에 insert 문 설정
		jdbcUtil.setParameters(param);			// JDBCUtil 에 매개변수 설정
				
		try {				
			result = jdbcUtil.executeUpdate();		// insert 문 실행
			System.out.println(msg_send.getMsg_id() + " 메시지정보가 삽입되었습니다.");
		} catch (SQLException ex) {
			System.out.println("입력오류 발생!!!");
			if (ex.getErrorCode() == 1)
				System.out.println("동일한 메시지정보가 이미 존재합니다."); 
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection 반환
		}		
		return result;		// insert 에 의해 반영된 레코드 수 반환	
	}


	public int deleteMessage(String msg_id) {
		// TODO Auto-generated method stub
		String deleteQuery = "DELETE FROM BIKE WHERE STU_NO = ?";
		
		jdbcUtil.setSql(deleteQuery);			// JDBCUtil 에 query 문 설정
		Object[] param = new Object[] {msg_id};
		jdbcUtil.setParameters(param);			// JDBCUtil 에 매개변수 설정
		
		try {
			int result = jdbcUtil.executeUpdate();		// delete 문 실행
			return result;						// delete 에 의해 반영된 레코드 수 반환
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();		
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection 반환
		}
		return 0;
	}


	public MessageSend getMessageByUserId(String user_id) {
		// TODO Auto-generated method stub
		String searchQuery = query + ", " + "MESSAGE.SEND_TIME AS S_TIME, " +
		  "FROM MESSAGE, SOM_USER " +
		  "WHERE MESSAGE.SENDER_ID = ? AND " +
		        "MESSAGE.SENDER_ID = SOM_USER.USER_ID ";
	
		jdbcUtil.setSql(searchQuery);
		Object[] param = new Object[] {user_id};
		jdbcUtil.setParameters(param);
	
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			MessageSend dto = new MessageSend();
			if (rs.next()) { //while/if
				dto.setMsg_id(rs.getInt("M_ID"));
				dto.setMsg_content(rs.getString("M_CON"));
				dto.setSend_time(rs.getDate("S_TIME"));
				dto.setReceiver_id(rs.getString("R_ID"));
				dto.setSender_id(rs.getString("S_ID"));
			}
			return dto;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

}
