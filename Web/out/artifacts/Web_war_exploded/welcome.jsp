<%--
  Created by IntelliJ IDEA.
  User: jason
  Date: 2020/5/12
  Time: 2:29 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>welcome back</h1>
    欢迎回来 <%=session.getAttribute("username")%>
    <a href="/logout">退出登录</a>
</body>
</html>
