<%@page import="com.ydh.utils.UUIDUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑商品</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/editProduct" method="post">
		<!-- 将商品的id提交过去 -->
		<input type="hidden" name="pid" value="${bean.pid }">
		<table border="1" align="center" width="40%">
			<tr>
				<td>商品名称</td>
				<td><input type="text" name="pname" value="${bean.pname }"></td>
			</tr>
			<tr>
				<td>市场价</td>
				<td><input type="text" name="market_price" value="${bean.market_price }"></td>
			</tr>
			<tr>
				<td>商城价</td>
				<td><input type="text" name="shop_price" value="${bean.shop_price }"></td>
			</tr>
			<tr>
				<td>商品描述</td>
				<td><input type="text" name="pdesc" value="${bean.pdesc }"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="保存"></td>
			</tr>
		</table>
	</form>
</body>
</html>