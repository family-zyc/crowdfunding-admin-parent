<%--
  Created by IntelliJ IDEA.
  User: Yuchao
  Date: 2021/11/25
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>index</title>
    <base href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/" />
    <script type="text/javascript" src="jquery/jquery-2.1.1.min.js" ></script>
    <script type="text/javascript" src="layer/layer.js"></script>
    <script type="text/javascript">

        $(function () {

            var admin = {
                "id":1,
                "loginAcct":"zyc",
                "userPswd":"123",
                "userName":"123",
                "email":"123@",
                "createTime":"123"
            };

            $("#btn1").click(function () {
                $.ajax({
                    "url":"send/array",
                    "type":"post",
                    "data":admin,
                    "dataType":"text",
                    "success":function (data) {
                        alert(data);
                    },
                    "error":function (data) {
                        alert(data);
                    }
                });
            });
            
            
            $("#btn2").click(function () {
                layer.msg("hello layer");
            });
            
        });

    </script>
</head>
<body>
    this is index.jsp
    <a href="test/ssm" >测试ssm</a><br>
    <button id="btn1">点击</button><br>
    <button id="btn2">layer</button><br>
</body>
</html>
