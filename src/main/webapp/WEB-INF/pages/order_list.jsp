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
                <h1 class="admin_title"><span>订单管理</span></h1>
            </div>
        </div><!-- /.row -->

        <div class="row">
            <div class="col-lg-12">
                <div class="table-responsive">
                    <table class="table table-bordered table-hover table-striped tablesorter">
                        <thead>
                        <tr>
                            <th class="header">OID<i class="fa fa-sort"></i></th>
                            <th class="header">UID <i class="fa fa-sort"></i></th>
                            <th class="header">BID<i class="fa fa-sort"></i></th>
                            <th class="header">金额<i class="fa fa-sort"></i></th>
                            <th class="header">创建时间 <i class="fa fa-sort"></i></th>
                            <th class="header">状态<i class="fa fa-sort"></i></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${orderList}" var="list">
                            <tr>
                                <td>${list.oid}</td>
                                <td>${list.uid}</td>
                                <td>${list.bid}</td>
                                <td>${list.money}</td>
                                <td><fmt:formatDate value="${list.creattime}" pattern="YYYY-MM-dd"/></td>
                                <td>
                                    <c:if test="${list.state == 0}">
                                        <span class="btn btn-info btn-xs">创建订单</span>
                                    </c:if>
                                    <c:if test="${list.state == 1}">
                                        <span class="btn btn-info btn-xs">抢单中</span>
                                    </c:if>
                                    <c:if test="${list.state == 2}">
                                        <span class="btn btn-warning btn-xs">打印订单</span>
                                    </c:if>
                                    <c:if test="${list.state == 3}">
                                        <span class="btn btn-warning btn-xs">打印中...</span>
                                    </c:if>
                                    <c:if test="${list.state == 4}">
                                        <span class="btn btn-success btn-xs">打印成功</span>
                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
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
<script src="js/raphael-min.js"></script>
<script src="js/morris-0.4.3.min.js"></script>
<script src="js/morris/chart-data-morris.js"></script>
<script src="js/tablesorter/jquery.tablesorter.js"></script>
<script src="js/tablesorter/tables.js"></script>

</body>
</html>
