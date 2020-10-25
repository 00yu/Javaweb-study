<%@page import="com.ydh.utils.UUIDUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加商品</title>
</head>
<body>
	<%
		String code=UUIDUtils.getCode();
		//将code放入session中 需要后台验证
		session.setAttribute("s_lingpai", code);
		//将code放入pageContext域中
		pageContext.setAttribute("r_code", code);
	%>
	<form action="${pageContext.request.contextPath }/addProduct" method="post">
		<input type="hidden" name="r_lingpai" value="${r_code }">
		<table border="1" align="center" width="40%">
			<tr>
				<td>商品名称</td>
				<td><input type="text" name="pname"></td>
			</tr>
			<tr>
				<td>市场价</td>
				<td><input type="text" name="market_price"></td>
			</tr>
			<tr>
				<td>商城价</td>
				<td><input type="text" name="shop_price"></td>
			</tr>
			<tr>
				<td>商品描述</td>
				<td><input type="text" name="pdesc"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="保存"></td>
			</tr>
		</table>
	</form>
</body>
</html>