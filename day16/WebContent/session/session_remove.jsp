<%@page import="com.ydh.domain.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	将Person对象从session中移除
	<%
		session.removeAttribute("p");
	%>
</body>
</html>