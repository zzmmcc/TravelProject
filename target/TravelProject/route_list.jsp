<%@ page import="com.zz.util.PageUtil" %>
<%@ page import="com.zz.bean.Route" %><%--
  Created by IntelliJ IDEA.
  User: 张铭传
  Date: 2019/4/25
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" isELIgnored="false"  %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>小码旅游-搜索</title>
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" href="css/search.css">
    <link rel="stylesheet" href="css/cypager.min.css" />
    <script src="js/jquery-3.3.1.js"></script>
    <style type="text/css">
    </style>
</head>
<script type="text/javascript" src="js/cypager.min.js"/>
<script src="js/jquery-1.11.0.min.js"></script>
<body>
<!--引入头部-->
<%@include file="header.jsp"%>
<div class="page_one">
    <div class="contant">
        <div class="crumbs">
            <img src="images/search.png" alt="">
            <input type="hidden" id="cid" value="${routeList[0].cid}">
            <p>小码旅行><span>搜索结果</span></p>
        </div>
        <div class="xinxi clearfix">
            <div class="left">
                <div class="header">
                    <span>商品信息</span>
                    <span class="jg">价格</span>
                </div>
                <ul>
                    <c:forEach items="${pageList.list}" var="r">
                        <li>
                            <div class="img"><img src="${r.rimage}" alt=""></div>
                            <div class="text1">
                                <p>${r.rname}</p>
                                <br/>
                                <p>${r.routeintroduce}</p>
                            </div>
                            <div class="price">
                                <p class="price_num">
                                    <span>&yen;</span>
                                    <span>${r.price}</span>
                                    <span>起</span>
                                </p>
                                <p><a href="routeServlet?method=getRouteByRid&rid=${r.rid}">查看详情</a></p>
                            </div>
                        </li>
                    </c:forEach>
                </ul>

                <div class="page_num_inf">
                    <i></i> 共
                    <span>12</span>页<span>132</span>条
                </div>



                <div>
                            <h3>调用方式</h3>
                            <p>由于是 jquery 插件，所以在引人 cypager.min.js 之前，要引人 jquery.min.js 本人使用的是 1.7.2 版本的，低版本的没试过。</p>
                            <pre>
                引入css : &lt;link rel="stylesheet" href="css/cypager.min.css" /&gt;
                引人js  : &lt;script type="text/javascript" src="js/cypager.min.js"/&gt;
                </pre>
                            <pre>
                $(function(){
                    $("#pagerArea").cypager({pg_size:10,pg_nav_count:8,pg_total_count:194,pg_call_fun:function(count){
                        alert("跳转至页面:"+count+"");
                    }});
                });
                </pre>
                            <h3>参数说明</h3>
                            <pre>
                 pgerId						//插件的ID 默认 : cy_pager
                 pg_size  					//每页显示记录数 默认：10条
                 pg_cur_count 					//当前页数（如果需要默认显示指定页面，则设置）
                 pg_total_count 			//总记录数
                 pg_nav_count     			//显示多少个导航数  默认：7个
                 pg_prev_name     			//上一页按钮名称（默认：PREV）
                 pg_next_name     			//下一页按钮名称 (默认：NEXT)
                 pg_call_fun(page_count)      //回调函数，点击按钮执行
                </pre>
                            <p>
                                经过本人测试，插件兼容 IE8+,Chrome,Firefox 浏览器,核心文件仅 5KB 。
                            </p>

                            <div id="pagerArea" unselectable="on" onselectstart="return false;" style="-moz-user-select:none;"></div>
                            </br>
                            </br>
                            <div id="console" style='padding-left:10px'></div>

        <script type="text/javascript" src="js/cypager.min.js" ></script>
        <script>
        $(function(){
            $("#pagerArea").cypager({pg_size:10,pg_nav_count:8,pg_total_count:194,pg_call_fun:function(count){
                    $("#console").html("正在加载第("+count+")页的数据，请稍后.......");
                }});
        });
        </script>

                </div>



                <div class="pageNum">
                    <ul>
                        <li><a href="">首页</a></li>
                        <li class="threeword"><a href="#">上一页</a></li>
                        共${pageList.pageAll}页
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
            <div class="right">
                <div class="top">
                    <div class="hot">HOT</div>
                    <span>热门推荐</span>
                </div>
                <ul id ="write_hotsTravel">

                </ul>
            </div>
        </div>
    </div>
</div>

<!--引入头部-->
<%@ include file="footer.jsp"%>
<script src="/js/pagination.js"></script>
<!--导入布局js，共享header和footer-->
<script type="text/javascript" src="js/include.js"></script>
<script SRC="js/jquery-3.3.1.js"></script>
<script type="text/javascript">
$(function () {
    getHotsRouteListByCid();
})
    function getHotsRouteListByCid() {
        $.ajax({
            url:"routeServlet?method=getHotsRouteListByCid&cid="+$('#cid').val(),
            type:"POST",
            dataType:"json",
            success:function (data) {
                $('#write_hotsTravel').empty();
                $.each(data,function (i, r) {
                    var con = "<li ><a href='routeServlet?method=getRouteByRid&rid="+r.rid+"'><div class='left'><img src='"+r.rimage+"' alt=''></div>"
                             +"<div class='right'><p style='font-size: 10px' >"+r.rname+"</p><p>" + "网付价<span>+"
                             +"&yen;<span style='font-size: 10px'>"+r.price+"</span>起</span></p></div></a></li>";
                    $('#write_hotsTravel').append(con);
                })
            },
            error:function (data) {
                console.log("ajax：getHotsRouteListByCid()")
            }
        })
    }

</script>
</body>
</html>
