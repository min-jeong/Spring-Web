/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.32
 * Generated at: 2016-04-21 04:08:07 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.common;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<!-- Javascript Libraries -->\r\n");
      out.write("<script src=\"resource/js/jquery-2.1.1.min.js\"></script>\r\n");
      out.write("<script src=\"resource/js/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script src=\"resource/vendors/nicescroll/jquery.nicescroll.min.js\"></script>\r\n");
      out.write("<script src=\"resource/vendors/bootstrap-growl/bootstrap-growl.min.js\"></script>\r\n");
      out.write("<script src=\"resource/vendors/sweet-alert/sweet-alert.min.js\"></script>\r\n");
      out.write("<script src=\"resource/vendors/waves/waves.min.js\"></script>\r\n");
      out.write("<script src=\"resource/vendors/sweet-alert/sweet-alert.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script src=\"resource/js/functions.js\"></script>\r\n");
      out.write("<script src=\"resource/js/demo.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(document).ready( function() {\r\n");
      out.write("\tfunction notify(from, align, message, icon, type, animIn, animOut){\r\n");
      out.write("\t    $.growl({\r\n");
      out.write("\t        icon: icon,\r\n");
      out.write("\t        title: '',\r\n");
      out.write("\t        message: message,\r\n");
      out.write("\t        url: ''\r\n");
      out.write("\t    },{\r\n");
      out.write("\t            element: 'body',\r\n");
      out.write("\t            type: type,\r\n");
      out.write("\t            allow_dismiss: true,\r\n");
      out.write("\t            placement: {\r\n");
      out.write("\t                    from: from,\r\n");
      out.write("\t                    align: align\r\n");
      out.write("\t            },\r\n");
      out.write("\t            offset: {\r\n");
      out.write("\t                x: 20,\r\n");
      out.write("\t                y: 85\r\n");
      out.write("\t            },\r\n");
      out.write("\t            spacing: 10,\r\n");
      out.write("\t            z_index: 1031,\r\n");
      out.write("\t            delay: 2500,\r\n");
      out.write("\t            timer: 1000,\r\n");
      out.write("\t            url_target: '_blank',\r\n");
      out.write("\t            mouse_over: false,\r\n");
      out.write("\t            animate: {\r\n");
      out.write("\t                    enter: animIn,\r\n");
      out.write("\t                    exit: animOut\r\n");
      out.write("\t            },\r\n");
      out.write("\t            icon_type: 'class',\r\n");
      out.write("\t            template: '<div data-growl=\"container\" class=\"alert\" role=\"alert\">' +\r\n");
      out.write("\t                            '<button type=\"button\" class=\"close\" data-growl=\"dismiss\">' +\r\n");
      out.write("\t                                '<span aria-hidden=\"true\">&times;</span>' +\r\n");
      out.write("\t                                '<span class=\"sr-only\">Close</span>' +\r\n");
      out.write("\t                            '</button>' +\r\n");
      out.write("\t                            '<span data-growl=\"icon\"></span>' +\r\n");
      out.write("\t                            '<span data-growl=\"title\"></span>' +\r\n");
      out.write("\t                            '<span data-growl=\"message\"></span>' +\r\n");
      out.write("\t                            '<a href=\"#\" data-growl=\"url\"></a>' +\r\n");
      out.write("\t                        '</div>'\r\n");
      out.write("\t    });\r\n");
      out.write("\t};\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t$(\"#doLogin\").click(function(e){\r\n");
      out.write(" \t\tvar userId = $(\"#userId\").val();\r\n");
      out.write(" \t\tvar password = $(\"#password\").val();\r\n");
      out.write("\t\t$.post(\r\n");
      out.write("\t\t\t\t\"/doLogin\"\r\n");
      out.write("\t\t\t\t, { \"userId\" : userId,\r\n");
      out.write("\t\t\t\t\t\"password\" : password }\r\n");
      out.write("\t\t\t\t, function(data) {\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\ttry{\r\n");
      out.write("\t\t\t\t\t\tjsonData3 = JSON.parse(data);\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\tcatch(e) { //자바스크립트는 타입이 없기때문에 e만 적으면 된다.\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\tif (jsonData3.isLoginSuccess) { // 로그인 성공했으면\r\n");
      out.write("\t\t\t\t\t\tlocation.href=\"/goMain\"; \r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\telse { // 로그인에 실패했을 경우\r\n");
      out.write("\t\t\t\t\t    notify('top', 'center', 'Check your ID and Password', 'fa fa-comments', 'inverse', 'animated fadeInDown', 'animated fadeOutDown'); \r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t  }\r\n");
      out.write("\t\t);\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\tvar jsonData3 = {};\r\n");
      out.write("\t$(\"#forgotPw\").click(function(e){\r\n");
      out.write("\t\tvar emailId = $(\"#emailId\").val();\r\n");
      out.write("\t\t$.post(\r\n");
      out.write("\t\t\t\t\"/forgotEmail\"\t\r\n");
      out.write("\t\t\t\t,{ \"emailId\" : emailId }\r\n");
      out.write("\t\t\t\t, function(data) {\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\ttry{\r\n");
      out.write("\t\t\t\t\t\tjsonData3 = JSON.parse(data);\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\tcatch(e) { //자바스크립트는 타입이 없기때문에 e만 적으면 된다.\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\tif (jsonData3.forgotPw) {\r\n");
      out.write("\t\t\t\t\t\t swal(\"Confirm Email\");\r\n");
      out.write("\t\t\t\t\t\t /* location.href=\"/goLogin\"; */\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\tif( !jsonData3.forgotPw )\r\n");
      out.write("\t\t\t\t\t    notify('top','center', 'Check your Email ID', 'fa fa-comments', 'inverse', 'animated fadeInDown', 'animated fadeOutDown');\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t);\r\n");
      out.write("\t});\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("        \r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<title>PingPong Chat</title>\r\n");
      out.write("\r\n");
      out.write("<!-- Vendor CSS -->\r\n");
      out.write("<link href=\"resource/vendors/animate-css/animate.min.css\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"resource/vendors/sweet-alert/sweet-alert.min.css\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"resource/vendors/material-icons/material-design-iconic-font.min.css\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"resource/vendors/socicon/socicon.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    \r\n");
      out.write("<!-- CSS -->\r\n");
      out.write("<link href=\"resource/css/app.min.1.css\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"resource/css/app.min.2.css\" rel=\"stylesheet\">\r\n");
      out.write("</head>\r\n");
      out.write("    <body class=\"login-content\">\r\n");
      out.write("        <!-- Login -->\r\n");
      out.write("        <div class=\"lc-block toggled\" id=\"l-login\">\r\n");
      out.write("            <div class=\"input-group m-b-20\">\r\n");
      out.write("                <span class=\"input-group-addon\"><i class=\"md md-person\"></i></span>\r\n");
      out.write("                <div class=\"fg-line\">\r\n");
      out.write("                    <input type=\"text\" class=\"form-control\" placeholder=\"Email ID\" id=\"userId\">\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("            <div class=\"input-group m-b-20\">\r\n");
      out.write("                <span class=\"input-group-addon\"><i class=\"md md-lock\"></i></span>\r\n");
      out.write("                <div class=\"fg-line\">\r\n");
      out.write("                    <input type=\"password\" class=\"form-control\" placeholder=\"Password\" id=\"password\">\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("            <!-- 비밀번호찾기 만들기 -->\r\n");
      out.write("            <div class=\"clearfix\"></div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("            <button class=\"btn btn-login btn-float\" style=\"background-color: #71d1b2;\" id=\"doLogin\"><i class=\"md md-arrow-forward\"></i></button>\r\n");
      out.write("            \r\n");
      out.write("            <ul class=\"login-navigation\">\r\n");
      out.write("                <li data-block=\"#l-forget-password\" class=\"bgm-orange\">Forgot Password?</li>\r\n");
      out.write("            </ul>\r\n");
      out.write("            \r\n");
      out.write("             <!-- Forgot Password -->\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("        <div class=\"lc-block\" id=\"l-forget-password\">\r\n");
      out.write("            <p class=\"text-left\">Email ID</p>\r\n");
      out.write("            \r\n");
      out.write("            <div class=\"input-group m-b-20\">\r\n");
      out.write("                <span class=\"input-group-addon\"><i class=\"md md-email\"></i></span>\r\n");
      out.write("                <div class=\"fg-line\">\r\n");
      out.write("                    <input type=\"text\" class=\"form-control\" placeholder=\"Email Address\" id=\"emailId\">\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("            <button class=\"btn btn-login btn-float\" style=\"background-color: #71d1b2;\" id=\"forgotPw\"><i class=\"md md-arrow-forward\"></i></button>\r\n");
      out.write("            \r\n");
      out.write("            <ul class=\"login-navigation\">\r\n");
      out.write("                <li data-block=\"#l-login\" class=\"bgm-green\">Login</li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}