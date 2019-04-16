<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <script src="${pageContext.request.contextPath }/js/jquery-2.1.0.min.js" type="text/javascript"></script>

</head>
<body>
	<input type="button" id="btn" value="获取json数据">
	<table  width="80%" align="center">
		<tr>
			<th>编号</th>
			<th>姓名</th>
			<th>密码</th>
		</tr>
		<tbody id="content"></tbody>
	</table>
	<script type="text/javascript">
	$(function(){
		$("#btn").click(function(){
			$.get("ajaxJson.do",function(list){
				var field = "";
				for (var i = 0; i < list.length; i++) {
					field +="<tr><td>"+list[i].id+"</td>"+"<td>"+list[i].name+"</td>"+"<td>"+list[i].passwd+"</td></tr>";
				}
				$("#content").html(field);
			});
		});
	});
	</script>
</body>
</html>