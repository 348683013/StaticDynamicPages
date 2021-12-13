<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  User: zhouzhongzhong
  Date: 2021/12/13
  Time: 14:25
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>
<h1>链接页面</h1>
<a href="<c:url value="/UserServlet?method=findAll"/>">查询所有</a><br/>
<a href="<c:url value="/UserServlet?method=findByName&name=zhangsan"/>">查找张三</a><br/>
<a href="<c:url value="/UserServlet?method=findByName&name=lisi"/>">查找李四</a><br/>
<a href="<c:url value="/UserServlet?method=findByName&name=wangwu"/>">查找王五</a><br/>
</body>
</html>
