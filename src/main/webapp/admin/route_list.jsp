<%--
  Created by IntelliJ IDEA.
  User: 张铭传
  Date: 2019/5/13
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" isELIgnored="false"  %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>路线列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="style/adminStyle.css" rel="stylesheet" type="text/css" />
    <script src="js/jquery.js"></script>
    <script src="js/public.js"></script>
</head>

<body>
<div class="wrap">
    <div class="page-title">
        <span class="modular fl"><i></i><em>路线列表</em></span>
        <span class="modular fr"><a href="edit_product.html" class="pt-link-btn">+添加路线</a></span>
    </div>
    <div class="operate">
        <form action="routeServlet?method=getRouteListBySearch_textWithPage&pageNow=1" method="post">
            <input id="search_text" name="search_text" class="textBox length-long" placeholder="输入产品名称..." value="${search_text}"/>
            <input type="submit" value="查询" class="tdBtn"/>
        </form>
    </div>
    <table class="list-style Interlaced">
        <tr>
            <th>ID编号</th>
            <th>图片</th>
            <th>名称</th>
            <th>市场价</th>
            <th>分类</th>
            <th>收藏数</th>
            <th>上架日期</th>
            <th>主题游（是否）</th>
            <th>状态（在售）</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${pageList.list}" var="r">
            <tr>
                <td>
                     <span>
                         <input type="checkbox" name="checkedId" class="middle children-checkbox" value="${r.rid}"/>
                         <i>${r.rid}</i>
                     </span>
                </td>
                <td class="center pic-area"><img src="${r.rimage}" class="thumbnail"/></td>
                <td class="td-name">
                    <span class="ellipsis td-name block">${r.rname}</span>
                </td>
                <td class="center">
                 <span>
                    <i>￥</i>
                    <em>${r.price}</em>
                 </span>
                </td>
                <td class="center">
                 <span id="write_cate">
                     <c:forEach items="${cateList}" var="c">
                         <c:if test="${c.cid==r.cid}">
                            ${c.cname}
                         </c:if>
                     </c:forEach>
                 </span>
                </td>
                <td class="center">
                     <span>
                      <em>${r.count}</em>
                      <i>次</i>
                     </span>
                </td>
                <td class="center">
                     <span>
                      ${r.rdate}
                     </span>
                </td>
                <c:if test="${0 == r.isthemetour}">
                    <td class="center"><img src="images/no.gif"/></td>
                </c:if>
                <c:if test="${1 == r.isthemetour}">
                    <td class="center"><img src="images/yes.gif"/></td>
                </c:if>

                <c:if test="${0 == r.rflag}">
                    <td class="center"><img src="images/no.gif"/></td>
                </c:if>
                <c:if test="${1 == r.rflag}">
                    <td class="center"><img src="images/yes.gif"/></td>
                </c:if>

                <td class="center">
                    <a href="/TravelProject/routeServlet?method=getRouteByRid&rid=${r.rid}" title="查看" target="_blank"><img src="images/icon_view.gif"/></a>
                    <a href="/TravelProject/routeServlet?method=getRouteForEditByRid&rid=${r.rid}" title="编辑"><img src="images/icon_edit.gif"/></a>
                    <a href="javascript:;" id="${r.rid}" onclick="delByRid(this.id)" title="删除"><img src="images/icon_drop.gif"/></a>
                </td>
            </tr>
        </c:forEach>
        <c:if test="${empty pageList.list}">
            <tr>
                <td colspan="10" height="100px" align="center"><font  color="red">暂无数据</font></td>
            </tr>
        </c:if>
    </table>
    <!-- BatchOperation -->
    <div style="overflow:hidden;">
        <!-- Operation -->
        <div class="BatchOperation fl">
            <input type="checkbox" id="box_a" onchange="chooseAll()" />
            全选
            <input type="button" value="批量删除" class="btnStyle" onclick="delRoutesByRids()"/>
        </div>
        <!-- turn page -->
        <div class="turnPage center fr">
            共${pageList.pageCount}条数据/总计${pageList.getPageAll()}页
            <a href="/TravelProject/routeServlet?method=getRouteListBySearch_textWithPage&search_text=${search_text}&pageNow=1">首页</a>
            <a href="/TravelProject/routeServlet?method=getRouteListBySearch_textWithPage&search_text=${search_text}&pageNow=${pageList.getUpPage()}">上一页</a>
            <a style="background-color: white;color: #0f0f0f" href="javascript:;">当前页${pageList.getPageNow()}</a>
            <a href="/TravelProject/routeServlet?method=getRouteListBySearch_textWithPage&search_text=${search_text}&pageNow=${pageList.getDownPage()}">下一页</a>
            <a href="/TravelProject/routeServlet?method=getRouteListBySearch_textWithPage&search_text=${search_text}&pageNow=${pageList.getLastIndex()}">尾页</a>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    function delRoutesByRids() {
        var checkId = [];
        $("input[name='checkedId']:checked").each(function (i) {
            checkId[i] = $(this).val();
        })
        console.log(checkId);
        window.location.href="/TravelProject/routeServlet?method=delRoutesByRids&search_text=${search_text}&pageNow=${pageList.getPageNow()}&checkId="+checkId;
       /* $.ajax({
            url:"/TravelProject/routeServlet?method=delRoutesByRids",
            data:{"checkId":checkId},
            success:function (data) {
                console.log(data);
            },
            error:function () {
                console.log("route_list.jsp : delRoutesByrids()");
            }
        })*/
    }
    function delByRid(rid) {
       if(confirm("确认删除该路线吗？")){
               window.location.href="/TravelProject/routeServlet?method=delRouteByRid&search_text=${search_text}&pageNow=${pageList.getPageNow()}&rid="+rid;
       }
    }
    $(function () {
        $('#box_a').click(function () {
           if(this.checked){
               $("input[name='checkedId']").prop('checked',true);
           }else {
               $("input[name='checkedId']").prop('checked',false);
           }

        });
        $("input[name='checkedId']").click(function() {
            var $checkedId = $("input[name='checkedId']");
            $("#box_a").prop("checked" , $checkedId.length == $checkedId.filter(":checked").length ? true :false);
        });

    });
</script>
</html>