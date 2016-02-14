<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

      <!-- Sidebar -->
      <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="index.html">大赢家管理后台</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse navbar-ex1-collapse">
          <ul class="nav navbar-nav side-nav">
			<li><a href=""><i class="fa fa-dashboard"></i>用户管理</a></li>
			<li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-caret-square-o-down"></i> 店铺管理 <b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li><a href="#">店铺管理</a></li>
                <li><a href="#">店铺管理</a></li>
              </ul>
            </li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-caret-square-o-down"></i> 营销管理 <b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li><a href="#">营销管理</a></li>
                <li><a href="#">创建优惠券</a></li>
                <li><a href="#">优惠券管理</a></li>
              </ul>
            </li>
          </ul>
        </div><!-- /.navbar-collapse -->
      </nav>
      <div id="page-wrapper">
        <div class="row">
          <div class="col-lg-12">
            <h1 class="admin_title"><span>店铺详情</span><a href="" class="btn btn-link">返回列表</a></h1>
          </div>
        </div><!-- /.row -->

        <div class="row">
        	<div class="col-lg-12">
        		<form class="form-horizontal">
					  <div class="form-group">
					    <label for="locname" class="col-sm-2 control-label">彩店名称:</label>
					    <div class="col-sm-5">
					      <input class="form-control" id="locname" name="locname">
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
					      <input class="form-control" id="address" name="address" value="">
					    </div>
					  </div>

					  <div class="form-group">
					    <label for="saletime" class="col-sm-2 control-label">营业时间</label>
					    <div class="col-sm-5">
						<div class="col-sm-5" style="padding:0"><input class="form-control" id="saletime" name="saletime"></div>
					    </div>
					  </div>

					  <div class="form-group">

                          <label for="bimage" class="col-sm-2 control-label">彩店照片</label>
                              <form method="post" id="myform" action="upload" enctype="multipart/form-data">
                                  <input type="file" name="file">
                                  <input type="submit" value="提交表单">
                              </form>
					  </div>
					  <div class="form-group">
					    <label  class="col-sm-2 control-label">营业类型</label>
					    <div class="col-sm-5">
						    <label class="checkbox-inline">
                            <input type="radio"  name="type" value="option1"> 个人
                            </label><label class="checkbox-inline">
                            <input type="radio"  name="type" value="option2"> 公司
                            </label>
					    </div>
					  </div>

					  <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">运营者姓名:</label>
					    <div class="col-sm-5">
					      <input class="form-control" id="realname" name="realname">
					    </div>
					  </div>

					  <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">身份证号:</label>
					    <div class="col-sm-5">
					      <input class="form-control" id="idcard" name="idcard">
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="inputPassword3" class="col-sm-2 control-label">身份证照片</label>
					    <div class="col-sm-5">
						    <input type="file">
					    </div>
					  </div>

					  <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">代销证号:</label>
					    <div class="col-sm-5">
					      <input class="form-control" id="inputEmail3" placeholder="">
					    </div>
					  </div>

					  <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">代销证照片:</label>
					    <div class="col-sm-5">
					      <input type="file">
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">代销彩种:</label>
					    <div class="col-sm-5">
					      <input class="form-control" id="inputEmail3" placeholder="">
					    </div>
					  </div>
					  <div class="form-group">
					    <div class="col-sm-offset-2 col-sm-10">
					    <button type="submit" class="btn btn-primary btn-sm">保  存</button>
					      <button type="submit" class="btn btn-primary btn-sm">重置</button>
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
    <!-- Page Specific Plugins -->    <script src="js/raphael-min.js"></script>
    <script src="js/morris-0.4.3.min.js"></script>
    <script src="js/morris/chart-data-morris.js"></script>
    <script src="js/tablesorter/jquery.tablesorter.js"></script>
    <script src="js/tablesorter/tables.js"></script>
    <script type="application/javascript">

    </script>
  </body>
</html>
