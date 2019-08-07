<%--
  Created by IntelliJ IDEA.
  User: 张铭传
  Date: 2019/5/13
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>路线列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="style/adminStyle.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="wrap">
    <div class="page-title">
        <span class="modular fl"><i class="add"></i><em>编辑路线</em></span>
        <span class="modular fr"><a
                href="/TravelProject/adminRouteServlet?method=getRouteListBySearch_textWithPage&search_text=${search_text}&pageNow=1"
                class="pt-link-btn">路线列表</a></span>
    </div>
    <form action="/TravelProject/adminRouteServlet?method=submitRouteMsg" method="post">
        <table class="list-style">
            <tr>
                <td style="text-align:right;width:15%;">路线ID：</td>
                <td><input type="text" readonly class="textBox length-long" name="rid"
                           style="border: none;outline: none;" value="${routeMsg.route.rid}"/></td>
            </tr>
            <tr>
                <td style="text-align:right;width:25%;">路线名称：</td>
                <td><input type="text" style="width: 70%" class="textBox length-long" name="rname"
                           value="${routeMsg.route.rname}"/></td>
            </tr>
            <tr>
                <td style="text-align:right;">路线分类：</td>
                <td>
                    <select class="textBox" name="cname">
                        <c:forEach items="${cateList}" var="c">
                            <c:if test="${c.cname == routeMsg.category.cname}">
                                <option selected value="${c.cid}">${c.cname}</option>
                            </c:if>
                            <c:if test="${c.cname != routeMsg.category.cname}">
                                <option>${c.cname}</option>
                            </c:if>
                        </c:forEach>
                        <script type="text/javascript">
                        </script>
                    </select>
                </td>
            </tr>
            <tr>
                <td style="text-align:right;">价格：</td>
                <td>
                    <input type="text" class="textBox length-short" name="price" value="${routeMsg.route.price}"/>
                    <span>元</span>
                </td>
            </tr>
            <tr>
                <td style="text-align:right;">上架日期：</td>
                <td><input type="datetime-local" class="textBox length-long" name="rdate"
                           value="${routeMsg.route.rdate}"/></td>
            </tr>
            <tr>
                <td style="text-align:right;">是否是在售：</td>
                <td>
                    <c:if test="${routeMsg.route.rflag == 1}">
                        <input type="checkbox" name="rflag" value="1" id="" checked/>
                    </c:if>
                    <c:if test="${routeMsg.route.rflag == 0}">
                        <input type="checkbox" value="0" name="rflag" id=""/>
                    </c:if>
                </td>
            </tr>
            <tr>
                <td style="text-align:right;">是否是主题游：</td>
                <td>
                    <c:if test="${routeMsg.route.isthemetour == 1}">
                        <input type="checkbox" name="tour" id="" checked/>
                    </c:if>
                    <c:if test="${routeMsg.route.isthemetour == 0}">
                        <input type="checkbox" name="tour" id=""/>
                    </c:if>
                </td>
            </tr>

            <tr>
                <td style="text-align:right;">路线小图：</td>
                <td>
                    <%--<img src="${routeMsg.route.rimage}" width="240" height="240" class="mlr5"/>--%>
                    <c:forEach items="${routeMsg.routeImg}" var="img">
                        <img src="${img.smallpic}" width="100" height="100"/>
                    </c:forEach>
                </td>
            </tr>

            <tr>
                <td style="text-align:right;">路线大图</td>
                <td>
                    <c:forEach items="${routeMsg.routeImg}" var="img">
                        <img src="${img.bigpic}" width="160" height="160"/>
                    </c:forEach>
                </td>
            </tr>

            <tr>
                <td style="text-align:right;">路线详情：</td>
                <td><textarea class="textarea" name="routeintroduce">${routeMsg.route.routeintroduce}</textarea></td>
            </tr>
            <tr>
                <td style="text-align:right;"></td>
                <td><input type="submit" value="提交" class="tdBtn"/></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>