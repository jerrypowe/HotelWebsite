/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Customer;
import Model.Reservation;
import Model.ReservationHasService;
import Model.Room;
import Model.Room_manage;
import Utils.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class RoomDAO extends DBContext {

    public List<Room_manage> GetAll() {
        List<Room_manage> list = new ArrayList<>();
        Room_manage roomM = new Room_manage();
        String query = "Select  *  from Room_Manage";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String status = rs.getString("Status");
                boolean available = false;
                boolean booked = false;
                boolean occupied = false;
                if (roomM.isAvai(status)) {
                    available = true;
                } else if (roomM.isBooked(status)) {
                    booked = true;
                } else if (roomM.isOccup(status)) {
                    occupied = true;
                }
                Room_manage rm = new Room_manage(
                        rs.getString("Room_Code"),
                        rs.getInt("Room_ID"),
                        available,
                        booked,
                        occupied
                );
                list.add(rm);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public String getStatusOfRoom() {
        String status = "";
        String query = "select * from Room_Manage";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                status = rs.getString("Status");
            }
        } catch (Exception e) {
        }
        return status;
    }

    public List<Room_manage> getAllBooked() {
        List<Room_manage> list = new ArrayList<>();
        Room_manage roomM = new Room_manage();
        String query = "select * from Room_Manage where Status LIKE 'Booked'";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Room_manage rm = new Room_manage(
                        rs.getString("Room_Code"),
                        rs.getInt("Room_ID"),
                        false,
                        true,
                        false
                );
                list.add(rm);
            }
        } catch (Exception e) {
        }
        return list;
    }

        public List<Room_manage> getAllAvailable() {
        List<Room_manage> list = new ArrayList<>();
        Room_manage roomM = new Room_manage();
        String query = "select * from Room_Manage where Status LIKE 'Available'";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Room_manage rm = new Room_manage(
                        rs.getString("Room_Code"),
                        rs.getInt("Room_ID"),
                       true ,
                        false,
                        false
                );
                list.add(rm);
            }
        } catch (Exception e) {
        }
        return list;
    }
    public List<Room_manage> getAllOccupied() {
        List<Room_manage> list = new ArrayList<>();
        Room_manage roomM = new Room_manage();
        String query = "select * from Room_Manage where Status LIKE 'Occupied'";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Room_manage rm = new Room_manage(
                        rs.getString("Room_Code"),
                        rs.getInt("Room_ID"),
                        false,
                        false,
                        true
                );
                list.add(rm);
            }
        } catch (Exception e) {
        }
        return list;
    }

//    public Reservation GetReservation(Room_manage rm) {
//        Reservation re = new Reservation();
//        String query = "SELECT * FROM Reservation WHERE Room_Code = ? ";
//
//        try {
//            PreparedStatement pstmt = conn.prepareStatement(query);
//            pstmt.setString(1, rm.getCode());
//            ResultSet rs = pstmt.executeQuery();
//
//            if (rs.next()) {
//                re.setReservation_ID(rs.getInt("Reservation_ID"));
//                re.setRoom_Code(rs.getString("Room_Code"));
//                re.setCustomer_ID(rs.getInt("Customer_ID"));
//                re.setTotalPrice(rs.getInt("TotalPrice"));
//                re.setCheck_Out_Date(rs.getDate("CheckOutDate"));
//                re.setCheck_In_Date(rs.getDate("Check_In_Date"));
//            }
//        } catch (Exception e) {
//        }
//        return re;
//    }
//        public Reservation GetReservation(int rm) {
//        Reservation re = new Reservation();
//        String query = "SELECT * FROM Reservation WHERE Reservation_ID = ? ";
//
//        try {
//            PreparedStatement pstmt = conn.prepareStatement(query);
//            pstmt.setInt(1, rm);
//            ResultSet rs = pstmt.executeQuery();
//
//            if (rs.next()) {
//                re.setReservation_ID(rs.getInt("Reservation_ID"));
//                re.setRoom_Code(rs.getString("Room_Code"));
//                re.setCustomer_ID(rs.getInt("Customer_ID"));
//                re.setTotalPrice(rs.getInt("TotalPrice"));
//                re.setCheck_Out_Date(rs.getDate("CheckOutDate"));
//                re.setCheck_In_Date(rs.getDate("Check_In_Date"));
//            }
//        } catch (Exception e) {
//        }
//        return re;
//    }
//       public ReservationHasService GetReservationHasServices(int r) {
//        ReservationHasService re = new ReservationHasService();
//        String query = "SELECT * FROM ReservationHasService WHERE Reservation_ID = ? ";
//
//        try {
//            PreparedStatement pstmt = conn.prepareStatement(query);
//            pstmt.setInt(1, r);
//            ResultSet rs = pstmt.executeQuery();
//
//            if (rs.next()) {
//                re.setReservationid(rs.getInt("Reservation_ID"));
//                re.setServiceid(rs.getInt("Service_ID"));
//                re.setQuantity(rs.getInt("Quantity"));
//                re.setSales(rs.getInt("Sales"));
//            }
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//        return re;
//    }
//       public List<ReservationHasService> GetAllReservationHasService(){
//         
//         List<ReservationHasService> list = new ArrayList<>();
//        String query = "SELECT * FROM Reservation_Has_Services";
//        try{
//        PreparedStatement ps = conn.prepareStatement(query);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//              ReservationHasService re = new ReservationHasService(
//              rs.getInt("Reservation_ID"),
//              rs.getInt("Service_ID"),
//              rs.getInt("Quantity"),
//              rs.getFloat("Sales")
//              
//              );
//              
//                list.add(re);
//            }
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//        return list;
//       }

    public void UpdateCustomer(String status, String code) {
        String query = "UPDATE Room_Manage SET Status = ? WHERE Room_Code = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, status);
            pstmt.setString(2, code);

            pstmt.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public Room_manage GetRoom(String code) {
        Room_manage rm = new Room_manage();
        String query = "select * from Room_Manage where Room_Code = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, code);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String avai = rs.getString("Status");
                String booked = rs.getString("Status");
                String occup = rs.getString("Status");
                rm.setCode(rs.getString("Room_Code"));
                rm.setID(rs.getInt("Room_ID"));
                rm.setAvailable(rm.isAvai(avai));
                rm.setBooked(rm.isBooked(booked));
                rm.setOccupied(rm.isOccup(occup));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return rm;
    }
}
