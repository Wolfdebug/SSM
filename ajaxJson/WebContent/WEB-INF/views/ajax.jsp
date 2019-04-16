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
	姓名：<input type="text" id="field" name="name" /><span id="txt"></span>
	<script type="text/javascript">
		$("#field").blur(function(){
			$.post("ajax.do",{'name':$('#field').val()},function(result){
				$("#txt").html(result);
			});
		});
	</script>
</body>
</html>