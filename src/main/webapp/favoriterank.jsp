<%--
  Created by IntelliJ IDEA.
  User: 张铭传
  Date: 2019/4/25
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="utf-8">
    <title>收藏排行榜</title>
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" type="text/css" href="css/ranking-list.css">
    <script src="js/jquery-3.3.1.js"></script>
</head>
<body>
<!--引入头部-->
<%@include file="header.jsp" %>
<div class="contant">
    <div class="shaixuan">
        <span>线路名称</span>
        <input type="text" id="rname">
        <span>金额</span>
        <input type="text" id="min_price">~<input type="text" id="max_price">
        <button type="button" onclick="getRouteListCountByRnameAndPrice()">搜索</button>
    </div>
    <div class="list clearfix">
        <ul id="write_route">

        </ul>
    </div>
    <div class="pageNum">
        <ul>
            <li><a href="">首页</a></li>
            <li class="threeword"><a href="#">上一页</a></li>
            <li><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li>
            <li><a href="#">6</a></li>
            <li><a href="#">7</a></li>
            <li><a href="#">8</a></li>
            <li><a href="#">9</a></li>
            <li><a href="#">10</a></li>
            <li class="threeword"><a href="javascript:;">下一页</a></li>
            <li class="threeword"><a href="javascript:;">末页</a></li>
        </ul>
    </div>
</div>

<!--导入底部-->
<%@ include file="footer.jsp" %>
<!--导入布局js，共享header和footer-->
<script type="text/javascript" src="js/include.js"></script>
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript">
    function getRouteListCountByRnameAndPrice() {
        $.ajax({
            url: "routeServlet?method=getRouteListCountByRnameAndPrice",
            type: "POST",
            dataType: "json",
            data: {"rname": $('#rname').val(), "minPrice": $('#min_price').val(), "maxPrice": $('#max_price').val()},
            success: function (data) {
                $('#write_route').empty();
                $.each(data, function (i, r) {
                    var con = "<li><span class='num' id='num_" + (i + 1) + "'>" + (i + 1) + "</span><a href='routeServlet?method=getRouteByRid&rid=" + r.rid + "'>"
                        + "<img src='" + r.rimage + "' ><h4>" + r.rname + "</a></h4><p><b class='price'>&yen;<span>"
                        + r.price + "</span>起</b><span class='shouchang'>已收藏" + r.count + "次</span></p></li>";
                    $('#write_route').append(con);

                    $('#num_1').attr("class", "num one");
                    $('#num_2').attr("class", "num two");
                });
            },
            error: function (data) {
                console.log("ajax:getRouteListByRnameAndPrice()");
                console.log("favoriterank.jsp");
            }
        });
    }

    $(function () {
        getRouteListByCount();
    });

    function getRouteListByCount() {
        $.ajax({
            url: "routeServlet?method=getRouteListByCount",
            data: {},
            type: "POST",
            dataType: "json",
            success: function (data) {
                console.log("成功");
                $('#write_route').empty();
                $.each(data, function (i, r) {
                    var con = "<li><span class='num' id='num_" + (i + 1) + "'>" + (i + 1) + "</span><a href='routeServlet?method=getRouteByRid&rid=" + r.rid + "'>"
                        + "<img src='" + r.rimage + "' ><h4>" + r.rname + "</a></h4><p><b class='price'>&yen;<span>"
                        + r.price + "</span>起</b><span class='shouchang'>已收藏" + r.count + "次</span></p></li>";
                    $('#write_route').append(con);

                    $('#num_1').attr("class", "num one");
                    $('#num_2').attr("class", "num two");
                });

            },
            error: function (data) {
                console.log("ajax:getRouteListByCount()")
            }
        });
    }
</script>
</body>
</html>
