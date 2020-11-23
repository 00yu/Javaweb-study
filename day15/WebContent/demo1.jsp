<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="#" method="post">
	<table>
		<tr>
			<td>用户名：</td>
			<td><input type="text" name="username" onblur="checkUsername(this)"></td>
			<td><span id="username_msg"></span></td>
		</tr>
		<tr>
			<td>密码：</td>
			<td><input type="text" name="password"></td>
		</tr>
		<tr>
			<td colspan="3"><input type="submit" id="sub"></td>
		</tr>
	</table>
	</form>
</body>
<script type="text/javascript">
	function checkUsername(obj){
		//失去焦点 发送ajax
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
				if(xmlhttp.responseText==1){
					document.getElementById("username_msg").innerHTML="<font color='green'>用户名可以使用</font>";
				}else{
					document.getElementById("username_msg").innerHTML="<font color='red'>用户名已被占用</font>";
					document.getElementById("sub").disabled=true;
				}
			}
		}
		//3.open操作
		xmlhttp.open("get","${pageContext.request.contextPath}/checkUsername4Ajax?username="+obj.value);
		//4.send操作
		xmlhttp.send();
	}
</script>
</html>