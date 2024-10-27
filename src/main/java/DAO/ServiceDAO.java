/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Customer;
import Model.Service;
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
public class ServiceDAO extends DBContext {

    public ServiceDAO() {
        super();
    }
    
    public List<Service> GetAll() {
        List<Service> list = new ArrayList<>();
        String query = "Select  *  from Services";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            
                Service s = new Service(
                rs.getInt("Service_ID"),
                rs.getString("ServiceName"),
                rs.getString("Description"),
                rs.getInt("Price"),
                rs.getString("IMAGES")
                );
                list.add(s);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
        
    public Service Get( int id ) {
       Service  s =  new Service();
        String query = "select * from Services where Service_ID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
            s.setId(rs.getInt("Service_ID"));
            s.setName(rs.getString("ServiceName"));
            s.setDescription("Description");
            s.setPrice(rs.getInt("Price"));
            s.setImages(rs.getString("IMAGES"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return s;
    }
        public void Update(Service ser) {
        String query = "UPDATE Services SET ServiceName = ?, Description = ?,"
                +"Price=?,"
                + "IMAGES=?"
                + " WHERE Service_ID = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, ser.getName());
            pstmt.setString(2, ser.getDescription());
            pstmt.setInt(3, ser.getPrice());
            pstmt.setString(4, ser.getImages());
            pstmt.setInt(5, ser.getId());
            pstmt.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }
        public boolean Add(Service ser) {
        String query = "INSERT INTO Services (Service_ID, ServiceName, Description,Price,IMAGES) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, ser.getId());
            pstmt.setString(2, ser.getName());
            pstmt.setString(3, ser.getDescription());
            pstmt.setInt(4, ser.getPrice());
            pstmt.setString(5,ser.getImages());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return false;
    }
           public void Delete(String id) {
        String query = "Delete Services WHERE Service_ID = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, id);
            pstmt.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
