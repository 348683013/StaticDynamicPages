<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8"/>
</head>
<body>
<h1 align="center">列表</h1>
<table border="1" align="center" width="50%">
    <tr>
        <th>姓名</th>
        <th>年龄</th>
        <th>账号</th>
        <th>密码</th>
    </tr>
    <jsp:useBean id="userList" scope="request" type="java.util.List"/>
    <c:forEach items="${userList}" var="user">
        <tr style="text-align: center;">
            <td>${user.name}</td>
            <td>${user.age}</td>
            <td>${user.account}</td>
            <td>${user.password}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>