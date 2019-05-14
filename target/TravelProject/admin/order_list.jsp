<%--
  Created by IntelliJ IDEA.
  User: 张铭传
  Date: 2019/5/14
  Time: 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    </div>
    <div class="operate">
        <form>
            <img src="images/icon_search.gif"/>
            <input type="text" class="textBox length-long" placeholder="输入商家名称..."/>
            <input type="button" value="查询" class="tdBtn"/>
        </form>
    </div>
    <table class="list-style Interlaced">
        <tr>
            <th>商家ID</th>
            <th>商家名称</th>
            <th>商家电话</th>
            <th>商家地址</th>
            <th>操作</th>
        </tr>
        <tr>
            <td>
                <input type="checkbox"/>
                <a href="order_detail.html">1</a>
            </td>
            <td class="center">
                <span class="block">xmcc</span>
            </td>
            <td class="center">
                <span>15730</span>
            </td>
            <td width="450">
                <address style="text-align: center">陕西省西安市未央区255号</address>
            </td>
            <td class="center">
                <a href="order_detail.html" class="inline-block" title="查看订单"><img src="images/icon_view.gif"/></a>
                <a class="inline-block" title="删除订单"><img src="images/icon_trash.gif"/></a>
            </td>
        </tr>
    </table>
    <!-- BatchOperation -->
    <div style="overflow:hidden;">
        <!-- Operation -->
        <div class="BatchOperation fl">
            <input type="checkbox" id="del"/>
            <label for="del" class="btnStyle middle">全选</label>
            <input type="button" value="打印订单" class="btnStyle"/>
            <input type="button" value="配货" class="btnStyle"/>
            <input type="button" value="删除订单" class="btnStyle"/>
        </div>
        <!-- turn page -->
        <div class="turnPage center fr">
            <a>第一页</a>
            <a>1</a>
            <a>最后一页</a>
        </div>
    </div>
</div>
</body>
</html>