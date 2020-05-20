<%--
  Created by IntelliJ IDEA.
  student: jason
  Date: 2020/5/12
  Time: 12:01 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>用户信息</title>
  </head>
  <body>
  <table>
    <tr>
      <th>编号</th>
      <th>姓名</th>
      <th>成绩</th>
    </tr>
    <c:forEach items="${list}" var="student">
      <tr>
        <td>${student.id}</td>
        <td>${student.name}</td>
        <td>${student.score}</td>
        <td><a href="/student?method=findById&id=${student.id}">修改</a></td>
        <td><a href="/student?method=delete&id=${student.id}">删除</a></td>
      </tr>
      </c:forEach>
  </table>
  <a href="/add.jsp" name="新增">新增</a>
  </body>
</html>
