<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input type="button" value="点我" onclick="btnClick()">
</body>
<script type="text/javascript">
	function btnClick(){
		//1.创建核心对象
		xmlhttp=null;
		if (window.XMLHttpRequest)
		  {// code for Firefox, Opera, IE7, etc.
		  xmlhttp=new XMLHttpRequest();
		  }
		else if (window.ActiveXObject)
		  {// code for IE6, IE5
		  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		  }
		//2.编写回调函数
		xmlhttp.onreadystatechange=function(){
			//alert(xmlhttp.readyState);
			if(xmlhttp.readyState==4 && xmlhttp.status==200){
				//alert("ok");
				//接收服务器回送过来的数据
				alert(xmlhttp.responseText);
			}
		}
		//3.open 设置请求的方式和请求的路径
		xmlhttp.open("get","${pageContext.request.contextPath}/ajax1");
		//4.send 发送请求
		xmlhttp.send();

	}
</script>
</html>