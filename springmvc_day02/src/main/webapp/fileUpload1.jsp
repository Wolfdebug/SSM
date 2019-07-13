<%--
  Created by IntelliJ IDEA.
  User: randolf
  Date: 2019/7/11
  Time: 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>fileUpload</title>
</head>
<body>
<form action="file/fileUpload1" enctype="multipart/form-data" method="post">
    <input type="file" name="upload" />
    <input type="submit" value="提交"/>
</form>
</body>
</html>
