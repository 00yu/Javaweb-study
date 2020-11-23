<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="${pageContext.request.contextPath }/live/request.jsp">演示request的创建和销毁</a><br>
	<a href="${pageContext.request.contextPath }/live/session_destory.jsp">演示session的销毁</a><br>
	<hr>
	<a href="${pageContext.request.contextPath }/attr/attr_set.jsp">添加属性</a><br>
	<a href="${pageContext.request.contextPath }/attr/attr_replace.jsp">替换|添加属性</a><br>
	<a href="${pageContext.request.contextPath }/attr/attr_remove.jsp">删除属性</a><br>
	<hr>
	<a href="${pageContext.request.contextPath }/session/session_set.jsp">javabean绑定到session中</a><br>
	<a href="${pageContext.request.contextPath }/session/session_remove.jsp">javabean从session中解绑</a><br>
	<a href="${pageContext.request.contextPath }/session/session.getJavabean.jsp">获取javabean的名称(活化)</a><br>
	<hr>
	<a href="${pageContext.request.contextPath }/demo1">filter入门</a><br>
	<a href="${pageContext.request.contextPath }/demo2">filter生命周期</a><br>
	<a href="${pageContext.request.contextPath }/a/b/demo3">chain执行顺序</a><br>
</body>
</html>