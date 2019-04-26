//国内游列表
function getGuoNeiList() {
    $.ajax({
        url:"routeServlet?method=getGuoNeiList",
        data:{},
        type:"POST",
        dataType:"json",
        contentType:"",
        success:function (data) {
            $('#write_guonei').empty();
            $.each(data,function (i,route){
                var con ="<div class='col-md-4'><a href='routeServlet?method=getRouteByRid&rid="+route.rid+"'>"
                    +"<img src='"+route.rimage+"' alt=''><div class='has_border'><h3>"+route.rname+"</h3>"
                    +"<div class='price'>网付价<em>￥</em><strong>"+route.price+"</strong><em>起</em></div>"
                    +"</div></a></div>";
                $('#write_guonei').append(con);
            });
        },
        error:function (data) {
            alert("请求失败！");
        }
    });
}
//境外游
function getJingWaiList() {
    $.ajax({
        url:"routeServlet?method=getJingWaiList",
        data:{},
        type:"POST",
        dataType:"json",
        contentType:"",
        success:function (data) {
            $('#write_jingwai').empty();
            $.each(data,function (i,route){
                var con ="<div class='col-md-4'><a href='routeServlet?method=getRouteByRid&rid="+route.rid+"'>"
                    +"<img src='"+route.rimage+"' alt=''><div class='has_border'><h3>"+route.rname+"</h3>"
                    +"<div class='price'>网付价<em>￥</em><strong>"+route.price+"</strong><em>起</em></div>"
                    +"</div></a></div>";
                $('#write_jingwai').append(con);
            });
        },
        error:function (data) {
            alert("请求失败！");
        }
    });
}
//主题游
function getTheme() {
    $.ajax({
        url:"routeServlet?method=getTheme",
        data:{},
        type:"POST",
        dataType:"json",
        contentType:"",
        success:function (data) {
            $('#write_theme').empty();
            $.each(data,function (i,route){
                var con = "<div class='col-md-3'><a href='routeServlet?method=getRouteByRid&rid="+route.rid+"'>"
                    +"<img src='"+route.rimage+"' alt=''><div class='has_border'><h3>"+route.rname+"</h3>"
                    +"<div class='price'>网付价<em>￥</em><strong>"+route.price+"</strong><em>起</em></div>"
                    +"</div></a></div>";
                $('#write_theme').append(con);
            });
        },
        error:function (data) {
            alert("请求失败！");
        }
    });
}
//最新
function getnewest() {
    $.ajax({
        url:"routeServlet?method=getNewest",
        data:{},
        type:"POST",
        dataType:"json",
        contentType:"",
        success:function (data) {
            $('#write_newest').empty();
            $.each(data,function (i,route){
                var con = "<div class='col-md-3'><a href='routeServlet?method=getRouteByRid&rid="+route.rid+"'>"
                    +"<img src='"+route.rimage+"' alt=''><div class='has_border'><h3>"+route.rname+"</h3>"
                    +"<div class='price'>网付价<em>￥</em><strong>"+route.price+"</strong><em>起</em></div>"
                    +"</div></a></div>";
                $('#write_newest').append(con);
            });
        },
        error:function (data) {
            alert("请求失败！");
        }
    });
}
/*最热旅游*/
function getHotTravel(){
    $.ajax({
        url:"routeServlet?method=getHotTravel",
        data:{},
        type:"POST",
        dataType:"json",
        contentType:"",
        success:function (data) {
            $('#write_hotTravel').empty();
            $.each(data,function (i,route){
                var con = "<div class='col-md-3'><a href='routeServlet?method=getRouteByRid&rid="+route.rid+"'>"
                    +"<img src='"+route.rimage+"' alt=''><div class='has_border'><h3>"+route.rname+"</h3>"
                    +"<div class='price'>网付价<em>￥</em><strong>"+route.price+"</strong><em>起</em></div>"
                    +"</div></a></div>";
                $('#write_hotTravel').append(con);
            });

        },
        error:function (data) {
            alert("请求失败！");

        }
    });
}
