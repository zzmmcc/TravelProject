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
    <title>添加图片</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="style/adminStyle.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="wrap">
    <div class="page-title">
        <span class="modular fl"><i class="add"></i><em>添加路线</em></span>
        <span class="modular fr"><a
                href="/TravelProject/adminRouteServlet?method=getRouteListBySearch_textWithPage&search_text=${search_text}&pageNow=1"
                class="pt-link-btn">路线列表</a></span>
    </div>
    <form action="/TravelProject/adminRouteServlet?method=addRouteByRoute" method="post">
        <table class="list-style">
            <tr>
                <td style="text-align:right;width:25%;">路线名称：</td>
                <td><input type="text" style="width: 70%" class="textBox length-long" name="rname"/></td>
            </tr>
            <tr>
                <td style="text-align:right;">价格：</td>
                <td>
                    <input type="text" class="textBox length-short" name="price"/>
                    <span>元</span>
                </td>
            </tr>
            <tr>
                <td style="text-align:right;">上架日期：</td>
                <td><input type="datetime-local" class="textBox length-long" name="rdate"/></td>
            </tr>
            <tr>
                <td style="text-align:right;">是否是在售：</td>
                <td>
                    <input type="checkbox" name="rflag"/>
                </td>
            </tr>
            <tr>
                <td style="text-align:right;">是否是主题游：</td>
                <td>
                    <input type="checkbox" name="tour" id=""/>
                </td>
            </tr>
            <tr>
                <td style="text-align:right;">路线分类：</td>
                <td>
                    <select class="textBox" name="cname">
                        <c:forEach items="${categoryList}" var="c">
                            <option selected value="${c.cid}">${c.cname}</option>
                        </c:forEach>
                        <script type="text/javascript">
                        </script>
                    </select>
                </td>
            </tr>
            <tr>
                <td style="text-align:right;">商家：</td>
                <td>
                    <select class="textBox" name="sid">
                        <c:forEach items="${sellerList}" var="s">
                            <option selected value="${s.sid}">${s.sname}</option>
                        </c:forEach>
                        <script type="text/javascript">
                        </script>
                    </select>
                </td>
            </tr>
            <tr>
                <td style="text-align:right;">路线详情：</td>
                <td><textarea class="textarea" name="routeintroduce"></textarea></td>
            </tr>
            <tr>
                <td style="text-align:right;">路线来源：</td>
                <td><input type="text" class="textBox length-short" name="sourceId"/></td>
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