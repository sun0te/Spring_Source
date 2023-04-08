<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.mysite.springmybatis.*"%>
<%
List<MemberVO> memberList = (ArrayList<MemberVO>)request.getAttribute("memberList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mybatis 실습</title>
	<script language="javascript">
		function res()
		{
			location.href="list";
		}
		
		function updateForm(id)
		{
			location.href="updateForm?id=" + id;
		}
		
		function del(id)
		{
			location.href="delete?id=" + id;
		}
	</script>
</head>
<body>
<form  method="post" action="insert">
	<table border="1" align="center">
		<tr>
			<td>아이디</td>
			<td>이름</td>
			<td>이메일</td>
			<td>전화번호</td>
			<td align="center">
				<input type="button" value="리스트" onclick="res()"></td>
		</tr>
 		<tr>
			<td><input type="text" name="id" id="id"></td>
			<td><input type="text" name="name" id="name"></td>
			<td><input type="text" name="email" id="email"></td>
			<td><input type="text" name="phone" id="phone"></td>
			<td align="center"><input type="submit" value="추가"></td>
		</tr>
		<%
			if (memberList != null) {
				for (int i=0; i<memberList.size(); i++)
				{
					MemberVO member = memberList.get(i);
		%>
				<tr>
					<td><%=member.getId() %></td>
					<td><%=member.getName() %></td>
					<td><%=member.getEmail() %></td>
					<td><%=member.getPhone() %></td>
					<td><input type="button" value="수정" 
					onclick="updateForm('<%=member.getId() %>')">
						<input type="button" value="삭제" onclick="del('<%=member.getId() %>')">
					</td>
				</tr>
		<%
				}
			}
		%>
	</table>
</form>
</body>
</html>