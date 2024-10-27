/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Reservation;
import Model.ReservationHasService;
import Utils.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class ReservationDAO extends DBContext {

    public Reservation GetReservation(String rm) {
        Reservation re = new Reservation();
        String query = "SELECT * FROM Reservation WHERE Room_Code = ? ";

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, rm);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                re.setReservation_ID(rs.getInt("Reservation_ID"));
                re.setCustomer_ID(rs.getInt("Customer_ID"));
                re.setRoom_Code(rs.getString("Room_Code"));
                re.setTotalPrice(rs.getInt("TotalPrice"));
                re.setCheck_Out_Date(rs.getDate("CheckOutDate"));
                re.setCheck_In_Date(rs.getDate("Check_In_Date"));
            }
        } catch (Exception e) {
        }
        return re;
    }

    public Reservation GetReservationByReservationID(int rm) {
        Reservation re = new Reservation();
        String query = "SELECT * FROM Reservation WHERE Reservation_ID = ? ";

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, rm);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                re.setReservation_ID(rs.getInt("Reservation_ID"));
                re.setCustomer_ID(rs.getInt("Customer_ID"));
                re.setRoom_Code(rs.getString("Room_Code"));
                re.setTotalPrice(rs.getInt("TotalPrice"));
                re.setCheck_Out_Date(rs.getDate("CheckOutDate"));
                re.setCheck_In_Date(rs.getDate("Check_In_Date"));
            }
        } catch (Exception e) {
        }
        return re;
    }
public  List<ReservationHasService> GetAllReserationHasService(){
List<ReservationHasService> list = new ArrayList<>();
String query = "SELECT * FROM Reservation_Has_Services ";
  try {
            PreparedStatement pstmt = conn.prepareStatement(query);
         
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                ReservationHasService re = new ReservationHasService(rs.getInt("Reservation_ID"), rs.getInt("Service_ID"), rs.getInt("Quantity"), rs.getInt("Sales"));
                list.add(re);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
  return list;
}
    public ReservationHasService GetReservationHasServices(int reservationid) {
        ReservationHasService re = new ReservationHasService();
        String query = "SELECT * FROM Reservation_Has_Services WHERE Reservation_ID = ? ";

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, reservationid);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                re.setReservationid(rs.getInt("Reservation_ID"));
                re.setServiceid(rs.getInt("Service_ID"));
                re.setQuantity(rs.getInt("Quantity"));
                re.setSales(rs.getInt("Sales"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return re;
    }

    public List<ReservationHasService> GetAllReservationHasService() {

        List<ReservationHasService> list = new ArrayList<>();
        String query = "SELECT * FROM Reservation_Has_Services";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ReservationHasService re = new ReservationHasService(
                        rs.getInt("Reservation_ID"),
                        rs.getInt("Service_ID"),
                        rs.getInt("Quantity"),
                        rs.getFloat("Sales")
                );

                list.add(re);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

}
