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

    <title>Dashboard - SB Admin</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">

    <!-- Add custom CSS here -->
    <link href="css/sb-admin.css" rel="stylesheet">
    <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
    <!-- Page Specific CSS -->
    <link rel="stylesheet" href="css/morris-0.4.3.min.css">
    <link rel="stylesheet" href="css/dyj.css">
  </head>

  <body>

    <div id="wrapper">
        <%@ include file="top.jsp"%>
      <div id="page-wrapper">
        <div class="row">
          <div class="col-lg-12">
            <h1 class="admin_title"><span>店铺详情</span><a href="" class="btn btn-link">返回列表</a></h1>
          </div>
        </div><!-- /.row -->

        <div class="row">
        	<div class="col-lg-12">
        		<form class="form-horizontal"action="business_info" method="post">
                    <input type="hidden" name="act" value="${type}">
                    <input type="hidden" name="bid" value="${info.bid}">
                    <input type="hidden" name="bimage" value="${info.bimage}" id="bimage">
                    <input type="hidden" name="saleimg" value="${info.saleimg}" id="saleimg">
                    <input type="hidden" name="cardimg" value="${info.cardimg}" id="cardimg">
					  <div class="form-group">
					    <label for="locname" class="col-sm-2 control-label">彩店名称:</label>
					    <div class="col-sm-5">
					      <input class="form-control" id="locname" name="locname" value="${info.locname}">
					    </div>
					  </div>
                    <div class="form-group">
                        <label for="mobile" class="col-sm-2 control-label">手机号:</label>
                        <div class="col-sm-5">
                            <input class="form-control" id="mobile" name="mobile" value="${info.mobile}">
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
						<div class="col-sm-5" style="padding:0 15px 0 0 "><select class="form-control">
				                  <option>选择门店</option>
				                  <option>2</option>
				                  <option>3</option>
				                  <option>4</option>
				                  <option>5</option>
				            </select></div><div class="col-sm-5" style="padding:0 0 0 15px "><select class="form-control">
				                  <option>选择门店</option>
				                  <option>2</option>
				                  <option>3</option>
				                  <option>4</option>
				                  <option>5</option>
				            </select></div>
					    </div>
					    <div class="col-sm-3">
					      <input class="form-control" id="address" name="address" value="${info.address}">
					    </div>
					  </div>
                    <div class="form-group">
                        <label for="cox" class="col-sm-2 control-label">坐标X</label>
                        <div class="col-sm-3">
                            <input class="form-control" id="cox" name="cox" value="${info.cox}">
                        </div>
                        <label for="coy" class="col-sm-2 control-label">坐标Y</label>
                        <div class="col-sm-3">
                            <input class="form-control" id="coy" name="coy" value="${info.coy}">
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
					    <div class="col-sm-offset-2 col-sm-10">
					        <button type="submit" class="btn btn-primary btn-sm">保  存</button>
					        <button type="reset" class="btn btn-primary btn-sm">重置</button>
					    </div>
					  </div>
				</form>
                <form method="post" id="buimg" action="upload" enctype="multipart/form-data">
                    <div class="form-group">

                        <label for="bfile" class="col-sm-2 control-label">彩店照片</label>
                        <div class="col-sm-5">
                            <input type="file" name="file" id="bfile">
                        </div>
                        <button type="button" class="btn btn-primary btn-sm uploadimg">上传</button>
                    </div>
                </form>
                <form method="post" id="simg" action="upload" enctype="multipart/form-data">
                    <div class="form-group">
                        <label for="sfile" class="col-sm-2 control-label">代销证照片:</label>
                        <div class="col-sm-5">
                            <input type="file" name="file" id="sfile">
                        </div>
                        <button type="button" class="btn btn-primary btn-sm uploadimg">上传</button>
                    </div>
                </form>
                <form method="post" id="idimg" action="upload" enctype="multipart/form-data">
                    <div class="form-group">
                        <label for="ifile" class="col-sm-2 control-label">身份证照片</label>
                        <div class="col-sm-5">
                            <input type="file" name="file" id="ifile">
                        </div>
                        <button type="button" class="btn btn-primary btn-sm uploadimg">上传</button>
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
    <!-- Page Specific Plugins -->    <script src="js/raphael-min.js"></script>
    <script src="js/morris-0.4.3.min.js"></script>
    <script src="js/morris/chart-data-morris.js"></script>
    <script src="js/tablesorter/jquery.tablesorter.js"></script>
    <script src="js/tablesorter/tables.js"></script>
    <script src="http://malsup.github.io/jquery.form.js"></script>
    <script type="application/javascript">
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

    </script>
  </body>
</html>
