<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 接收值 -->
<jsp:useBean id="u" class="com.ydh.domain.User"></jsp:useBean>
<jsp:setProperty property="name" name="u"/>
<jsp:setProperty property="password" name="u"/>

<!-- 打印值 -->
<jsp:getProperty property="name" name="u"/>

</body>
</html>