/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Customer;
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
public class CustomerDAO extends DBContext {

//    public CustomerDAO() {
//        super();
//    }

    
    public List<Customer> GetAll() {
        List<Customer> list = new ArrayList<>();
        String query = "Select  *  from Customers";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Customer cus = new Customer(
                        rs.getInt("Customer_ID"),
                        rs.getString("Customer_Name"),
                        rs.getString("Address"),
                         rs.getString("PhoneNumber"),
                        rs.getString("Email"),
                        rs.getString("Password"),
                        rs.getInt("Age")
                );
                list.add(cus);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public boolean AddCustomer(Customer cus) {
        String query = "INSERT INTO Customers (Customer_ID, "
                + "Customer_Name, "
                + "Address,"
                + "PhoneNumber,"
                + "Email,"
                + "Password"
                + ",Age) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, cus.getID());
            pstmt.setString(2, cus.getName());
            pstmt.setString(3, cus.getAddress());
            pstmt.setString(4, cus.getPhoneNumber());
            pstmt.setString(5, cus.getEmail());
            pstmt.setString(6, cus.getPassword());
            pstmt.setInt(7, cus.getAge());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
        }

        return false;
    }

    public Customer GetCustomer(String id) {
        Customer cus = new Customer();
        String query = "select * from Customers where Customer_ID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cus.setID(rs.getInt("Customer_ID"));
                cus.setName(rs.getString("Customer_Name"));
                cus.setAddress(rs.getString("Address"));
                cus.setPhoneNumber(rs.getString("PhoneNumber"));
                cus.setEmail(rs.getString("Email"));
                cus.setPassword(rs.getString("Password"));
                cus.setAge(rs.getInt("Age"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return cus;
    }

    public void UpdateCustomer(Customer cus) {
        String query = "UPDATE Customers SET Customer_Name = ?, "
                + "Address= ?,"
                + "PhoneNumber=?,"
                + "Email=?,"
                + "Password=?,"
                + "Age"
                + " WHERE Customer_ID = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setString(1, cus.getName());
            pstmt.setString(2, cus.getAddress());
            pstmt.setString(3, cus.getPhoneNumber());
            pstmt.setString(4, cus.getEmail());
            pstmt.setString(5, cus.getPassword());
            pstmt.setInt(6, cus.getAge());
            pstmt.setInt(7, cus.getID());
            pstmt.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public boolean VerifyAccount(String name, String pass) {
        boolean status = false;
        Customer cus = new Customer();
        String query = "SELECT * FROM Customers WHERE Email=? AND Password=?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
                status = rs.next();
//                     cus.setID(rs.getInt("Customer_ID"));
//                cus.setName(rs.getString("Customer_Name"));
//                cus.setAddress(rs.getString("Address"));
//                cus.setPhoneNumber(rs.getString("PhoneNumber"));
//                cus.setEmail(rs.getString("Email"));
//                cus.setPassword(rs.getString("Password"));
//                cus.setAge(rs.getInt("Age"));

//            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return status;
    }
}
