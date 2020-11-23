<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/login" method="post">
		<table>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="username" value=""></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="text" name="password"></td>
			</tr>
			<tr>
				<td colspan="1"><input type="checkbox" name="autoLogin" value="ok">自动登录</td>
				<td colspan="1"><input type="checkbox" name="saveName" value="ok">记住用户名</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name=""></td>
			</tr>
		</table>
	</form>
	<script type="text/javascript">
		onload=function(){
			var s="${cookie.savename.value }";
			s=decodeURI(s);
			//将解码后的名称赋给username的文本框
			document.getElementsByName("username")[0].value=s;
		}
	</script>
</body>
</html>