<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
	$(function(){
		//页面加载成功 查询所有的省份
		$.get("/day15/selectPro",function(d){
			var $pro=$("#proId");
			$(d).each(function(){
				$pro.append($("<option value="+this.provinceid+">"+this.name+"</option>"));
			})
		},"json");
		
		//给省份下拉选派发change事件
		$("#proId").change(function(){
			//获取省份id
			var $pid=$(this).val();
			//发送ajax请求 查询当前省下所有的市
			$.get("/day15/selectCity",{"pid":$pid},function(obj){
				var $city=$("#cityId");
				$city.html("<option>-请选择-</option>");
				if(obj!=null){
					$(obj).each(function(){
						$city.append($("<option value="+this.cityid+">"+this.name+"</option>"));
					})
				}
			},"json")
		})
	})
</script>
<title>省市联动</title>
</head>
<body>
	<select id="proId" name="province">
		<option>-省份-</option>
		<!-- <option value="1">北京</option> -->
	</select>
	<select id="cityId" name="city">
		<option>-请选择-</option>
	</select>
</body>
</html>