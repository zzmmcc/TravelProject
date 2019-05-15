<%--
  Created by IntelliJ IDEA.
  User: 张铭传
  Date: 2019/5/14
  Time: 9:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" isELIgnored="false"  %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>新增商家信息</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="style/adminStyle.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="wrap">
    <div class="page-title">
        <span class="modular fl"><i></i><em>新增商家信息</em></span>
    </div>

    <table class="list-style">
        <tr>
            <td style="text-align:right;width:15%;">商家名称：</td>
            <td>
                <input type="text" class="textBox" id="sname" style="width: 180px" />
            </td>
        </tr>
        <tr>
            <td style="text-align:right;width:15%;">联系方式：</td>
            <td>
                <input type="text" class="textBox" style="width: 180px" id="consphone" />
            </td>
        </tr>
        <tr>
            <td style="text-align:right;width:15%;">所在地址：</td>
            <td>
                <input type="text" class="textBox" style="width: 180px"  id="address"/>
            </td>
        </tr>

        <tr>
            <td style="text-align:right;"></td>
            <td><input type="submit" value="保存" onclick="add_seller()" class="tdBtn"/></td>
        </tr>
    </table>
</div>
</body>
<script src="js/jquery.js"></script>
<script type="text/javascript">
    function add_seller() {
        if($('#sname').val()==null || $('#sname').val() == ""){
            alert("商家名称不能为空！");
        }else {
            $.ajax({
                url:"/TravelProject/adminSellerServlet?method=addSellerBySeller",
                data:{"sname":$('#sname').val(),"consphone":$('#consphone').val(),"address":$('#address').val()},
                type:"POST",
                success:function (data) {
                    if(data==0){
                        alert("新增商家失败！");
                    }else {
                        window.location.href="/TravelProject/adminSellerServlet?method=getSellerList";
                    }
                },
                error:function (data) {
                    console.log("add_seller.jsp : add_seller()");
                }
            });
        }

    }
</script>
</html>