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
            <h1 class="admin_title"><span>优惠券</span><a class="btn btn-primary addnewsd" href="coupon_info">添加优惠券</a></h1>
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
			                  <th class="header">发行数 <i class="fa fa-sort"></i></th>
			                  <th class="header">剩余数<i class="fa fa-sort"></i></th>
			                  <th class="header">已使用<i class="fa fa-sort"></i></th>
			                  <th class="header">状态 <i class="fa fa-sort"></i></th>
						<th class="header">操作 <i class="fa fa-sort"></i></th>
		                  </tr>
	                </thead>
	                <tbody>
                    <c:forEach items="${couponList}" var="list">
	                  <tr>
	                    <td><a href="">${list.title}</a></td>
	                    <td>${list.cid}</td>
	                    <td><fmt:formatDate value="${list.creattime}" pattern="YYYY-MM-dd"/></td>
	                    <td><fmt:formatDate value="${list.starttime}" pattern="YYYY-MM-dd"/>至<fmt:formatDate value="${list.endtime}" pattern="YYYY-MM-dd"/></td>
	                    <td>${list.num}</td>
	                    <td>${list.restnum}</td>
	                    <td>${list.usenum}</td>
	                    <td>
                            <c:if test="${list.states == 0}">
                                <span class="btn btn-success btn-xs">正常</span>
                            </c:if>
                            <c:if test="${list.states == 1}">
                                <span class="btn btn-danger btn-xs">关闭</span>
                            </c:if>
                        </td>
	                    <td class="xq_type"><a href="" >编辑</a><em>|</em><a href="coupon_info_list?cid=${list.cid}">明细</a><em>|</em><a href="">作废</a></td>
	                  </tr>
                    </c:forEach>
	                  <tr>
                          <td colspan="9" class="page_box">
                              <span class="listtable_all">共有${count}条，第${page}页</span>
                              <ul class="pagination">
                                  <li><a href="?page=1">首页</a></li>
                                  <li><a href="?page=${page-1}">前一页</a></li>
                                  <li><a href="?page=${page+1}">后一页</a></li>
                                  <li><a href="?page=${count%20+1}">末页</a></li>
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
