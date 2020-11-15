<%--
  Created by IntelliJ IDEA.
  User: pain_
  Date: 2020/11/15
  Time: 3:41 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询结果</title>
</head>
<body>

<form action="/user/updateUser" method="post">
    <input type="hidden" name="userid" value="${userid}"><br/>
    用户名：<input type="text" name="username" value="${u.username}"><br/>
    年龄：<input type="text" name="userage" value="${u.userage}"><br/>
    <input type="submit" value="ok">
    <a href="/user/del?userid=${u.userid}" >删除</a>
</form>
</body>
</html>
