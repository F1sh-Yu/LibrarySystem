<%--
  Created by IntelliJ IDEA.
  User: jason
  Date: 2020/5/12
  Time: 2:21 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/login" method="post">
        <table>
            <tr>
                <td>用户名</td>
                <td><input name="username" type="text"></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td><input type="submit" name="登陆"></td>
                <td><input type="reset" name="重置"></td>
            </tr>
        </table>
    </form>
</body>
</html>
