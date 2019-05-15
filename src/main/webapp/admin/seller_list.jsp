<%--
  Created by IntelliJ IDEA.
  User: 张铭传
  Date: 2019/5/14
  Time: 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" isELIgnored="false"  %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>商家列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="style/adminStyle.css" rel="stylesheet" type="text/css" />
    <script src="js/jquery.js"></script>
    <script src="js/public.js"></script>
</head>
<body>
<div class="wrap">
    <div class="page-title">
        <span class="modular fl"><i class="order"></i><em>商家列表</em></span>
        <span class="modular fr"><a href="admin/add_seller.jsp" class="pt-link-btn">+添加商家</a></span>
    </div>

    <table class="list-style Interlaced">
        <tr>
            <th>商家ID</th>
            <th>商家名称</th>
            <th>商家电话</th>
            <th>商家地址</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${sellerList}" var="s">
            <tr>
                <td align="center">
                    ${s.sid}
                </td>
                <td class="center">
                    <span class="block">${s.sname}</span>
                </td>
                <td class="center">
                    <span>${s.consphone}</span>
                </td>
                <td width="450">
                    <address style="text-align: center">${s.address}</address>
                </td>
                <td class="center">
                    <a href="/TravelProject/adminSellerServlet?method=getSellerBySid&sid=${s.sid}" class="inline-block" title="修改商家信息"><img src="images/icon_edit.gif"/></a>
                    <a href="javascript:;" onclick="del_seller(${s.sid})" class="inline-block" title="删除商家"><img src="images/icon_trash.gif"/></a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <!-- BatchOperation -->
    <div style="overflow:hidden;">
        <!-- Operation -->

        <!-- turn page -->
    </div>
</div>
</body>
<script type="text/javascript">
    function del_seller(sid) {
        $.ajax({
            url:"/TravelProject/adminSellerServlet?method=delSellerBySid&sid="+sid,
            type:"POST",
            success:function (data) {
                if(data==0){
                    alert("删除失败！");
                }else {
                    window.location.reload();
                }

            },
            error:function () {
                console.log("seller_list.jsp  : del_seller()");
            }
        })
    }
</script>
</html>