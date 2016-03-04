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
                <h1 class="admin_title"><span>优惠券明细</span></h1>
            </div>
        </div><!-- /.row -->

        <div class="row">
            <div class="col-lg-12">
                <div class="table-responsive">
                    <table class="table table-bordered table-hover table-striped tablesorter">
                        <thead>
                        <tr>
                            <th class="header">ID <i class="fa fa-sort"></i></th>
                            <th class="header">领取人<i class="fa fa-sort"></i></th>
                            <th class="header">领取时间<i class="fa fa-sort"></i></th>
                            <th class="header">有效期 <i class="fa fa-sort"></i></th>
                            <th class="header">是否使用 <i class="fa fa-sort"></i></th>
                            <th class="header">使用时间 <i class="fa fa-sort"></i></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${couponInfoList}" var="list">
                            <tr>
                                <td>${list.id}</td>
                                <td>${list.uname}</td>
                                <td><fmt:formatDate value="${list.gettime}" pattern="YYYY-MM-dd"/></td>
                                <td><fmt:formatDate value="${list.starttime}" pattern="YYYY-MM-dd"/>至<fmt:formatDate value="${list.endtime}" pattern="YYYY-MM-dd"/></td>
                                <td>
                                    <c:if test="${list.isuse == 0}">
                                        <span class="btn btn-success btn-xs">未使用</span>
                                    </c:if>
                                    <c:if test="${list.isuse == 1}">
                                        <span class="btn btn-danger btn-xs">已使用</span>
                                    </c:if>
                                </td>
                                <td><fmt:formatDate value="${list.usetime}" pattern="YYYY-MM-dd"/></td>
                            </tr>
                        </c:forEach>
                        <tr>
                            <td colspan="9" class="page_box">
                                <span class="listtable_all">共有${count}条，第${page}页</span>
                                <ul id="pagination"></ul>
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
<script src="js/jquery.twbsPagination.min.js"></script>
<script>
    $(function(){
        var count = ${count};
        $("#pagination").twbsPagination({
            totalPages:Math.ceil(count / 20),
            visiblePages: 5,
            href: '?page={{number}}'
        });
    })
</script>
</body>
</html>
