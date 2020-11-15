<%--
  Created by IntelliJ IDEA.
  User: pain_
  Date: 2020/11/15
  Time: 2:17 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <titl>查询结果</titl>
</head>
<body>
<form action="/user/findUserById" method="post">
    用户id：<input type="text" name="userid"><br/>
    <input type="submit" value="ok">
</form>
</body>
</html>
