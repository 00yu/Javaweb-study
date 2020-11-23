<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>销毁session</title>
</head>
<body>
	<%session.invalidate(); %>
	session已销毁
</body>
</html>