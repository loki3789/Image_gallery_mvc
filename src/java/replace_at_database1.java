/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lokesh
 */
@WebServlet(urlPatterns = {"/replace_at_database1"})
public class replace_at_database1 extends HttpServlet {

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

            Connection con = null;
            ResultSet rs = null;
            PreparedStatement psmt = null;
            FileInputStream fis;
            String url = "jdbc:mysql://localhost:3306/jspdb";

            try {

                Class.forName("com.mysql.jdbc.Driver").newInstance();

                con = DriverManager.getConnection(url, "root", "root");

                String j;
                String image_path;
                String[] pros = request.getParameterValues("imageschecked");
                for (int i = 0; i < pros.length; i++) {
                    j = pros[i];
                    image_path = request.getParameter(j);

                    try {

                        File image1 = new File(image_path);

                        psmt = con.prepareStatement("update  imagetable set image=? where image_name='" + pros[i] + "'");

                        fis = new FileInputStream(image1);

                        psmt.setBinaryStream(1, (InputStream) fis, (int) (image1.length()));
                        int s = psmt.executeUpdate();

                        if (s > 0) {
                            out.println("<font color=\"Blue\">");
                            out.println("Image updated successfully !");
                            out.println("</font>");
                            out.println("<a href=\"index.jsp\"><h1>Click here to go Adminpage</h1></a>");

                        } else {

                            out.println("unsucessfull to upload image and add product.");

                        }
                    } catch (Exception ex) {
                        out.println("Error in connection : " + ex);
                    }
                }

            } catch (Exception ex) {
                out.println("Error in connection : " + ex);
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
