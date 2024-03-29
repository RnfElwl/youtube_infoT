/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.0.17
 * Generated at: 2022-03-20 15:55:45 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import java.sql.*;
import DBPKG.Util;

public final class salary_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("java.sql");
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("DBPKG.Util");
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
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

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
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

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


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
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body style=\"margin:0; padding:0;\">\r\n");
      out.write("	");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\r\n");
      out.write("	\r\n");
      out.write("	<section style=\"position:fixed; top:60px; width:100%; height:100%; background-color:lightgray \">\r\n");
      out.write("	 <h2 style=\"text-align:center\">회원매출조회</h2><br>\r\n");
      out.write("	 \r\n");
      out.write("	 <form style=\"display:flex; justify-content: center; align-items: center \">\r\n");
      out.write("	 <table border=\"1\">\r\n");
      out.write("	 <tr>\r\n");
      out.write("	 	<td>회원번호</td>\r\n");
      out.write("	 	<td>회원성명</td>\r\n");
      out.write("	 	<td>고객등급</td>\r\n");
      out.write("	 	<td>매출</td>\r\n");
      out.write("	 </tr>\r\n");
      out.write("	 ");

	 Connection conn = null;
	 Statement stmt = null;
	 String grade = "";
	 
	 try{
		 conn = Util.getConnection();
		 stmt = conn.createStatement();
		 String sql = "select me.custno, me.custname, me.grade, sum(mo.price) price " +
		 	"from member_tbl_02 me, money_tbl_02 mo " +
		 	"where me.custno = mo.custno " +
		 	"group by me.custno, me.custname, me.grade " +
		 	"order by sum(mo.price) desc " ;
		 ResultSet rs = stmt.executeQuery(sql);
		 while(rs.next()){
			 grade = rs.getString("grade");
			 switch(grade){
			 case "A":
				 grade = "VIP";
				 break;
			 case "B":
				 grade = "일반";
				 break;
			 case "C":
				 grade = "직원";
				 break;
			 }


      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("	<td>");
      out.print( rs.getString("custno") );
      out.write("</td>\r\n");
      out.write("	<td>");
      out.print( rs.getString("custname") );
      out.write("</td>\r\n");
      out.write("	<td>");
      out.print( grade );
      out.write("</td>\r\n");
      out.write("	<td>");
      out.print( rs.getString("price") );
      out.write("</td>\r\n");
      out.write("\r\n");
      out.write("</tr>\r\n");
 
	 }
	 	
}
	 
catch(Exception e){
	e.printStackTrace();
}

      out.write("\r\n");
      out.write("	 </table>\r\n");
      out.write("	 \r\n");
      out.write("	 </form>\r\n");
      out.write("	</section>\r\n");
      out.write("	");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
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
