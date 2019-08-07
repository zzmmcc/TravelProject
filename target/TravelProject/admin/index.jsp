<%--
  Created by IntelliJ IDEA.
  User: 张铭传
  Date: 2019/5/13
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <frameset rows="76,*" framespacing="0" border="0">
        <frame src="top.jsp" id="header-frame" name="header-frame" frameborder="no" scrolling="no">
        <frameset cols="180, 10, *" framespacing="0" border="0" id="frame-body">
            <frame src="menu.jsp" frameborder="no" scrolling="yes">
            <frame src="bar.jsp" frameborder="no" scrolling="no">
            <frame src="main.jsp" name="mainCont" frameborder="no" scrolling="yes">
        </frameset>
    </frameset>
    <noframes></noframes>
</head>
<body>
</body>
</html>