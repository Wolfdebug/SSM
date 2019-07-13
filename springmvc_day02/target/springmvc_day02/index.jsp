<%--
  Created by IntelliJ IDEA.
  User: randolf
  Date: 2019/7/10
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajax</title>

</head>
<body>
    <h2>Ajaxj数据传输测试</h2>
    <button id="btn">发送Ajax请求</button><br>
    <a href="testAttr.jsp">ModelAttribute Test</a><br>
    <a href="fileUpload1.jsp">FileUpload1 Test</a><br>
    <a href="fileUpload2.jsp">FileUpload2 Test</a><br>
    <a href="fileUpload3.jsp">FileUpload3 Test</a><br>


    <script src="js/jquery-3.0.0.min.js"></script>
    <script >
        //发送一个ajax请求
        $(function(){
            var data = JSON.stringify({"uname":"zs","upwd":"123"});
            $("#btn").click(function () {
                $.ajax({
                    url:"resp/testAjax",
                    data:data,
                    contentType:'application/json;charset=utf-8' ,
                    type:'POST',
                    dataType:'JSON',
                    success:function (data) { //服务器返回的json数据
                        console.log(data.uname+":"+data.upwd);
                    }
                });
            });
        });

    </script>

</body>
</html>
