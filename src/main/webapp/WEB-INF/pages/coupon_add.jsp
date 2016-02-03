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
    <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
    <link rel="stylesheet" href="css/dyj.css">
  </head>
  <body>
    <div id="wrapper">
        <%@ include file="top.jsp"%>
      <div id="page-wrapper">
        <div class="row">
          <div class="col-lg-12">
		<div class="bs-example">
              <ul class="nav nav-tabs change_quantab" style="margin-bottom: 15px;">
                <li class="active"><a href="#home" data-toggle="tab">注册</a></li>
                <li class=""><a href="#profile" data-toggle="tab">满减</a></li>
              </ul>
              <div id="myTabContent" class="tab-content">
                <div class="tab-pane fade active in" id="home">
                    <form class="form-horizontal" action="/coupon_add" method="post">
                        <input type="hidden" name="act" value="add">
                        <input type="hidden" name="types" value="1">
					  <div class="form-group">
					    <label for="money" class="col-sm-2 control-label">面值</label>
					    <div class="col-sm-5">
					      <input type="text" class="form-control" id="money" name="money">
					    </div>
					    <div class="col-sm-1">
					      <div class="linet">元</div>
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="num" class="col-sm-2 control-label">发行量</label>
					    <div class="col-sm-5">
					      <input type="text" class="form-control" id="num" name="num">
					    </div>
					    <div class="col-sm-1">
					      <div class="linet">张</div>
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="starttime" class="col-sm-2 control-label">活动时间</label>
					    <div class="col-sm-5">
						    <div class="col-sm-5" style="padding:0">
                                <input type="datetime" class="form-control" id="starttime" name="page_starttime">
                            </div>
                            <div class="col-sm-2 linet" style="text-align: center;">至</div>
                            <div class="col-sm-5" style="padding:0">
                                <input type="datetime" class="form-control" id="endtime" name="page_endtime">
                            </div>
					    </div>
					    <div class="col-sm-1">
					      <div class="linet">张</div>
					    </div>
					  </div>
					  <div class="form-group">
					    <div class="col-sm-offset-2 col-sm-10">
					      <button type="submit" class="btn btn-primary btn-sm">创  建</button>
					    </div>
					  </div>
                    </form>
                </div>

                <div class="tab-pane fade" id="profile">
                    <form class="form-horizontal" action="/coupon_add" method="post">
                        <input type="hidden" name="act" value="add">
                        <input type="hidden" name="types" value="1">
					  <div class="form-group">
					    <label for="money2" class="col-sm-2 control-label">面值</label>
					    <div class="col-sm-5">
					      <input type="text" class="form-control" id="money2" name="money">
					    </div>
					    <div class="col-sm-1">
					      <div class="linet">元</div>
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="num2" class="col-sm-2 control-label">发行量</label>
					    <div class="col-sm-5">
					      <input type="text" class="form-control" id="num2" name="num">
					    </div>
					    <div class="col-sm-1">
					      <div class="linet">张</div>
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="bid" class="col-sm-2 control-label">选择门店</label>
					    <div class="col-sm-5">
					      <select class="form-control" name="bid" id="bid">
				                  <option value=1>选择门店</option>
				                  <option value=2>2</option>
				                  <option value=3>3</option>
				                  <option value=4>4</option>
				                  <option value=5>5</option>
				            </select>
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="inputPassword3" class="col-sm-2 control-label">使用条件</label>
					    <div class="col-sm-5">
					      <div class="col-sm-2 pd linet">单笔订单满</div>
						<div class="col-sm-2 pd">
							<input type="email" class="form-control" id="inputEmail3" placeholder="">
						</div>
					      <div class="col-sm-3 linet">元可使用此券</div>
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="inputPassword3" class="col-sm-2 control-label">活动时间</label>
					    <div class="col-sm-5">
						<div class="col-sm-5 pd">
						<input type="email" class="form-control" id="inputEmail3" placeholder="">
						</div>
						<div class="col-sm-2 linet" style="text-align: center;">至</div><div class="col-sm-5 pd"><input type="email" class="form-control" id="inputEmail3" placeholder=""></div>
					    </div>
					    <div class="col-sm-1">
					      <div  class="linet">张</div>
					    </div>
					  </div>
					<div class="form-group">
					    <label for="inputPassword3" class="col-sm-2 control-label">每人限领</label>
					    <div class="col-sm-5">
					      <select class="form-control">
				                  <option>1</option>
				                  <option>2</option>
				                  <option>3</option>
				                  <option>4</option>
				                  <option>5</option>
				            </select>

					    </div>
					    <div class="col-sm-1">
					      <div class="linet">张</div>
					    </div>

					  </div>
					    <div class="form-group">
					    <div class="col-sm-offset-2 col-sm-10">
					      <button type="submit" class="btn btn-primary btn-sm">创  建</button>
					    </div>
					  </div>
				</form>
                </div>
              </div>
            </div>
          </div>
        </div><!-- /.row -->
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
<script type="text/javascript" src="js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/locales/bootstrap-datetimepicker.fr.js" charset="UTF-8"></script>
  </body>
</html>
