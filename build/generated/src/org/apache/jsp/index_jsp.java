package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Airline Reservation System</title>\n");
      out.write("        <style>\n");
      out.write("            body {\n");
      out.write("                background-image: url(\"Airplae2.jpg\");\n");
      out.write("                background-repeat: no-repeat;\n");
      out.write("                background-position: center; \n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    <font color=\"black\" size=\"8\"><u>Airline Reservation System</u></font><br><br><br>\n");
      out.write("    <table border=\"0\" align=\"left\" cellspacing=\"20\">\n");
      out.write("        <tr>\n");
      out.write("            <td>\n");
      out.write("                <form action=\"Search.jsp\" method=\"get\">\n");
      out.write("                     <input name=\"Search\" type=\"submit\" value=\"Search Flights\" style=\"width: 150px; height: 60px;background: #F2E527;border-radius: 15px; color: blue\">\n");
      out.write("                 </form>\n");
      out.write("            </td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("            <td>\n");
      out.write("                <form action=\"Seats.jsp\" method=\"get\">\n");
      out.write("                    <center>\n");
      out.write("                        <input name=\"Seats\" type=\"submit\" value=\"Seat Availability\" style=\"width: 150px; height: 60px;background: #F2E527; border-radius: 15px; color: blue\">\n");
      out.write("                    </center>\n");
      out.write("                </form>\n");
      out.write("            </td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("            <td>\n");
      out.write("                <form action=\"Fare.jsp\" method=\"get\">\n");
      out.write("                    <center>\n");
      out.write("                        <input name=\"Fare\" type=\"submit\" value=\"Fare Information\" style=\"width: 150px; height: 60px;background: #F2E527; border-radius: 15px; color: blue\">\n");
      out.write("                    </center>\n");
      out.write("                </form>\n");
      out.write("            </td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("            <td>\n");
      out.write("                <form action=\"Passenger.jsp\" method=\"get\">\n");
      out.write("                    <center>\n");
      out.write("                        <input name=\"Passenger\" type=\"submit\" value=\"Passenger Information\" style=\"width: 150px; height: 60px;background: #F2E527; border-radius: 15px; color: blue\">\n");
      out.write("                    </center>\n");
      out.write("                </form>\n");
      out.write("            </td>\n");
      out.write("        </tr>\n");
      out.write("    </table>\n");
      out.write("   </body>\n");
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
