<%--
  Created by IntelliJ IDEA.
  User: 张铭传
  Date: 2019/5/13
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>header</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="style/adminStyle.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="header">
    <div class="logo">
        <img src="images/admin_logo.png" title="在哪儿"/>
    </div>
    <div class="fr top-link">
        <a href="#" target="_blank" title="访问站点"><i class="shopLinkIcon"></i><span>访问站点</span></a>
        <a href="admin_list.jsp" target="mainCont" title="DeathGhost"><i
                class="adminIcon"></i><span>管理员：DeathGhost</span></a>
        <a href="#" title="修改密码"><i class="clearIcon"></i><span>清除缓存</span></a>
        <a href="revise_password.jsp" target="mainCont" title="修改密码"><i class="revisepwdIcon"></i><span>修改密码</span></a>
        <a href="/TravelProject/adminServlet?method=logout" title="安全退出" style="background:rgb(60,60,60);"
           target="mainCont"><i class="quitIcon"></i><span>安全退出</span></a>
    </div>
</div>
</body>
</html>