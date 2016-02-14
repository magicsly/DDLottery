<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <h1 class="admin_title"><span>店铺管理</span><a class="btn btn-primary addnewsd" href="business_info">添加新店</a></h1>
            <div class="form-group form_box">
			    <label class="col-sm-2 control-label">按省份选择</label>
			    <div class="col-sm-2">
			     <select class="form-control">
	                  <option>按省份选择</option>
	                  <option>2</option>
	                  <option>3</option>
	                  <option>4</option>
	                  <option>5</option>
	                </select>
			    </div>
			    <div class="col-sm-2">
			     <select class="form-control">
	                  <option>按省份选择</option>
	                  <option>2</option>
	                  <option>3</option>
	                  <option>4</option>
	                  <option>5</option>
	                </select>
			    </div>
			    <div class="col-sm-1">
			     <button type="button" class="btn btn-primary btn-sm">确定</button>
			    </div>
			    <div class="col-sm-1">
			     或者
			    </div>
			    <div class="col-sm-2">
			     <input class="form-control" placeholder="城市">
			    </div>
			    <div class="col-sm-1">
			     <button type="button" class="btn btn-primary btn-sm">确定</button>
			    </div>
			  </div>
          </div>
        </div><!-- /.row -->

        <div class="row">
        	<div class="col-lg-12">
			<div class="table-responsive">
	              <table class="table table-bordered table-hover table-striped tablesorter">
	                <thead>
		                  <tr>
			                  <th class="header">彩店名称 <i class="fa fa-sort"></i></th>
			                  <th class="header">店主姓名<i class="fa fa-sort"></i></th>
			                  <th class="header">联系电话<i class="fa fa-sort"></i></th>
			                  <th class="header">地址 <i class="fa fa-sort"></i></th>
			                  <th class="header">入住时间 <i class="fa fa-sort"></i></th>
			                  <th class="header">操作<i class="fa fa-sort"></i></th>
		                  </tr>
	                </thead>
	                <tbody>
                    <c:forEach items="${businessList}" var="list">
	                  <tr>
	                    <td><a href=""> ${list.locname}</a></td>
	                    <td>${list.realname}</td>
	                    <td>${list.mobile}</td>
	                    <td>${list.address}
                            <a class="btn btn-success btn-xs">地图</a>
                        </td>
	                    <td>${list.creattime}</td>
	                    <td class="xq_type"><a href="" >编辑</a></td>
	                  </tr>
                    </c:forEach>
	                </tbody>
	              </table>
	            </div>
        	</div>
        </div><!-- /.row -->

        <div class="row"></div><!-- /.row -->

        <div class="row"></div><!-- /.row -->

      </div><!-- /#page-wrapper -->

    </div><!-- /#wrapper -->

    <!-- JavaScript -->
    <script src="js/jquery-1.10.2.js"></script>
    <script src="js/bootstrap.js"></script>

    <!-- Page Specific Plugins -->    <script src="js/raphael-min.js"></script>
    <script src="js/morris-0.4.3.min.js"></script>
    <script src="js/morris/chart-data-morris.js"></script>
    <script src="js/tablesorter/jquery.tablesorter.js"></script>
    <script src="js/tablesorter/tables.js"></script>

  </body>
</html>
