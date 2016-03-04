<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>苋菜 - 优惠券管理</title>
      <link href="css/bootstrap.css" rel="stylesheet">
      <link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet">
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
		<div class="bs-example">
            <c:if test="${type == 'add'}">
              <ul class="nav nav-tabs change_quantab" style="margin-bottom: 15px;">
                <li class="active"><a href="#home" data-toggle="tab">注册</a></li>
                <li class=""><a href="#profile" data-toggle="tab">满减</a></li>
              </ul>
            </c:if>
            <c:if test="${info.types == 1 || type=='add'}">
              <div id="myTabContent" class="tab-content">
                <div class="tab-pane fade active in" id="home">
                    <form class="form-horizontal" action="coupon_info" method="post">
                        <input type="hidden" name="act" value="${type}">
                        <input type="hidden" name="cid" value="${info.cid}">
                        <input type="hidden" name="types" value="1">
                        <div class="form-group">
                            <label for="money" class="col-sm-2 control-label">名称</label>
                            <div class="col-sm-5">
                                <input type="text" class="form-control" id="title" name="title" value="${info.title}">
                            </div>
                        </div>
					  <div class="form-group">
					    <label for="money" class="col-sm-2 control-label">面值</label>
					    <div class="col-sm-5">
					      <input type="text" class="form-control" id="money" name="money" value="${info.money}">
					    </div>
					    <div class="col-sm-1">
					      <div class="linet">元</div>
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="num" class="col-sm-2 control-label">发行量</label>
					    <div class="col-sm-5">
					      <input type="text" class="form-control" id="num" name="num" value="${info.num}">
					    </div>
					    <div class="col-sm-1">
					      <div class="linet">张</div>
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="starttime" class="col-sm-2 control-label">活动时间</label>
                          <div class="col-sm-5">
                              <div class="col-sm-5 pd">
                                  <input type="text" class="form-control" id="starttime" name="page_starttime" value="<fmt:formatDate value="${info.starttime}" pattern="YYYY-MM-dd"/>">
                              </div>
                              <div class="col-sm-2 linet" style="text-align: center;">至</div>
                              <div class="col-sm-5 pd">
                                  <input type="text" class="form-control" id="endtime" name="page_endtime" value="<fmt:formatDate value="${info.endtime}" pattern="YYYY-MM-dd"/>">
                              </div>
                          </div>
					    <div class="col-sm-1">
					      <div class="linet">张</div>
					    </div>
					  </div>
					  <div class="form-group">
					    <div class="col-sm-offset-2 col-sm-10">
					      <button type="submit" class="btn btn-primary btn-sm">保存</button>
					    </div>
					  </div>
                    </form>
                </div>
                  </c:if>
                <c:if test="${info.types == 2 || info.types == 3 || type == 'add'}">
                <div class="tab-pane fade <c:if test="${type == 'edit'}">active in</c:if>" id="profile">
                    <form class="form-horizontal" action="coupon_info" method="post">
                        <input type="hidden" name="act" value="${type}">
                        <input type="hidden" name="cid" value="${info.cid}">
                        <input type="hidden" name="types" value="2">
                        <div class="form-group">
                            <label for="money" class="col-sm-2 control-label">名称</label>
                            <div class="col-sm-5">
                                <input type="text" class="form-control" id="title2" name="title" value="${info.title}">
                            </div>
                        </div>
					  <div class="form-group">
					    <label for="money2" class="col-sm-2 control-label">面值</label>
					    <div class="col-sm-5">
					      <input type="text" class="form-control" id="money2" name="money" value="${info.money}">
					    </div>
					    <div class="col-sm-1">
					      <div class="linet">元</div>
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="num2" class="col-sm-2 control-label">发行量</label>
					    <div class="col-sm-5">
					      <input type="text" class="form-control" id="num2" name="num" value="${info.num}">
					    </div>
					    <div class="col-sm-1">
					      <div class="linet">张</div>
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="bid" class="col-sm-2 control-label">选择门店</label>
					    <div class="col-sm-5">
					      <select class="form-control" name="bid" id="bid" value="${info.bid}">
                                <option value="all" value="${info.bid}">所有门店</option>
                                <c:forEach items="${business}" var="list">
				                  <option value=${list.bid}>${list.locname}</option>
                                </c:forEach>
                          </select>
					    </div>
					  </div>

                        <%--<div class="form-group">--%>
                            <%--<label for="bid" class="col-sm-2 control-label">选择门店</label>--%>
                            <%--<div class="col-sm-5">--%>
                                <%--<input class="form-control" value="${list.bid}" type="text">--%>
                            <%--</div>--%>
                            <%--<div class="col-sm-5 linet">--%>
                                <%--<button type="button" class="btn btn-default" id="selBusiness">选择</button>--%>
                            <%--</div>--%>
                        <%--</div>--%>

					  <div class="form-group">
					    <label for="fullmuch" class="col-sm-2 control-label">使用条件</label>
					    <div class="col-sm-5">
					      <div class="col-sm-4 pd linet">单笔订单满</div>
						<div class="col-sm-2 pd">
							<input type="text" class="form-control" id="fullmuch" name="fullmuch" value="${info.fullmuch}">
						</div>
					      <div class="col-sm-4 linet">元可使用此券</div>
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="starttime" class="col-sm-2 control-label">活动时间</label>
					    <div class="col-sm-5">
						    <div class="col-sm-5 pd">
						        <input type="text" class="form-control" id="starttime2" name="page_starttime" value="<fmt:formatDate value="${info.starttime}" pattern="YYYY-MM-dd"/>" data-date-format="yyyy-mm-dd">
						    </div>
						    <div class="col-sm-2 linet" style="text-align: center;">至</div>
                            <div class="col-sm-5 pd">
                                <input type="text" class="form-control" id="endtime2" name="page_endtime" value="<fmt:formatDate value="${info.endtime}" pattern="YYYY-MM-dd"/>" data-date-format="yyyy-mm-dd">
                            </div>
                        </div>
					    <div class="col-sm-1">
					      <div  class="linet">张</div>
					    </div>
					  </div>
					<div class="form-group">
					    <label for="limitnum" class="col-sm-2 control-label">每人限领</label>
					    <div class="col-sm-5">
					      <select class="form-control" id="limitnum" name="limitnum" value="${info.limitnum}">
                              <option value=-1>无限制</option>
                              <option value=1>1</option>
                              <option value=2>2</option>
                              <option value=3>3</option>
                              <option value=4>4</option>
                              <option value=5>5</option>
				            </select>
					    </div>
					    <div class="col-sm-1">
					      <div class="linet">张</div>
					    </div>

					  </div>
					    <div class="form-group">
					    <div class="col-sm-offset-2 col-sm-10">
					      <button type="submit" class="btn btn-primary btn-sm">保存</button>
					    </div>
					  </div>
				</form>
                </div>
                </c:if>
              </div>
            </div>
          </div>
        </div><!-- /.row -->
      </div><!-- /#page-wrapper -->
    </div><!-- /#wrapper -->
    <!-- JavaScript -->
    <script src="js/jquery-1.10.2.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="js/bootstrap-datetimepicker.min.js"></script>
    <script src="js/jquery-confirm.js"></script>
    <script src="js/area.js"></script>
    <script type="application/javascript">
        $(function(){
            $('#starttime,#endtime,#starttime2,#endtime2').datetimepicker({minView: 'decade'});
            $("#bid").val(${info.bid});
            $("#limitnum").val(${info.limitnum});

//            $('#selBusiness').click(function(){
//                var uh ='<div class="col-sm-5">'+
//                        '<div class="col-sm-5" style="padding:0 15px 0 0 ">'+
//                        '<select class="form-control" id="area" name="area"></select>'+
//                        '</div>'+
//                        '<div class="col-sm-5" style="padding:0 0 0 15px ">'+
//                        '<select class="form-control" id="city" name="city"></select>'+
//                        '</div>'+
//                        '</div>';
//                $.alert({
//                    title: false, // hides the title.
//                    cancelButton: false,// hides the cancel button.
//                    confirmButton: false, // hides the confirm button.
//                    closeIcon: true, // hides the close icon.
//                    animation: 'rotateX',
//                    closeAnimation: 'rotateXR',
//                    content: uh
//                });
//                var h=[];
//                h[h.length]='<option num="0" value="0">所有城市</option>';
//                for(var i=0;i<sys_area.provinces.length;i++){
//                    h[h.length]='<option num="'+i+'" value="'+sys_area.provinces[i].province_code+'">'+sys_area.provinces[i].province+'</option>';
//                }
//                $("#area").html(h.join(""));
//                $("#area").val(11);
//            });
        })
    </script>
  </body>
</html>
