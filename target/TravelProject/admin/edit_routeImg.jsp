<%--
  Created by IntelliJ IDEA.
  User: 张铭传
  Date: 2019/5/13
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" isELIgnored="false"  %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>编辑图片</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="style/adminStyle.css" rel="stylesheet" type="text/css" />
    <script src="js/jquery.js"></script>
    <%--<script src="http://malsup.github.com/jquery.form.js"></script>--%>
    <script src="admin/js/jquery.form.js"></script>
</head>
<body>
<div class="wrap">
    <div class="page-title">
        <span class="modular fl"><i class="add"></i><em>编辑图片</em></span>
        <span class="modular fr"><a href="/TravelProject/adminRouteServlet?method=getRouteListBySearch_textWithPage&search_text=${search_text}&pageNow=1" class="pt-link-btn">路线列表</a></span>
    </div>

        <table class="list-style">
            <tr>
                <td style="text-align:right;width:15%;">路线ID：</td>
                <td><input type="text" readonly class="textBox length-long"  name="rid" style="border: none;outline: none;" value="${routeMsg.route.rid}"/></td>
            </tr>
            <tr>
                <td style="text-align:right;width:25%;">路线名称：</td>
                <td><input type="text" style="width: 70%;border: none;outline: none;" readonly class="textBox length-long" name="rname" value="${routeMsg.route.rname}" /></td>
            </tr>
            <form action="/TravelProject/adminRouteServlet?method=upPic&rid=${routeMsg.route.rid}"   enctype="multipart/form-data" method="post">
                <tr>
                    <td style="text-align:right;">路线小图：</td>
                    <td>
                        <input type="file"  id="smallPic" name="smallPic" class="hide" />
                        <label for="smallPic" class="labelBtn2">本地上传(最多选择1张)</label>
                        <%--<img src="${routeMsg.route.rimage}" width="240" height="240" class="mlr5"/>--%>
                        <c:forEach items="${routeMsg.routeImg}" var="img">
                            <img src="${img.smallpic}" width="100" height="100"/>
                        </c:forEach>
                    </td>
                </tr>
                <tr>
                    <td style="text-align:right;">路线大图</td>
                    <td>
                        <input type="file" id="bigPic" name="bigPic" class="hide"/>
                        <label for="bigPic" class="labelBtn2">本地上传(最多选择1张)</label>
                        <c:forEach items="${routeMsg.routeImg}" var="img">
                            <img src="${img.bigpic}" width="160" height="160"/>
                        </c:forEach>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="right">
                    <input type="submit" value="提交" class="tdBtn"/>
                    </td>
                </tr>
            </form>
        </table>

</div>

</body>
</html>