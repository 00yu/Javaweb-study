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
		function btnClick() {
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
				if(xmlhttp.readyState==4 && xmlhttp.status==200){
					alert(xmlhttp.responseText);
				}
			}
			//3.open操作
			xmlhttp.open("get","/day15/ajax2?username=张三");
			//4.send操作
			xmlhttp.send();
		}
	</script>
</html>