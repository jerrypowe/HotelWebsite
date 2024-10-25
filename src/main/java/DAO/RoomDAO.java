/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Customer;
import Model.Room;
import Model.Room_manage;
import Utils.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    
     public void UpdateCustomer(String status , String code) {
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
        public Room_manage GetRoom( String code ) {
       Room_manage rm = new Room_manage();
        String query = "select * from Room_Manage where Room_Code = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, code);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
               String avai = rs.getString("Status");
               String booked = rs.getString("Status");
               String occup =  rs.getString("Status");
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
