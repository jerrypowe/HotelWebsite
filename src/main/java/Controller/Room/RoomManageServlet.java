/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Room;

import DAO.RoomDAO;
import Model.Room_manage;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author HP
 */
public class RoomManageServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RoomManageServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RoomManageServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RoomDAO DAO = new RoomDAO();
        List<Room_manage> list = DAO.GetAll();
        if (list != null) {
            request.setAttribute("dataRoom", list);
            request.getRequestDispatcher("roomManageAdmin.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/RoomManageServlet");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String roomCode = request.getParameter("roomCode");
        boolean available = request.getParameter("avai_" + roomCode) != null;
        boolean booked = request.getParameter("booked_" + roomCode) != null;
        boolean occupied = request.getParameter("occup_" + roomCode) != null;
        RoomDAO DAO = new RoomDAO();

        if (available) {
            DAO.UpdateCustomer("Available", roomCode);
            response.sendRedirect(request.getContextPath() + "/RoomManageServlet");
        } else if (booked) {
            DAO.UpdateCustomer("Booked", roomCode);
            response.sendRedirect(request.getContextPath() + "/RoomManageServlet");
        } else if (occupied) {
            DAO.UpdateCustomer("Occupied", roomCode);
            response.sendRedirect(request.getContextPath() + "/RoomManageServlet");
        }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
