<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
	$(function(){
		//给username派发一个失去焦点事件发送ajax请求
		$("input[name='username']").blur(function(){
			//获取输入的值
			var $value=$(this).val();
			$.get("/day15/checkUsername4Ajax",{"username":$value},function(d){
				if(d==1){
					$("#username_msg").html($("<font color='green'>用户名可以使用</font>"));
				}else{
					$("#username_msg").html($("<font color='red'>用户名已被占用</font>"));
				}
			})
		})
	})
</script>
<title>Insert title here</title>
</head>
<body>
	<form action="#" method="post">
	<table>
		<tr>
			<td>用户名：</td>
			<td><input type="text" name="username"></td>
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
</html>