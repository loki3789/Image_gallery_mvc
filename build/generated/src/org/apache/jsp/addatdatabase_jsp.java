package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.io.*;

public final class addatdatabase_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Hello World!</h1>\n");
      out.write("        ");

            String product_code="C:\fakepath\Chrysanthemum.jpg";
            String product_name=request.getParameter("im");
            
           
  Connection con=null;

ResultSet rs=null;

PreparedStatement psmt=null;

FileInputStream fis;

String url="jdbc:mysql://localhost:3306/jspdb";

try{

Class.forName("com.mysql.jdbc.Driver").newInstance();

con=DriverManager.getConnection(url,"root","root");

File image1=new File(product_code);

psmt=con.prepareStatement("insert into imagetable(image,image_name)"+"values(?,?)");






fis=new FileInputStream(image1);

psmt.setBinaryStream(1, (InputStream)fis, (int)(image1.length()));

psmt.setString(2,product_name);

int s = psmt.executeUpdate();

if(s>0) {


      out.write("\n");
      out.write("\n");
      out.write("<b><font color=\"Blue\">\n");
      out.write("\n");
 out.println("Image and prodct "+ product_name +" Uploaded successfully !"); 
      out.write("\n");
      out.write("\n");
      out.write("</font></b>\n");
      out.write("\n");


}

else {

out.println("unsucessfull to upload image and add product.");

}

con.close();

psmt.close();

}catch(Exception ex){

out.println("Error in connection : "+ex);

}

      out.write("\n");
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
