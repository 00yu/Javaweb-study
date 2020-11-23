<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/day1701/upload2" method="post" enctype="multipart/form-data">
		用户名：<input name="username"><br>
		文件：<input type="file" name="f"><br>
		<input type="submit">
	</form>
</body>
</html>