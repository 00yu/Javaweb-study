<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" align="center" width="88%">
	<tr>
			<td><input type="checkbox" onclick="checkAll(this)"></td>
			<th>pid</th>
			<th>商品图片</th>
			<th>商品名称</th>
			<th>市场价</th>
			<th>商城价</th>
			<th>商品描述</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${pb.list }" var="p">
			<tr>
				<td width="1%"><input type="checkbox" name="pid" value="${p.pid }"></td>
				<td width="8%">${p.pid }</td>
				<td width="8%"><img alt="" src="${pageContext.request.contextPath }/${p.pimage }" width="80px"></td>
				<td width="8%">${p.pname }</td>
				<td width="8%">${p.market_price }</td>
				<td width="8%">${p.shop_price }</td>
				<td>${p.pdesc }</td>
			</tr>
		</c:forEach>	
	</table>
	<center>
		<!-- 若是第一页 首页和上一页不展示 -->
		<c:if test="${pb.currPage!=1 }">
		<a href="${pageContext.request.contextPath}/showProductsByPage?currPage=1">[首页]   </a>
		<a href="${pageContext.request.contextPath}/showProductsByPage?currPage=${pb.currPage-1}">[上一页] </a>
		</c:if>
		<!-- 将所有页面展示出来 -->
		<c:forEach begin="1" end="${pb.totalPage }" var="n">
			<!-- 若是当前页不可点 -->
			<c:if test="${pb.currPage == n }">
				${n }
			</c:if>
			<c:if test="${pb.currPage != n }">
			<a href="${pageContext.request.contextPath}/showProductsByPage?currPage=${n }">${n }</a>
			</c:if>
		</c:forEach>
		<!-- 若是尾页 下一页和尾页不展示 -->
		<c:if test="${pb.currPage!=pb.totalPage}">
		<a href="${pageContext.request.contextPath}/showProductsByPage?currPage=${pb.currPage+1}">[下一页] </a>
		<a href="${pageContext.request.contextPath}/showProductsByPage?currPage=${pb.totalPage}">[尾页]   </a>
		</c:if>
		第${pb.currPage }页/共${pb.totalPage }页
	</center>                                        
</body>
</html>