<%@page import="java.util.*"%>
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
	<%
		//往域中放入一个list
		List l=new ArrayList();
		l.add(11);
		l.add(22);
		l.add(33);
		request.setAttribute("list", l);
		//往域中放入一个set
		Set s=new HashSet();
		s.add(11);
		s.add(22);
		s.add(33);
		request.setAttribute("set", s);
		//往域中放入一个map
		Map m=new HashMap();
		m.put("username","tom");
		m.put("age", 18);
		request.setAttribute("map", m);
		
	%>
	<c:forEach items="${list }" var="n">
		${n }
	</c:forEach>
	<hr>
	<c:forEach items="${set }" var="n" varStatus="vs">
		${n }==${vs.count }
	</c:forEach>
	<hr>
	<c:forEach items="${map }" var="n">
		${n.key }--${n.value }
	</c:forEach>
</body>
</html>