<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="DBPKG.Util"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="margin:0; padding:0;">
	<jsp:include page="header.jsp"/>
	
	<section style="position:fixed; top:60px; width:100%; height:100%; background-color:lightgray ">
	 <h2 style="text-align:center">회원목록조회/수정</h2><br>
	 
	 <form style="display:flex; justify-content: center; align-items: center ">
	 <table border="1">
	 
	 <tr>
	 	<td>회원번호</td>
	 	<td>회원성명</td>
	 	<td>전화번호</td>
	 	<td> 주소  </td>
	 	<td>가입일자</td>
	 	<td>고객등급</td>
	 	<td>거주지역</td>
	 </tr>
	 <%
	 Connection conn = null;
	 Statement stmt = null;
	 String grade = "";
	 
	 try{
		conn = Util.getConnection();
		stmt = conn.createStatement();
		String sql = "select * from member_tbl_02 order by custno" ;
		ResultSet rs = stmt.executeQuery(sql) ;
		
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
	 
	 
	 
	 %>
	 
	 <tr>
	 	<td><%= rs.getString("custno") %></td>
	 	<td><%= rs.getString("custname") %></td>
	 	<td><%= rs.getString("phone") %></td>
	 	<td><%= rs.getString("address") %></td>
	 	<td><%= rs.getString("joindate") %></td>
	 	<td><%= grade %></td>
	 	<td><%= rs.getString("city") %></td>
	 </tr>
	 <%
	 	}
	 }
	 
	 catch(Exception e){
		 e.printStackTrace();
	 }
	 %>
	 </table>
	 </form>
	 
	</section>
	<jsp:include page="footer.jsp"/>
</body>
</html>