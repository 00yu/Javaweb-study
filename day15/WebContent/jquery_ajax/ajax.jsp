<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.0.min.js"></script>
<title>Insert title here</title>
</head>
<script type="text/javascript">
	$(function(){
		$("#btn").click(function(){
			var url="/day15/jqueryAjax";
			//var params="username=张三";  get请求(乱码)
			//var params={"username":"张三"};  post请求(不会乱码)
			//load方式
			/* $(this).load(url,params,function(d){
				alert(d);
			}); */
			//get方式
			/* var params={"username":"张三"};
			$.get(url,params,function(d){
				alert(d);
			}) */
			//post方式
			/* var params={"username":"张三"};
			$.post(url,params,function(d){
				alert(d.msg);
			},"json");  */
			var params={"username":"张三"};
			//ajax方式
			$.ajax({
				url:url,
				type:"post",
				data:params,
				success:function(d){
					alert(d.msg);
				},
				error:function(){},
				dataType:"json"
			})
		});
	})
</script>
<body>
	<input type="button" value="点我" id="btn">
</body>
</html>