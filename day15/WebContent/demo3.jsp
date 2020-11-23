<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
	$(function(){
		//文本框keyup的时候发送ajax
		$("#tid").keyup(function(){
			//获取文本框的值
			$value=$(this).val();
			//内容为空的时候不发送ajax
			if ($value!=null && $value!="") {
				$("#did").html("");
				$.post("/day15/searchKw","kw="+$value,function(d){
					if(d!=''){
						var arr=d.split(",");
						$(arr).each(function(){
							//将每一个值放入id为did中 可以将每一个值放入一个div中 并将其插入到id为did的div中
							$("#did").append($("<div>"+this+"</div>"));
						})
						//将div显示
						$("#did").show();
					}
				});
			} else {
				//将div隐藏
				$("#did").hide();
			}
		})
	})
</script>
<title>Insert title here</title>
</head>
<body>
	<center>
		<div>
			<h1>百度搜索</h1>
			<div>
				<input name="kw" id="tid"><input type="submit" value="百度一下">
			</div>
			<div id="did" style="border: 1px solid red;width: 171px;position:relative;left:-35px;display: none"></div>
		</div>
	</center>
</body>
</html>