package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Base64;
import com.database.Database_Controller;
import java.sql.*;
import java.io.*;

public final class replace_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write(" \n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"newcss1.css\">\n");
      out.write("\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <h2 style=\"align-content:center;background-color:black;color:white\"> Replace image</h2>\n");
      out.write("        </br>\n");
      out.write("        </br>\n");
      out.write("        <form action=\"replace_at_database1\">\n");
      out.write("            ");
try {
                Database_Controller db = new Database_Controller();
                ResultSet rs = db.get();
                while (rs.next()) {
                    Blob image = rs.getBlob("image");
                    byte[] image_array = image.getBytes(1, (int) image.length());
                    byte[] x64_image = Base64.getEncoder().encode(image_array);
                    String xstring = new String(x64_image, "UTF-8");
        
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"column\">\n");
      out.write("                    <figure>\n");
      out.write("                        <img src=\"data: image/png;base64,");
      out.print(xstring);
      out.write("\" style=\"width:100%;height: 100%\"  class=\"hover-shadow cursor\">\n");
      out.write("                        <figcaption style=\"margin-left:0%\">\n");
      out.write("                            ");
      out.print(rs.getString(3));
      out.write("\n");
      out.write("                            <input style=\"width: 50%\" type=\"text\" id=\"myFile\" size=\"50\"placeholder=\"enter path\" name=\"");
      out.print(rs.getString(3));
      out.write("\">\n");
      out.write("                            <input type=\"checkbox\" check=\"checked\"  name=\"imageschecked\" value=\"");
      out.print(rs.getString(3));
      out.write("\">\n");
      out.write("\n");
      out.write("                        </figcaption>\n");
      out.write("                    </figure>\n");
      out.write("                </div>\n");
      out.write("                ");
  }} catch (Exception ex) {
                            out.println("Unable to connect to database.");
                        }
                    }
                
      out.write("\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <input  type=\"submit\" value=\"update selected images\" style=\"margin-left:200px;\"/>\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
