<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	hello jsp 你好
	<% 
		int i=3;
		System.out.println(i);
	%>
	<%=i %>
	<%
		out.print("我很好");
	%>
	<%=k %>
	<%!
		int k=4;
	%>
	<%=k %>
</body>
</html>