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
            <h1 class="admin_title"><span>优惠券</span></h1>
            <div class="col-lg-4">
            
	            <div class="form-group ipt_box">
	                <label>类型</label>
	                <select class="form-control">
	                  <option>1</option>
	                  <option>2</option>
	                  <option>3</option>
	                  <option>4</option>
	                  <option>5</option>
	                </select>
	            </div>
            </div>
            <div class="col-lg-4">
	            <div class="form-group ipt_box">
	                <label>状态</label>
	                <select class="form-control">
	                  <option>1</option>
	                  <option>2</option>
	                  <option>3</option>
	                  <option>4</option>
	                  <option>5</option>
	                </select>
	            </div>            	
            </div>
            <div class="col-lg-4">
	            <div class="form-group input-group">
	                <input type="text" class="form-control">
	                <span class="input-group-btn">
	                  <button class="btn btn-default" type="button"><i class="fa fa-search"></i></button>
	                </span>
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
			                  <th class="header">优惠券名称 <i class="fa fa-sort"></i></th>
			                  <th class="header">优惠券ID<i class="fa fa-sort"></i></th>
			                  <th class="header">创建时间<i class="fa fa-sort"></i></th>
			                  <th class="header">有效时间 <i class="fa fa-sort"></i></th>
			                  <th class="header">发型行 <i class="fa fa-sort"></i></th>
			                  <th class="header">已领取<i class="fa fa-sort"></i></th>
			                  <th class="header">已使用<i class="fa fa-sort"></i></th>
			                  <th class="header">状态 <i class="fa fa-sort"></i></th>
						<th class="header">操作 <i class="fa fa-sort"></i></th>
		                  </tr>
	                </thead>
	                <tbody>
	                  <tr>
	                    <td><a href="">金秋特别回馈</a></td>
	                    <td>kr123k15035</td>
	                    <td>16-01-27</td>
	                    <td>16-01-27至16-01-27</td>
	                    <td>999</td>
	                    <td>999</td>
	                    <td>999</td>
	                    <td>未开始</td>
	                    <td class="xq_type"><a href="" >详情</a><em>|</em><a href="">明细</a><em>|</em><a href="">作废</a></td>
	                  </tr>
	                  <tr>
	                    <td colspan="9">....</td>
	                  </tr>
	                  <tr>
	                    <td><a href="">金秋特别回馈</a></td>
	                    <td>kr123k15035</td>
	                    <td>16-01-27</td>
	                    <td>16-01-27至16-01-27</td>
	                    <td>999</td>
	                    <td>999</td>
	                    <td>999</td>
	                    <td>已作废</td>
	                    <td class="xq_type"><a href="" >详情</a><em>|</em><a href="">明细</a><em>|</em><a href="">作废</a></td>
	                  </tr>
	                  <tr>
	                    <td colspan="9" class="page_box">
	                    	<span class="listtable_all">共有4条，每页显示20条</span>
	                    	<ul class="pagination">
			                <li class="disabled"><a href="#">首页</a></li>
			                <li><a href="#">前一页</a></li>
			                <li class="active"><a href="#">1</a></li>
			                <li><a href="#">2</a></li>
			                <li><a href="#">3</a></li>
			                <li><a href="#">4</a></li>
			                <li><a href="#">5</a></li>
			                <li><a href="#">后一页</a></li>
			                <li><a href="#">末页</a></li>
			              </ul>
	                    </td>
	                  </tr>
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
