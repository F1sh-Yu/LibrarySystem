<%--
  Created by IntelliJ IDEA.
  User: jason
  Date: 2020/5/12
  Time: 10:54 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增</title>
</head>
<body>
<form action="/student?method=add" method="post">
    编号：<input name="id" type="text"><br>
    姓名：<input name="name" type="text"><br>
    成绩：<input name="score" type="text"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
