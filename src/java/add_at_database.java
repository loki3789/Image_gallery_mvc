/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.io.*;

/**
 *
 * @author lokesh
 */
public class add_at_database extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String image_name=request.getParameter("image_name");
            String image_path=request.getParameter("path");
            Connection con=null;
            ResultSet rs=null;
            PreparedStatement psmt=null;
            FileInputStream fis;
            String url="jdbc:mysql://localhost:3306/jspdb";

            try{

                    Class.forName("com.mysql.jdbc.Driver").newInstance();

                    con=DriverManager.getConnection(url,"root","root");

                    File image1=new File(image_path);

                    psmt=con.prepareStatement("insert into imagetable(image,image_name)"+"values(?,?)");
                    fis=new FileInputStream(image1);

                    psmt.setBinaryStream(1, (InputStream)fis, (int)(image1.length()));

                    psmt.setString(2,image_name);

                    int s = psmt.executeUpdate();

                    if(s>0) {
                        out.println("<font color=\"Blue\">");
                        out.println("Image added successfully !");
                        out.println("</font>");
                        out.println("<a href=\"index.jsp\"><h1>Click here to go Adminpage</h1></a>");
                    }

                    else {
                        out.println("unsuccessfull to add image");
                    }
                    con.close();
                    psmt.close();

}
catch(Exception ex){
    out.println("Error in connection : "+ex);
}
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
        processRequest(request, response);
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
        processRequest(request, response);
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
