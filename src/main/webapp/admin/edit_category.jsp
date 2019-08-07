<%--
  Created by IntelliJ IDEA.
  User: 张铭传
  Date: 2019/5/14
  Time: 9:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>修改分类信息</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="style/adminStyle.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="wrap">
    <div class="page-title">
        <span class="modular fl"><i></i><em>修改分类信息</em></span>
    </div>

    <table class="list-style">
        <tr>
            <td style="text-align:right;width:15%;">分类ID：</td>
            <td>
                <input type="text" class="textBox" id="cid" readonly style="border: none;outline: none"
                       value="${category.cid}"/>
            </td>
        </tr>
        <tr>
            <td style="text-align:right;width:15%;">分类名称：</td>
            <td>
                <input type="text" class="textBox" id="cname" value="${category.cname}"/>
            </td>
        </tr>

        <tr>
            <td style="text-align:right;"></td>
            <td><input type="submit" value="保存" onclick="edit_cate()" class="tdBtn"/></td>
        </tr>
    </table>
</div>
</body>
<script src="js/jquery.js"></script>
<script type="text/javascript">
    function edit_cate() {
        if ($('#cname').val() == null || $('#cname').val() == "") {
            alert("分类名称不能为空！");
        } else {
            $.ajax({
                url: "/TravelProject/adminCategoryServlet?method=editCategoryByCate",
                data: {"cid": $('#cid').val(), "cname": $('#cname').val()},
                type: "POST",
                success: function (data) {
                    if (data == 0) {
                        alert("修改分类失败！");
                    } else {
                        window.location.href = "/TravelProject/adminCategoryServlet?method=getCategoryBySort";
                    }
                },
                error: function (data) {
                    console.log("edit_category.jsp:edit_cate()");
                }
            });
        }

    }
</script>
</html>