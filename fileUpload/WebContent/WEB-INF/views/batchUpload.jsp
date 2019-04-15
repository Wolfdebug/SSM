<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
    <script src="${pageContext.request.contextPath }/js/jquery-2.1.0.min.js" type="text/javascript"></script>
</head>
<body>
    <form action="batchUpload.do" method="post" enctype="multipart/form-data">
    	file:<input type="file" name="file"/>
    	<input id="add" type="button" value="添加"> 
    	<input type="submit" value="上传"/>
    	<div id="fileList"></div>
    </form>
 </body>
 
 <script type="text/javascript">

	 $("#add").click(function(){
	 		var field = "<p>选择文件：<input type='file' name='file'/><input type='button' value='删除 '  onclick='del(this);' /></p>"; 
	 		$("#fileList").append(field);
	 	});
	 function del(obj){
		 $(obj).parent().remove();
	 };
	 
 </script>
</html>