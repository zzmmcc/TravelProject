<%--
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
    <script src="js/jquery-3.3.1.js"></script>
</head>
<script src="js/jquery-1.11.0.min.js"></script>
<body>
<!--引入头部-->
<%@include file="header.jsp"%>
<c:if test="${not empty pageList}">
<div class="page_one">
    <div class="contant">
        <div class="crumbs">
            <img src="images/search.png" alt="">
            <input type="hidden" id="cid" value="${pageList.list[0].cid}">
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
                        <span>${pageList.getPageAll()}</span>页<span>${pageList.pageCount}</span>条
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
                <div class="pageNum">
                       <ul id='writePage'>
                            <li><a href=routeServlet?method=getRouteListByCid&cid=${pageList.list[0].cid}&pageNow=1'>首页</a></li>
                            <li class="threeword"><a href='routeServlet?method=getRouteListByCid&cid=${pageList.list[0].cid}&pageNow=${pageList.getUpPage()}'>上一页</a></li>
                           <script type="text/javascript">
                               var count = ${pageList.getPageAll()};
                               for(var i=0;i<count;i++){
                                $('#writePage').append("<li><a href='routeServlet?method=getRouteListByCid&cid=${pageList.list[0].cid}&pageNow="+(i+1)+"'>"+(i+1)+"</a></li>")
                               }

                           </script>
                            <li class="threeword"><a href='routeServlet?method=getRouteListByCid&cid=${pageList.list[0].cid}&pageNow=${pageList.getDownPage()}'>下一页</a></li>
                            <li class="threeword"><a href='routeServlet?method=getRouteListByCid&cid=${pageList.list[0].cid}&pageNow=${pageList.getLastIndex()}'>末页</a></li>
                        </ul>

                </div>

            </div>

        </div>
    </div>
</div>
</c:if>
<c:if test="${not empty pageList_Search}">
    <div class="page_one">
        <div class="contant">
            <div class="crumbs">
                <img src="images/search.png" alt="">
                <p>小码旅行><span>搜索结果</span></p>
                <input type="hidden" id="search_text" value="${search_text}">
            </div>
            <div class="xinxi clearfix">
                <div class="left">
                    <div class="header">
                        <span>商品信息</span>
                        <span class="jg">价格</span>
                    </div>
                    <ul>
                        <c:forEach items="${pageList_Search.list}" var="r">
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
                        <span>${pageList_Search.getPageAll()}</span>页<span>${pageList_Search.pageCount}</span>条
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
                <div class="pageNum">
                    <ul id='writePage'>
                        <li><a href='routeServlet?method=searchRouteListByTextWithPage&searchtext=${search_text}&pageNow=1'>首页</a></li>
                        <li class="threeword"><a href='routeServlet?method=searchRouteListByTextWithPage&searchtext=${search_text}&pageNow=${pageList_Search.getUpPage()}'>上一页</a></li>
                        <script type="text/javascript">
                            var count = ${pageList_Search.getPageAll()};
                            for(var i=0;i<count;i++){
                                $('#writePage').append("<li><a href='routeServlet?method=searchRouteListByTextWithPage&searchtext=${search_text}&pageNow="+(i+1)+"'>"+(i+1)+"</a></li>")
                            }

                        </script>
                        <li class="threeword"><a href='routeServlet?method=searchRouteListByTextWithPage&searchtext=${search_text}&pageNow=${pageList_Search.getDownPage()}'>下一页</a></li>
                        <li class="threeword"><a href='routeServlet?method=searchRouteListByTextWithPage&searchtext=${search_text}&pageNow=${pageList_Search.getLastIndex()}'>末页</a></li>
                    </ul>

                </div>

            </div>

        </div>
    </div>
    </div>
</c:if>
<!--引入头部-->
<%@ include file="footer.jsp"%>
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
