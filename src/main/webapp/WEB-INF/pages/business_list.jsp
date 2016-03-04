<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>苋菜 - 商户管理</title>
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/sb-admin.css" rel="stylesheet">
    <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/dyj.css">
    <link href="css/jquery-confirm.css" rel="stylesheet">
  </head>

  <body>

    <div id="wrapper">
        <%@ include file="top.jsp"%>
      <div id="page-wrapper">
        <div class="row">
          <div class="col-lg-12">
            <h1 class="admin_title"><span>店铺管理</span><a class="btn btn-primary addnewsd" href="business_info">添加新店</a></h1>
            <div class="form-group form_box">
                <form class="form-horizontal"action="business_list" method="post" id="form">
			    <label class="col-sm-2 control-label">按省份选择</label>
			    <div class="col-sm-2">
			     <select class="form-control" id="area" name="area"></select>
			    </div>
			    <div class="col-sm-2">
			     <select class="form-control" id="city" name="city"></select>
			    </div>
			    <div class="col-sm-1">
			     <button type="submit" class="btn btn-primary btn-sm">确定</button>
			    </div>
                </form>
			  </div>
          </div>
        </div><!-- /.row -->

        <div class="row">
        	<div class="col-lg-12">
			<div class="table-responsive">
	              <table class="table table-bordered table-hover table-striped tablesorter">
	                <thead>
		                  <tr>
                              <th class="header">ID<i class="fa fa-sort"></i></th>
			                  <th class="header">彩店名称 <i class="fa fa-sort"></i></th>
			                  <th class="header">店主姓名<i class="fa fa-sort"></i></th>
			                  <th class="header">联系电话<i class="fa fa-sort"></i></th>
			                  <th class="header">地址 <i class="fa fa-sort"></i></th>
                              <th class="header">余额<i class="fa fa-sort"></i></th>
			                  <th class="header">入住时间 <i class="fa fa-sort"></i></th>
			                  <th class="header">操作<i class="fa fa-sort"></i></th>
		                  </tr>
	                </thead>
	                <tbody>
                    <c:forEach items="${businessList}" var="list">
	                  <tr>
                          <td><a href="business_info?act=info&bid=${list.bid}">${list.bid}</a></td>
	                    <td><a href="business_info?act=info&bid=${list.bid}"> ${list.locname}</a></td>
	                    <td>${list.realname}</td>
	                    <td>${list.mobile}</td>
	                    <td >
                            <a title="${list.address}" class="btn btn-success btn-xs map" cox="${list.cox}" coy="${list.coy}">地图</a>
                        </td>
                          <td>${list.money}</td>
	                    <td><fmt:formatDate value="${list.creattime}" pattern="YYYY-MM-dd"/></td>
	                    <td class="xq_type">
                            <a href="business_account?bid=${list.bid}" >账户明细</a>
                            <a href="business_info?act=info&bid=${list.bid}" >编辑</a>
                            <a href="business_recharge?act=info&bid=${list.bid}" >充值</a>
                        </td>
	                  </tr>
                    </c:forEach>
	                </tbody>
                      <tr>
                          <td colspan="10" class="page_box">
                              <span class="listtable_all">共有${count}条，第${page}页</span>
                              <ul id="pagination"></ul>
                          </td>
                      </tr>
	              </table>
	            </div>
        	</div>
        </div><!-- /.row -->
        <div class="row">

        </div><!-- /.row -->
        <div class="row"></div><!-- /.row -->
      </div><!-- /#page-wrapper -->
    </div><!-- /#wrapper -->
    <!-- JavaScript -->
    <script src="js/jquery-1.10.2.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="js/area.js"></script>
    <script src="js/jquery-confirm.js"></script>
    <script src="js/jquery.twbsPagination.min.js"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=F99TeWtLABsEGga8C4gt31T7"></script>
    <script>
        $(function(){
            var count = ${count};
            $("#pagination").twbsPagination({
                totalPages:Math.ceil(count / 20),
                visiblePages: 5,
                href: '?page={{number}}'
            });

            var h=[];
            h[h.length]='<option num="0" value="0">所有城市</option>';
            for(var i=0;i<sys_area.provinces.length;i++){
                h[h.length]='<option num="'+i+'" value="'+sys_area.provinces[i].province_code+'">'+sys_area.provinces[i].province+'</option>';
            }
            $("#area").html(h.join(""));
            $("#area").val(${info.area});
            if($("#area").val()!=""){
                var ch = [];
                var num = $("#area").find("option:selected").attr("num");
                var citys = sys_area.provinces[num].citys;
                ch[ch.length]='<option num="0" value="0">所有城市</option>';
                for(var i=0;i<citys.length;i++){
                    ch[ch.length]='<option value="'+Number(citys[i].city_code)+'">'+citys[i].city+'</option>';
                }
                $("#city").html(ch.join(""));
                $("#city").val(${info.city});
            }
            $("#area").change(function(){
                var ch = [];
                var num = $(this).find("option:selected").attr("num");
                var citys = sys_area.provinces[num].citys;
                for(var i=0;i<citys.length;i++){
                    ch[ch.length]='<option value="'+Number(citys[i].city_code)+'">'+citys[i].city+'</option>';
                }
                $("#city").html(ch.join(""));
            });

            $(".map").click(function(){
                var mapx = $(this).attr("cox");
                var mapy = $(this).attr("coy");
                var address = $(this).attr("title");
                $.alert({
                    title: false, // hides the title.
                    cancelButton: false,// hides the cancel button.
                    confirmButton: false, // hides the confirm button.
                    closeIcon: true, // hides the close icon.
                    animation: 'rotateX',
                    closeAnimation: 'rotateXR',
                    content: "<span>"+address+"</span><br/><div style='height:400px;' id='businessmap'>500*500</div>" +
                    "<script>loadmap("+mapy+","+mapx+")<\/script>"
                });
            });
        })
        function loadmap(x,y){
            var map = new BMap.Map("businessmap");
            var point = new BMap.Point(x,y);
            map.centerAndZoom(point, 18);
            var marker = new BMap.Marker(point);
            map.addOverlay(marker);
        }
    </script>
  </body>
</html>
