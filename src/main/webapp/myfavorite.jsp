<%--
  Created by IntelliJ IDEA.
  User: 张铭传
  Date: 2019/4/25
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" isELIgnored="false"  %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="utf-8">
    <title>小码旅游网-我的收藏</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" href="css/index.css">
    <style>
        .tab-content .row>div {
            margin-top: 16px;
        }
        .tab-content {
            margin-bottom: 36px;
        }
    </style>
    <script src="js/jquery-3.3.1.js"></script>
</head>
<body>
<!--引入头部-->
<%@include file="header.jsp"%>
<!-- 排行榜 start-->
<section id="content">
    <section class="hemai_jx">
        <div class="jx_top">
            <div class="jx_tit">
                <img src="images/icon_5.jpg" alt="">
                <span>我的收藏</span>
            </div>
        </div>
        <div class="jx_content">
            <!-- Tab panes -->
            <div class="tab-content">
                <div role="tabpanel" class="tab-pane active" id="home">
                    <div class="row">
                        <div class="col-md-3">
                            <a href="route_detail.html">
                                <img src="images/collection_pic.jpg" alt="">
                                <div class="has_border">
                                    <h3>上海直飞三亚5天4晚自由行(春节预售+亲子/蜜月/休闲游首选+豪华酒店任选+接送机)</h3>
                                    <div class="price">网付价<em>￥</em><strong>889</strong><em>起</em></div>
                                </div>
                            </a>
                        </div>
                        <div class="col-md-3">
                            <a href="route_detail.html">
                                <img src="images/collection_pic.jpg" alt="">
                                <div class="has_border">
                                    <h3>上海直飞三亚5天4晚自由行(春节预售+亲子/蜜月/休闲游首选+豪华酒店任选+接送机)</h3>
                                    <div class="price">网付价<em>￥</em><strong>889</strong><em>起</em></div>
                                </div>
                            </a>
                        </div>
                        <div class="col-md-3">
                            <a href="route_detail.html">
                                <img src="images/collection_pic.jpg" alt="">
                                <div class="has_border">
                                    <h3>上海直飞三亚5天4晚自由行(春节预售+亲子/蜜月/休闲游首选+豪华酒店任选+接送机)</h3>
                                    <div class="price">网付价<em>￥</em><strong>889</strong><em>起</em></div>
                                </div>
                            </a>
                        </div>
                        <div class="col-md-3">
                            <a href="route_detail.html">
                                <img src="images/collection_pic.jpg" alt="">
                                <div class="has_border">
                                    <h3>上海直飞三亚5天4晚自由行(春节预售+亲子/蜜月/休闲游首选+豪华酒店任选+接送机)</h3>
                                    <div class="price">网付价<em>￥</em><strong>889</strong><em>起</em></div>
                                </div>
                            </a>
                        </div>
                        <div class="col-md-3">
                            <a href="route_detail.html">
                                <img src="images/collection_pic.jpg" alt="">
                                <div class="has_border">
                                    <h3>上海直飞三亚5天4晚自由行(春节预售+亲子/蜜月/休闲游首选+豪华酒店任选+接送机)</h3>
                                    <div class="price">网付价<em>￥</em><strong>889</strong><em>起</em></div>
                                </div>
                            </a>
                        </div>
                        <div class="col-md-3">
                            <a href="route_detail.html">
                                <img src="images/collection_pic.jpg" alt="">
                                <div class="has_border">
                                    <h3>上海直飞三亚5天4晚自由行(春节预售+亲子/蜜月/休闲游首选+豪华酒店任选+接送机)</h3>
                                    <div class="price">网付价<em>￥</em><strong>889</strong><em>起</em></div>
                                </div>
                            </a>
                        </div>
                        <div class="col-md-3">
                            <a href="route_detail.html">
                                <img src="images/collection_pic.jpg" alt="">
                                <div class="has_border">
                                    <h3>上海直飞三亚5天4晚自由行(春节预售+亲子/蜜月/休闲游首选+豪华酒店任选+接送机)</h3>
                                    <div class="price">网付价<em>￥</em><strong>889</strong><em>起</em></div>
                                </div>
                            </a>
                        </div>
                        <div class="col-md-3">
                            <a href="route_detail.html">
                                <img src="images/collection_pic.jpg" alt="">
                                <div class="has_border">
                                    <h3>上海直飞三亚5天4晚自由行(春节预售+亲子/蜜月/休闲游首选+豪华酒店任选+接送机)</h3>
                                    <div class="price">网付价<em>￥</em><strong>889</strong><em>起</em></div>
                                </div>
                            </a>
                        </div>
                        <div class="col-md-3">
                            <a href="route_detail.html">
                                <img src="images/collection_pic.jpg" alt="">
                                <div class="has_border">
                                    <h3>上海直飞三亚5天4晚自由行(春节预售+亲子/蜜月/休闲游首选+豪华酒店任选+接送机)</h3>
                                    <div class="price">网付价<em>￥</em><strong>889</strong><em>起</em></div>
                                </div>
                            </a>
                        </div>
                        <div class="col-md-3">
                            <a href="route_detail.html">
                                <img src="images/collection_pic.jpg" alt="">
                                <div class="has_border">
                                    <h3>上海直飞三亚5天4晚自由行(春节预售+亲子/蜜月/休闲游首选+豪华酒店任选+接送机)</h3>
                                    <div class="price">网付价<em>￥</em><strong>889</strong><em>起</em></div>
                                </div>
                            </a>
                        </div>
                        <div class="col-md-3">
                            <a href="route_detail.html">
                                <img src="images/collection_pic.jpg" alt="">
                                <div class="has_border">
                                    <h3>上海直飞三亚5天4晚自由行(春节预售+亲子/蜜月/休闲游首选+豪华酒店任选+接送机)</h3>
                                    <div class="price">网付价<em>￥</em><strong>889</strong><em>起</em></div>
                                </div>
                            </a>
                        </div>
                        <div class="col-md-3">
                            <a href="jroute_detail.html">
                                <img src="images/collection_pic.jpg" alt="">
                                <div class="has_border">
                                    <h3>上海直飞三亚5天4晚自由行(春节预售+亲子/蜜月/休闲游首选+豪华酒店任选+接送机)</h3>
                                    <div class="price">网付价<em>￥</em><strong>889</strong><em>起</em></div>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
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
    </section>
</section>
<!-- 排行榜 end-->

<!--引入尾部-->
<%@ include file="footer.jsp"%>
<!--导入布局js，共享header和footer-->
<script type="text/javascript" src="js/include.js"></script>
</body>
</html>
