<%--
  Created by IntelliJ IDEA.
  User: 张铭传
  Date: 2019/4/25
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>小码聪聪旅游网-登录</title>
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" type="text/css" href="css/login.css">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <!--导入angularJS文件-->
    <script src="https://cdn.bootcss.com/angular.js/2.0.0-beta.17/angular2.min.js"></script>
    <!--导入jquery-->
    <script src="js/jquery-3.3.1.js"></script>
</head>

<body>
<!--引入头部-->
<%@include file="header.jsp" %>
<!-- 头部 end -->
<section id="login_wrap">
    <div class="fullscreen-bg" style="background: url(images/login_bg.png);height: 532px;">

    </div>
    <div class="login-box">
        <div class="title">
            <img src="images/logo.png" alt="">
            <span>欢迎登录</span>
        </div>
        <div class="login_inner">

            <!--登录错误提示消息-->
            <div id="errorMsg" class="alert alert-danger"></div>
            <form id="loginForm" action="" method="post" accept-charset="utf-8">
                <input type="hidden" name="action" value="login"/>
                <input name="username" type="text" placeholder="请输入账号" autocomplete="off">
                <input name="password" type="password" placeholder="请输入密码" autocomplete="off">
                <div class="verify">
                    <input name="check" id="check" type="text" placeholder="请输入验证码" autocomplete="off">
                    <span><img src="checkcode" alt="" id="codeimg" onclick="changeCheckCode()"></span>
                </div>
                <div class="submit_btn">
                    <button type="button" id="btn_submit">登录</button>
                </div>
                <br><br><br><br>
                <div>
                    自动登录:<input type="checkbox" name="autoLogin" class="">
                </div>
            </form>
            <div class="reg">没有账户？<a href="javascript:;">立即注册</a></div>
        </div>
    </div>
</section>
<!--引入尾部-->
<%@include file="footer.jsp" %>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery-1.11.0.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
<!--导入布局js，共享header和footer-->
<script type="text/javascript" src="js/include.js"></script>
<script type="text/javascript">
    //图片点击事件
    function changeCheckCode() {
        $.ajax({
            url: "checkcode",
            data: {},
            type: "POST",
            success: function (data) {
                $('#codeimg').attr("src", "checkcode");
            },
            error: function (data) {
                alert("fail");
            }
        })
    }

    $('#btn_submit').click(function () {
        $.ajax({
            url: "userServlet?method=login",
            data: $('#loginForm').serialize(),
            type: "POST",
            success: function (data) {
                if (data == 0) {
                    alert("登录成功，即将跳转到首页");
                    window.location.href = "index.jsp";
                } else if (data == 1) {
                    alert("登陆失败，请重新登录！")
                    changeCheckCode();
                } else if (data == 2) {
                    alert("账户未激活！");
                } else if (data == 9) {
                    alert("验证码错误，请重试！")
                    changeCheckCode();
                }
            }
        });
    });

</script>
</body>
</html>
