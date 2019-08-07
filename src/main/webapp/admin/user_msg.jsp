<%--
  Created by IntelliJ IDEA.
  User: 张铭传
  Date: 2019/5/15
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>用户详情</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="style/adminStyle.css" rel="stylesheet" type="text/css"/>
    <style type="text/css">
        td {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="wrap">
    <dl class="orderDetail">
        <dt class="order-h">用户详情</dt>
        <dd>
            <ul>
                <li>
                    <span class="h-cont h-right">用户ID：</span>
                    <span class="h-cont h-left">${user.uid}</span>
                </li>
                <li>
                    <span class="h-cont h-right">用户姓名：</span>
                    <span class="h-cont h-left">${user.name}</span>
                </li>
                <li>
                    <span class="h-cont h-right">用户账号：</span>
                    <span class="h-cont h-left">${user.username}</span>
                </li>
                <li>
                    <span class="h-cont h-right">用户密码：</span>
                    <span class="h-cont h-left">**********************</span>
                </li>
                <li>
                    <span class="h-cont h-right">性别：</span>
                    <span class="h-cont h-left">${user.sex}</span>
                </li>
                <li>
                    <span class="h-cont h-right">联系电话：</span>
                    <span class="h-cont h-left">${user.telephone}</span>
                </li>
                <li>
                    <span class="h-cont h-right">用户邮箱：</span>
                    <span class="h-cont h-left">${user.email}</span>
                </li>
                <li>
                    <span class="h-cont h-right">出生日期：</span>
                    <span class="h-cont h-left">${user.birthday}</span>
                </li>
                <li>
                    <span class="h-cont h-right">激活状态：</span>
                    <span class="h-cont h-left">
                        <c:if test="${user.status==1}">已激活</c:if>
                        <c:if test="${user.status==0}">未激活</c:if>
                    </span>
                </li>
                <li>
                    <span class="h-cont h-right">激活码：</span>
                    <span class="h-cont h-left">${user.code}</span>
                </li>
            </ul>
        </dd>
        <dd style="padding:1em 0;">
            <p align="center">Ta的收藏</p>
            <c:if test="${empty routeList}">
                <p style="text-align: center;font-size: x-large;color: #0055aa">该用户还未收藏路线！</p>
            </c:if>
            <c:if test="${not empty routeList}">
                <table class="list-style">
                    <tr>
                        <th>缩略图</th>
                        <th>路线名称</th>
                        <th>路线分类编号</th>
                        <th>总收藏次数</th>
                        <th>商城价</th>
                    </tr>

                    <c:forEach items="${routeList}" var="r">
                        <tr>
                            <td><img src="${r.rimage}" class="thumbnail"/></td>
                            <td>${r.rname}</td>
                            <td>${r.cid}</td>
                            <td>${r.count}</td>
                            <td>
                                   <span>
                                    <i>￥</i>
                                    <em>${r.price}</em>
                                   </span>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
        </dd>
    </dl>
</div>
</body>
</html>