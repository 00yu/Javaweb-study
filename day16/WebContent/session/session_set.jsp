<%@page import="com.ydh.domain.Person2"%>
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
	将Person和Person2对象添加到session中
	<%
		session.setAttribute("p", new Person(1,"tom"));
		session.setAttribute("p2", new Person2(2,"jack"));
	%>
</body>
</html>