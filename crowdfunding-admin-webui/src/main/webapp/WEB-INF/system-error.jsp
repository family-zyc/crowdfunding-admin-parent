<%--
  Created by IntelliJ IDEA.
  User: Yuchao
  Date: 2021/11/26
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Title</title>

        <base href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/" />
        <script type="text/javascript" src="jquery/jquery-2.1.1.min.js" ></script>
        <script type="text/javascript" src="layer/layer.js"></script>
        <script type="text/javascript">
            $(function () {
                $("button").click(function () {
                    window.history.back();
                });
            });
        </script>

    </head>
    <body>
        <button>返回</button><br>
        error:${requestScope.exception.message}
    </body>
</html>
