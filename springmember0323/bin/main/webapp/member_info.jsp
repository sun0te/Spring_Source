<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%@ page import="com.mysite.springmember0323.MemberVO" %>

<%
	if((session.getAttribute("id")==null) ||
		(!((String)session.getAttribute("id")).equals("admin"))){
		out.println("<script>");
		out.println("location.href='loginForm.jsp");
		out.println("</script>");
	}
	
	MemberVO vo = (MemberVO)request.getAttribute("memberVO");

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리 시스템 관리자모드(회원 정보 보기)</title>
</head>
<body>
<center>

<table border = 1  width = 300>
	<tr align = center>
		<td>아이디 : </td><td><%= vo.getId() %></td>
	</tr>
	<tr align = center>
		<td>비밀번호 : </td><td> ${memberVO.getPassword()}</td>
	</tr>
	<tr align = center>
		<td>이름 : </td><td><%=vo.getName() %></td>
	</tr>
	<tr align = center>
		<td>나이 : </td><td><%=vo.getAge() %></td>
	</tr>
	<tr align = center>
		<td>성별 : </td><td><%=vo.getGender() %></td>
	</tr>
	<tr align = center>
		<td>이메일 주소 : </td><td><%=vo.getEmail() %></td>
	</tr>
	<tr align = center>
		<td colspan = "2">
			<a href="memberlist.me">리스트로 돌아가기</a>
		</td>
	</tr>
</table>

</center>
</body>
</html>