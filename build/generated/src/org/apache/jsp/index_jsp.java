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
      out.write("<!DOCTYPE HTML>\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width\" />\n");
      out.write("        <title>Eatatouille</title>\n");
      out.write("\t<!--Custom CSS-->\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/custom.css\">\n");
      out.write("\t<!--Bootstrap CSS-->\n");
      out.write("\t<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css\">\n");
      out.write("\t<!-- Custom Fonts -->\n");
      out.write("\t<link href='http://fonts.googleapis.com/css?family=Lobster' rel='stylesheet' type='text/css'>\n");
      out.write("    </head>\n");
      out.write("\t\n");
      out.write("    <body class=\"backImg\">\n");
      out.write("\t\n");
      out.write("        <div class='container'>\n");
      out.write("            <div class=\"row vertical-center\">\n");
      out.write("                <div class='col-xs-12'>\n");
      out.write("                    <center>\n");
      out.write("                        <h1 style=\"font-family: 'Lobster', cursive; font-size:400%;color:#ffffff\">Eatatouille</h1>\n");
      out.write("                    </center>\n");
      out.write("                    <br />\n");
      out.write("                    <center>\n");
      out.write("                    <div class=\"panel panel-default nav nav-tabs loginPage\" role=\"tablist\">\n");
      out.write("                        <div class=\"panel-heading\">\n");
      out.write("                            <ul class=\"nav nav-tabs\" role=\"tablist\">\n");
      out.write("                                <li role=\"presentation\" class=\"active\"><a href=\"#login\" aria-controls=\"login\" role=\"tab\" data-toggle=\"tab\">Log in</a></li>\n");
      out.write("                                <li role=\"presentation\"><a href=\"#signup\" aria-controls=\"student\" role=\"tab\" data-toggle=\"tab\">Registration</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"panel-body tab-content\">\n");
      out.write("                            <div role=\"tabpanel\" class=\"tab-pane active\" id=\"login\">\n");
      out.write("                                <form method=\"post\" action=\"UserDetails\" class='formWidth'>\n");
      out.write("                                    <input type=\"hidden\" name=\"task\" value=\"login\" />\n");
      out.write("                                    <input type=\"hidden\" name=\"type\" value=\"direct\" />\n");
      out.write("                                    <p style=\"color:red;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${loginErr}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("                                    <input type=\"text\" class=\"form-control\" placeholder=\"Email\" name=\"email\" />\n");
      out.write("                                    <br />\n");
      out.write("                                    <input type=\"password\" class=\"form-control\" placeholder=\"Password\" name=\"password\" />\n");
      out.write("                                    <br />\n");
      out.write("                                    <input type=\"submit\" class=\"btn btn-lg btn-success\" value=\"Login\"/>\n");
      out.write("                                </form>\n");
      out.write("                            </div>\n");
      out.write("                            <div role=\"tabpanel\" class=\"tab-pane\" id=\"signup\">\n");
      out.write("                                <form method=\"post\" action=\"UserDetails\" class='formWidth'>\n");
      out.write("                                    <input type=\"hidden\" name=\"task\" value=\"signup\" />\n");
      out.write("                                    <input type=\"hidden\" name=\"type\" value=\"direct\" />\n");
      out.write("                                    <p style=\"color:red;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${registerErr}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("                                    <input type=\"text\" name=\"fName\" placeholder=\"First Name\" class=\"form-control\" />\n");
      out.write("                                    <br />\n");
      out.write("                                    <input type=\"text\" name=\"lName\" placeholder=\"Last Name\" class=\"form-control\" />\n");
      out.write("                                    <br />\n");
      out.write("                                    <input type=\"email\" name=\"email\" placeholder=\"Email\" class=\"form-control\" />\n");
      out.write("                                    <br />\n");
      out.write("                                    <input type=\"password\" name=\"password\" placeholder=\"Password\" class=\"form-control\" />\n");
      out.write("                                    <br />\n");
      out.write("                                    <input type=\"password\" name=\"cPassword\" placeholder=\"Confirm Password\" class=\"form-control\" />\n");
      out.write("                                    <br />\n");
      out.write("                                    <input type=\"submit\" class=\"btn btn-lg btn-success\" value=\"Sign up\" class=\"form-control\" />\n");
      out.write("                                </form>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    </center>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\t\n");
      out.write("\t<!--jQuery-->\n");
      out.write("\t<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js\"></script>\n");
      out.write("\t<!--Bootstrap CSS-->\n");
      out.write("\t<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js\"></script>\n");
      out.write("        <!--Custom script-->\n");
      out.write("        <script>\n");
      out.write("           \n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("\n");
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
