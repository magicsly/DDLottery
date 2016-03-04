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
    <title>苋菜 - 提款管理</title>
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/sb-admin.css" rel="stylesheet">
    <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
    <link href="css/jquery-confirm.css" rel="stylesheet">
    <link rel="stylesheet" href="css/dyj.css">
</head>

<body>

<div id="wrapper">
    <%@ include file="top.jsp"%>
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="admin_title"><span>账户明细</span></h1>
            </div>
        </div><!-- /.row -->

        <div class="row">
            <div class="col-lg-12">
                <div class="table-responsive">
                    <table class="table table-bordered table-hover table-striped tablesorter">
                        <thead>
                        <tr>
                            <th class="header">时间<i class="fa fa-sort"></i></th>
                            <th class="header">操作金额<i class="fa fa-sort"></i></th>
                            <th class="header">现有余额<i class="fa fa-sort"></i></th>
                            <th class="header">类型<i class="fa fa-sort"></i></th>
                            <th class="header">信息<i class="fa fa-sort"></i></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${accountList}" var="list">
                            <tr>
                                <td><fmt:formatDate value="${list.creattime}" pattern="YYYY-MM-dd hh:mm"/></td>
                                <td> ${list.money}</td>
                                <td>${list.nowmoney}</td>
                                <c:if test="${list.type == 1}">
                                    <td><button type="button" class="btn btn-outline btn-danger">充值</button></td>
                                </c:if>
                                <c:if test="${list.type == 2}">
                                    <td><button type="button" class="btn btn-outline btn-success">提款</button></td>
                                </c:if>
                                <c:if test="${list.type == 3}">
                                    <td><button type="button" class="btn btn-outline btn-success">购买优惠券</button></td>
                                </c:if>
                                <c:if test="${list.type == 4}">
                                    <td><button type="button" class="btn btn-outline btn-danger">核销优惠券</button></td>
                                </c:if>
                                <c:if test="${list.type == 5}">
                                    <td><button type="button" class="btn btn-outline btn-danger">撤销提款</button></td>
                                </c:if>
                                <td>${list.msg}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                        <tr>
                            <td colspan="10" class="page_box">
                                <span class="listtable_all">共有${count}条，第${page}页</span>
                                <ul id="pagination"></ul>
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
<script src="js/jquery-confirm.js"></script>
<script src="js/jquery.twbsPagination.min.js"></script>
<script>
    $(function() {
        var count = ${count};
        $("#pagination").twbsPagination({
            totalPages:Math.ceil(count / 20),
            visiblePages: 5,
            href: '?page={{number}}&bid=${bid}'
        });
    });
</script>
</body>
</html>
