<%--
  Created by IntelliJ IDEA.
  User: 张铭传
  Date: 2019/5/13
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>产品分类</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="style/adminStyle.css" rel="stylesheet" type="text/css"/>
    <style type="text/css">
        td {
            text-align: center;
        }
    </style>
    <script src="js/jquery.js"></script>
</head>
<body>
<div class="wrap">
    <div class="page-title">
        <span class="modular fl"><i></i><em>路线分类</em></span>
        <span class="modular fr"><a href="admin/add_category.jsp" class="pt-link-btn">+添加新分类</a></span>
    </div>
    <c:if test="${not empty msg}">
        <script type="text/javascript">
            alert(${msg});
        </script>
    </c:if>
    <table class="list-style" align="center">
        <tr>
            <th>分类ID</th>
            <th>分类名称</th>
            <th>操作</th>
        </tr>
        <c:if test="${empty cateList}">
            <td>暂无数据</td>
        </c:if>
        <c:forEach items="${cateList}" var="c">
            <tr>
                <td>
                    <span>${c.cid}</span>
                </td>
                <td class="center">
                    <span>${c.cname}</span>
                </td>
                <td class="center">
                    <a class="center" title="移除" href="javascript:;" onclick="del_cate(${c.cid})">
                        <img src="images/icon_trash.gif"/>
                    </a>
                    <a class="center" title="修改"
                       href="/TravelProject/adminCategoryServlet?method=getCategoryByCid&cid=${c.cid}">
                        <img src="images/icon_edit.gif"/>
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>


</div>
</body>
<script type="text/javascript">
    function del_cate(cid) {
        $.ajax({
            url: "/TravelProject/adminCategoryServlet?method=delCategoryByCid&cid=" + cid,
            data: {},
            type: "POST",
            success: function (data) {
                window.location.reload();
                alert(data);
            },
            error: function () {
                console.log("route_category.jsp:  del_cate()")
            }
        })
    }
</script>
</html>