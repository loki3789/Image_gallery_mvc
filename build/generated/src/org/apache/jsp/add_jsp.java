package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class add_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write(" <head>\n");
      out.write("  <title>Webslesson Tutorial | Upload File without using Form Submit in Ajax PHP</title>\n");
      out.write("  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js\"></script>\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\" />\n");
      out.write("  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n");
      out.write(" </head>\n");
      out.write(" <body>\n");
      out.write("  <br /><br />\n");
      out.write("  <div class=\"container\" style=\"width:700px;\">\n");
      out.write("   <h2 align=\"center\">Upload File without using Form Submit in Ajax PHP</h2>\n");
      out.write("   <br />\n");
      out.write("   <label>Select Image</label>\n");
      out.write("   <input type=\"file\" name=\"file\" id=\"file\" />\n");
      out.write("   <br />\n");
      out.write("   <span id=\"uploaded_image\"></span>\n");
      out.write("  </div>\n");
      out.write(" </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("$(document).ready(function(){\n");
      out.write(" $(document).on('change', '#file', function(){\n");
      out.write("  var name = document.getElementById(\"file\").files[0].name;\n");
      out.write("  var form_data = new FormData();\n");
      out.write("  var ext = name.split('.').pop().toLowerCase();\n");
      out.write("  if(jQuery.inArray(ext, ['gif','png','jpg','jpeg']) == -1) \n");
      out.write("  {\n");
      out.write("   alert(\"Invalid Image File\");\n");
      out.write("  }\n");
      out.write("  var oFReader = new FileReader();\n");
      out.write("  oFReader.readAsDataURL(document.getElementById(\"file\").files[0]);\n");
      out.write("  var f = document.getElementById(\"file\").files[0];\n");
      out.write("  var fsize = f.size||f.fileSize;\n");
      out.write("  if(fsize > 2000000)\n");
      out.write("  {\n");
      out.write("   alert(\"Image File Size is very big\");\n");
      out.write("  }\n");
      out.write("  else\n");
      out.write("  {\n");
      out.write("   form_data.append(\"file\", document.getElementById('file').files[0]);\n");
      out.write("   $.ajax({\n");
      out.write("    url:\"upload.php\",\n");
      out.write("    method:\"POST\",\n");
      out.write("    data: form_data,\n");
      out.write("    contentType: false,\n");
      out.write("    cache: false,\n");
      out.write("    processData: false,\n");
      out.write("    beforeSend:function(){\n");
      out.write("     $('#uploaded_image').html(\"<label class='text-success'>Image Uploading...</label>\");\n");
      out.write("    },   \n");
      out.write("    success:function(data)\n");
      out.write("    {\n");
      out.write("     $('#uploaded_image').html(data);\n");
      out.write("    }\n");
      out.write("   });\n");
      out.write("  }\n");
      out.write(" });\n");
      out.write("});\n");
      out.write("</script>");
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
