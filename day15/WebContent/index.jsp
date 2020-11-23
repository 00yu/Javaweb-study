<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	原生的ajax<br>
	<hr>
	<a href="${pageContext.request.contextPath }/js_ajax/hello.jsp">入门程序</a><br>
	<a href="${pageContext.request.contextPath }/js_ajax/get.jsp">get请求</a><br>
	<a href="${pageContext.request.contextPath }/demo1.jsp">案例1-用户名是否占用</a><br>
	<hr>
	jquery的ajax<br>
	<hr>
	<a href="${pageContext.request.contextPath }/jquery_ajax/ajax.jsp">ajax的四种方式</a><br>
	<a href="${pageContext.request.contextPath }/demo2.jsp">案例2-用户名是否占用</a><br>
	<a href="${pageContext.request.contextPath }/demo3.jsp">案例3-模仿百度搜索</a><br>
	<a href="${pageContext.request.contextPath }/demo4.jsp">案例4-省市联动</a><br>
</body>
</html>