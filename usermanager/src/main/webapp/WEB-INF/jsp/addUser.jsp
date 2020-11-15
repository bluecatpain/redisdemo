<%--
  Created by IntelliJ IDEA.
  User: pain_
  Date: 2020/11/15
  Time: 12:13 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户</title>
</head>
<body>
<form action="/user/addUser" method="post">
        姓名：<input type="text" name="username"><br/>
        年龄：<input type="text" name="userage"><br/>
        <input type="submit" value="ok">
</form>
</body>
</html>
