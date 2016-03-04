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
    <title>苋菜 - 商户管理</title>
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">
    <!-- Add custom CSS here -->
    <link href="css/sb-admin.css" rel="stylesheet">
    <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
    <!-- Page Specific CSS -->
    <link rel="stylesheet" href="css/morris-0.4.3.min.css">
    <link rel="stylesheet" href="css/dyj.css">
    <link href="css/jquery-confirm.css" rel="stylesheet">
  </head>
  <body>
    <div id="wrapper">
        <%@ include file="top.jsp"%>
      <div id="page-wrapper">
        <div class="row">
          <div class="col-lg-12">
              <h1 class="admin_title"><span>店铺详情</span><a href="business_list" class="btn btn-link">返回列表</a></h1>
          </div>
      </div><!-- /.row -->

        <div class="row">
        	<div class="col-lg-12">
        		<form class="form-horizontal"action="business_info" method="post" id="form">
                    <input type="hidden" name="act" value="${type}">
                    <input type="hidden" name="bid" value="${info.bid}">


					  <div class="form-group">
					    <label for="locname" class="col-sm-2 control-label">彩店名称:</label>
					    <div class="col-sm-5">
					      <input class="form-control" id="locname" name="locname" value="${info.locname}" check-type="required" required-message="彩店名称不能为空！">
					    </div>
					  </div>
                    <div class="form-group">
                        <label for="mobile" class="col-sm-2 control-label">手机号:</label>
                        <div class="col-sm-5">
                            <input class="form-control" id="mobile" name="mobile" value="${info.mobile}" check-type="required" required-message="手机号不能为空！">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="pwd" class="col-sm-2 control-label">密码:</label>
                        <div class="col-sm-5">
                            <input class="form-control" id="pwd" name="pwd">
                        </div>
                    </div>
					  <div class="form-group">
					    <label for="address" class="col-sm-2 control-label">彩店地址</label>
					    <div class="col-sm-5">
                            <div class="col-sm-5" style="padding:0 15px 0 0 ">
                                <select class="form-control" id="area" name="area" value="${info.area}"></select>
                            </div>
                            <div class="col-sm-5" style="padding:0 0 0 15px ">
                                <select class="form-control" id="city" name="city" value="${info.city}"></select>
                            </div>
					    </div>
					    <div class="col-sm-3">
					      <input class="form-control" id="address" name="address" value="${info.address}">
					    </div>
					  </div>
                    <div class="form-group">
                        <label for="cox" class="col-sm-2 control-label">坐标X</label>
                        <div class="col-sm-3">
                            <input class="form-control" id="cox" name="cox" check-type="required" required-message="坐标不能为空！" value="${info.cox}">
                        </div>

                    </div>
                    <div class="form-group">
                        <label for="coy" class="col-sm-2 control-label">坐标Y</label>
                        <div class="col-sm-3">
                            <input class="form-control" id="coy" name="coy" check-type="required" required-message="坐标不能为空！" value="${info.coy}">
                        </div>
                    </div>
					  <div class="form-group">
					    <label for="saletime" class="col-sm-2 control-label">营业时间</label>
					    <div class="col-sm-5">
						<div class="col-sm-5" style="padding:0"><input class="form-control" id="saletime" name="saletime" value="${info.saletime}"></div>
					    </div>
					  </div>
					  <div class="form-group">
					    <label  class="col-sm-2 control-label">营业类型</label>
					    <div class="col-sm-5">
						    <label class="checkbox-inline">
                            <input type="radio"  name="type" value="0"> 个人
                            </label><label class="checkbox-inline">
                            <input type="radio"  name="type" value="1"> 公司
                            </label>
					    </div>
					  </div>

					  <div class="form-group">
					    <label for="realname" class="col-sm-2 control-label">运营者姓名:</label>
					    <div class="col-sm-5">
					      <input class="form-control" id="realname" name="realname" value="${info.realname}">
					    </div>
					  </div>

					  <div class="form-group">
					    <label for="idcard" class="col-sm-2 control-label">身份证号:</label>
					    <div class="col-sm-5">
					      <input class="form-control" id="idcard" name="idcard" value="${info.idcard}">
					    </div>
					  </div>

                    <div class="form-group">
                        <label for="bank" class="col-sm-2 control-label">银行:</label>
                        <div class="col-sm-5">
                            <input class="form-control" id="bank" name="bank" value="${info.bank}">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="bankname" class="col-sm-2 control-label">分行名称:</label>
                        <div class="col-sm-5">
                            <input class="form-control" id="bankname" name="bankname" value="${info.bankname}">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="bankcode" class="col-sm-2 control-label">银行卡号:</label>
                        <div class="col-sm-5">
                            <input class="form-control" id="bankcode" name="bankcode" value="${info.bankcode}">
                        </div>
                    </div>

					  <div class="form-group">
					    <label for="salecard" class="col-sm-2 control-label">代销证号:</label>
					    <div class="col-sm-5">
					      <input class="form-control" id="salecard" name="salecard" value="${info.salecard}">
					    </div>
					  </div>

					  <div class="form-group">
					    <label for="salelot" class="col-sm-2 control-label">代销彩种:</label>
					    <div class="col-sm-5">
					      <input class="form-control" id="salelot" name="salelot" value="${info.salelot}">
					    </div>
					  </div>

                    <div class="form-group">
                        <label for="salelot" class="col-sm-2 control-label">彩店照片:</label>
                        <div class="col-sm-5">
                            <image src="../${info.bimage}" id="upimg" width="100" height="100" class="upimg"/>
                            <input type="hidden" name="bimage" value="${info.bimage}" id="bimage">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="salelot" class="col-sm-2 control-label">代销证照片:</label>
                        <div class="col-sm-5">
                            <image src="..${info.saleimg}" id="upimg" width="100" height="100" class="upimg"/>
                            <input type="hidden" name="saleimg" value="${info.saleimg}" id="saleimg">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="salelot" class="col-sm-2 control-label">身份证照片:</label>
                        <div class="col-sm-5">
                            <image src="..${info.cardimg}" id="upimg" width="100" height="100" class="upimg"/>
                            <input type="hidden" name="cardimg" value="${info.cardimg}" id="cardimg">
                        </div>
                    </div>

					  <div class="form-group">
					    <div class="col-sm-offset-2 col-sm-10">
					        <button type="submit" class="btn btn-primary btn-sm">保  存</button>
					        <button type="reset" class="btn btn-primary btn-sm">重置</button>
					    </div>
					  </div>
				</form>
        	</div>
        </div><!-- /.row -->
        <div class="row"></div><!-- /.row -->
        <div class="row"></div><!-- /.row -->
      </div><!-- /#page-wrapper -->
    </div><!-- /#wrapper -->

    <!-- JavaScript -->
    <script src="js/jquery-1.10.2.js"></script>
    <script src="js/ajaxfileupload.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="js/bootstrap3-validation.js"></script>
    <script src="js/tablesorter/jquery.tablesorter.js"></script>
    <script src="js/tablesorter/tables.js"></script>
    <script src="http://malsup.github.io/jquery.form.js"></script>
    <script src="js/area.js"></script>
    <script src="js/jquery-confirm.js"></script>
    <script type="application/javascript">
        $(function(){
            $('#form').validation();//自定义form表单的id
            $(".upimg").click(function(){
                var img = $(this);
                var uh ='<form method="post"  action="upload" enctype="multipart/form-data">'+
                        '<input type="file" name="file" id="ifile">'+
                        '</br>'+
                        '<button type="button" class="btn btn-primary btn-sm uploadimg">上传</button>'+
                        '</form>';
                $.alert({
                    title: false, // hides the title.
                    cancelButton: false,// hides the cancel button.
                    confirmButton: false, // hides the confirm button.
                    closeIcon: true, // hides the close icon.
                    animation: 'rotateX',
                    closeAnimation: 'rotateXR',
                    content: uh
                });
                $(".uploadimg").off().on("click",function(){
                    var form = $(this).parents("form");
                    form.ajaxSubmit({
                        success: function(data) {
                            if(data.code==0){
                                img.next().val(data.filename);
                                img.attr("src",".."+data.filename);
                                $(".closeIcon").click();
                                alert("上传成功");
                            }
                        }
                    });
                })
            });

            var h=[];
            for(var i=0;i<sys_area.provinces.length;i++){
                h[h.length]='<option num="'+i+'" value="'+sys_area.provinces[i].province_code+'">'+sys_area.provinces[i].province+'</option>';
            }
            $("#area").html(h.join(""));
            $("#area").val(${info.area});
            if($("#area").val()!=""){
                var ch = [];
                var num = $("#area").find("option:selected").attr("num");
                var citys = sys_area.provinces[num].citys;
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

            $(".uploadimg").click(function(){
                var form = $(this).parents("form");
                var fid = form.attr("id");
                form.ajaxSubmit({
                    success: function(data) {
                        if(data.code==0){
                            if(fid=="buimg"){
                                $("#bimage").val(data.filename);
                            }
                            if(fid=="simg"){
                                $("#saleimg").val(data.filename);
                            }
                            if(fid=="idimg"){
                                $("#cardimg").val(data.filename);
                            }
                            alert("上传成功");
                        }
                    }
                });
            })
        })
    </script>
  </body>
</html>
