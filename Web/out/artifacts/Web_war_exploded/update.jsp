<%--
  Created by IntelliJ IDEA.
  student: jason
  Date: 2020/5/13
  Time: 8:07 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/student?method=update" method="post">
    编号：<input name="id" type="text" value="${student.id}" readonly><br>
    姓名：<input name="name" type="text" value="${student.name}"><br>
    成绩：<input name="score" type="text" value="${student.score}"><br>
    <input type="submit" value="更新">
</form>
</body>
</html>
