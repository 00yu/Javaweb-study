<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2><a href="${pageContext.request.contextPath }/findAll">展示所有商品</a></h2>
	<h2><a href="${pageContext.request.contextPath }/add.jsp">添加商品</a></h2>
	<h2><a href="${pageContext.request.contextPath }/showProductsByPage?currPage=1">分页展示商品</a></h2>
</body>
</html>