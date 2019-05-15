<%--
  Created by IntelliJ IDEA.
  User: 张铭传
  Date: 2019/5/15
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" isELIgnored="false"  %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>用户列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="style/adminStyle.css" rel="stylesheet" type="text/css" />
    <script src="js/jquery.js"></script>
    <script src="js/public.js"></script>
</head>
<body>
<div class="wrap">
    <div class="page-title">
        <span class="modular fl"><i class="user"></i><em>用户列表</em></span>
    </div>
    <div class="operate">
        <form action="${pageContext.request.contextPath}/adminUserServlet?method=getUserListBySearch_textWithPage&pageNow=1" method="post">
            <input id="search_text" name="search_text" class="textBox length-long" placeholder="输入用户姓名" value="${search_text}"/>
            <input type="submit" value="查询" class="tdBtn"/>
        </form>
    </div>
    <table class="list-style Interlaced">
        <tr>
            <th>编号</th>
            <th>用户账号</th>
            <th>用户真实姓名</th>
            <th>联系方式</th>
            <th>用户邮箱</th>
            <th>是否激活</th>
            <th>性别</th>
            <th>生日</th>
            <th>查看详细信息</th>
        </tr>
        <c:forEach items="${pageList.list}" var="u">
            <tr>
                <td align="center">
                    <span class="middle">${u.uid}</span>
                </td>
                <td class="center">${u.username}</td>
                <td class="center">${u.name}</td>
                <td class="center">${u.telephone}</td>
                <td class="center">${u.email}</td>
                <td class="center">
                    <c:if test="${u.status==1}">
                        <img src="images/yes.gif"/></td>
                    </c:if>
                    <c:if test="${u.status==0}">
                        <img src="images/no.gif"/></td>
                    </c:if>
                <td class="center">${u.sex}</td>
                <td class="center">${u.birthday}</td>
                <td class="center">
                    <a href="${pageContext.request.contextPath}/adminUserServlet?method=getUserMsgsByUid&uid=${u.uid}" class="inline-block" title="查看用户信息"><img src="admin/images/icon_view.gif"/></a>
                </td>
            </tr>
        </c:forEach>

    </table>
    <!-- BatchOperation -->
    <div style="overflow:hidden;">
        <!-- Operation -->
        <!-- turn page -->
        <div class="turnPage center fr">
            共${pageList.pageCount}条数据/总计${pageList.getPageAll()}页
            <a href="/TravelProject/adminUserServlet?method=getUserListBySearch_textWithPage&search_text=${search_text}&pageNow=1">首页</a>
            <a href="/TravelProject/adminUserServlet?method=getUserListBySearch_textWithPage&search_text=${search_text}&pageNow=${pageList.getUpPage()}">上一页</a>
            <a style="background-color: white;color: #0f0f0f" href="javascript:;">当前页${pageList.getPageNow()}</a>
            <a href="/TravelProject/adminUserServlet?method=getUserListBySearch_textWithPage&search_text=${search_text}&pageNow=${pageList.getDownPage()}">下一页</a>
            <a href="/TravelProject/adminUserServlet?method=getUserListBySearch_textWithPage&search_text=${search_text}&pageNow=${pageList.getLastIndex()}">尾页</a>
        </div>
    </div>
</div>
</body>
</html>
