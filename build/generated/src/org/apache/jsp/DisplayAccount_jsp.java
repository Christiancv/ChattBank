package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.PrintWriter;
import ChattBank.Account;

public final class DisplayAccount_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("         <meta charse=\"ISO-8859-1\">\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        ");

            Account acct = (Account)session.getAttribute("ac");
            System.out.println("Testing Account information ...");
            //System.out.println(acct.getAccNo());
            System.out.println(acct.getCid());
            System.out.println(acct.getType());
            System.out.println(acct.getBalance());
            
            
      out.write("\n");
      out.write("        <h1>Account Display</h1>\n");
      out.write("         <form>\n");
      out.write("            AccNo:&emsp; &emsp;\n");
      out.write("            <input type=\"text\" name=\"AccNo\"><br>\n");
      out.write("            CustomerID:&nbsp;\n");
      out.write("            <input type=\"text\" name=\"CustomerID\"><br>\n");
      out.write("            Type:&emsp; &emsp; &ensp;\n");
      out.write("            <input type=\"text\" name=\"Type\"><br>\n");
      out.write("            Balance: &emsp; &ensp;\n");
      out.write("            <input type=\"text\" name=\"Balance\"><br>\n");
      out.write("            <button type=\"submit\">Lookup</button>\n");
      out.write("            <button type=\"reset\">Clear</button>\n");
      out.write("            \n");
      out.write("\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
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
