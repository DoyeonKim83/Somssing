package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.dao.*;
import model.BikeBrokenOrLost;
import model.Rent;
import model.RentalOffice;

public class BikeBrokenOrLostDAOImpl implements BikeBrokenOrLostDao {
   
   private ConnectionManager cm = new ConnectionManager(); 
   
   // 내가 고장 신고접수한 자전거list 상세정보 보기
   public List<BikeBrokenOrLost> getBikeBrokenOrLostList(String user_id) {

      Connection conn = null;
      PreparedStatement pStmt = null; // PreparedStatment 참조 변수 생성
      ResultSet rs = null;

      String query = "SELECT b.bike_id, r.rental_name, r.rental_id, b.broken_ok, b.lost_ok " 
            + "FROM BIKE b, RENT r"
            + "WHERE r.user_id = ? and b.bike_id = r.bike_id";

      try {
         // conn = getConnection();
         conn = cm.getConnection(); // 요로케 커넥션풀이용!
         pStmt = conn.prepareStatement(query);
         pStmt.setString(1, user_id);
         rs = pStmt.executeQuery();

         List<BikeBrokenOrLost> list = new ArrayList<BikeBrokenOrLost>();
         while (rs.next()) {
            String bike_id = rs.getString("bike_id");
            String rental_name = rs.getString("rental_name");
            String rental_id = rs.getString("rental_id");
            String why_BrokenOrLost =  rs.getString("why_BrokenOrLost");
      
            BikeBrokenOrLost bikebroken = new BikeBrokenOrLost(bike_id, rental_name, rental_id, why_BrokenOrLost);
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

   @Override
   public void insertBikeBroken(String bike_id, String rentalOffice_name, 
         String rentalOffice_id, String why_BrokenOrLost) {
      
      Connection conn = null;
      PreparedStatement pStmt = null; // PreparedStatment 참조 변수 생성
      ResultSet rs = null;

      String query = "UPDATE BIKE "
            +"SET broken_ok = 1 " 
            + "WHERE bike_id = ?";
      

      try {
         conn = cm.getConnection(); // 요로케 커넥션풀이용!
         conn.setAutoCommit(false);
         
         pStmt = conn.prepareStatement(query);
         pStmt.setString(1, bike_id);
         pStmt.executeUpdate();
   
         rs = pStmt.executeQuery();
         
      
         pStmt.close();   

         
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
   
   @Override
   public void insertBikeLost(String bike_id, String rentalOffice_name, 
         String rentalOffice_id, String why_BrokenOrLost) {
      

   Connection conn = null;
   PreparedStatement pStmt = null; // PreparedStatment 참조 변수 생성
   ResultSet rs = null;
   
   String query = "UPDATE BIKE "
         +"SET lost_ok = 1 " 
         + "WHERE bike_id = ?";
   
   
   try {
      conn = cm.getConnection(); // 요로케 커넥션풀이용!
      conn.setAutoCommit(false);
      
      pStmt = conn.prepareStatement(query);
      pStmt.setString(1, bike_id);
      pStmt.executeUpdate();
   
      rs = pStmt.executeQuery();
      
   
      pStmt.close();   
   
      
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
}