<%--
  Created by IntelliJ IDEA.
  User: jason
  Date: 2020/5/14
  Time: 1:08 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/upload" method="post" enctype="multipart/form-data">
<%--        <input type="text" name="text"><br>--%>
        <input type="file" name="file"><br>
        <input type="submit" value="submit">
    </form>
</body>
</html>
