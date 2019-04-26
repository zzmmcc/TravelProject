<%--
  Created by IntelliJ IDEA.
  User: 张铭传
  Date: 2019/4/25
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" isELIgnored="false"  %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head><meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>小码旅游网</title>
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" type="text/css" href="css/index.css">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<!--引入头部-->
<%@ include file="header.jsp"%>
<!-- banner start-->
<section id="banner">
    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel" data-interval="2000">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
        </ol>
        <!-- Wrapper for slides -->
        <div class="carousel-inner" role="listbox">
            <div class="item active">
                <img src="images/banner_1.jpg" alt="">
            </div>
            <div class="item">
                <img src="images/banner_2.jpg" alt="">
            </div>
            <div class="item">
                <img src="images/banner_3.jpg" alt="">
            </div>
        </div>
        <!-- Controls -->
        <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
</section>
<!-- banner end-->
<!-- 旅游 start-->
<section id="content">
    <!-- 小码精选start-->
    <section class="hemai_jx">
        <div class="jx_top">
            <div class="jx_tit">
                <img src="images/icon_5.jpg" alt="">
                <span>小码精选</span>
            </div>
            <!-- Nav tabs -->
            <ul class="jx_tabs" role="tablist">
                <li role="presentation" class="active">
                    <span></span>
                    <a href="#popularity" aria-controls="popularity"   role="tab" data-toggle="tab">人气旅游</a>
                </li>
                <li role="presentation">
                    <span></span>
                    <a href="#newest" aria-controls="newest" role="tab" onclick="getnewest()" data-toggle="tab">最新旅游</a>
                </li>
                <li role="presentation">
                    <span></span>
                    <a href="#theme" aria-controls="theme" role="tab" onclick="getTheme()" data-toggle="tab">主题旅游</a>
                </li>
            </ul>
        </div>
        <div class="jx_content">
            <!-- Tab panes -->
            <div class="tab-content">
                <div role="tabpanel" class="tab-pane active" id="popularity">
                    <div class="row" id="write_hotTravel">
                        <%--最热--%>
                        <%--append追加区域--%>
                    </div>
                </div>
                <div role="tabpanel" class="tab-pane" id="newest">
                    <div class="row" id="write_newest">
                        <%--最新--%>
                        <%--append追加区域--%>
                    </div>
                </div>
                <div role="tabpanel" class="tab-pane" id="theme">
                    <div class="row" id="write_theme">
                        <%--主题游--%>
                        <%--append追加区域--%>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- 小码精选end-->
    <!-- 国内游 start-->
    <section class="hemai_jx">
        <div class="jx_top">
            <div class="jx_tit">
                <img src="images/icon_6.jpg" alt="">
                <span>国内游</span>
            </div>
        </div>
        <div class="heima_gn">
            <div class="guonei_l">
                <img src="images/guonei_1.jpg" alt="">
            </div>
            <div class="guone_r">
                <div class="row" id="write_guonei">

                </div>
            </div>
        </div>
    </section>
    <!-- 国内游 end-->
    <!-- 境外游 start-->
    <section class="hemai_jx">
        <div class="jx_top">
            <div class="jx_tit">
                <img src="images/icon_7.jpg" alt="">
                <span>境外游</span>
            </div>
        </div>
        <div class="heima_gn">
            <div class="guonei_l">
                <img src="images/jiangwai_1.jpg" alt="">
            </div>
            <div class="guone_r">
                <div class="row" id="write_jingwai">

                </div>
            </div>
        </div>
    </section>
    <!-- 境外游 end-->
</section>
<!-- 旅游 end-->
<!--导入底部-->
<%@ include file="footer.jsp"%>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery-3.3.1.js"></script>
<script src="js/index_js.js"></script>
<script type="text/javascript">
    $(function () {
        getHotTravel();
        getGuoNeiList();
        getJingWaiList();
    });
</script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
<!--导入布局js，共享header和footer-->
<script type="text/javascript" src="js/include.js"></script>
</body>
</html>
