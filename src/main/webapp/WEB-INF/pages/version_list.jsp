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
    <title>苋菜 - 软件管理</title>
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/sb-admin.css" rel="stylesheet">
    <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/dyj.css">
</head>
<body>
<div id="wrapper">
    <%@ include file="top.jsp"%>
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="admin_title"><span>系统用户管理</span></h1>
            </div>
        </div><!-- /.row -->
        <div class="row">
            <div class="col-lg-12">
                <div class="table-responsive">
                    <table class="table table-bordered table-hover table-striped tablesorter">
                        <thead>
                        <tr>
                            <th class="header">ID<i class="fa fa-sort"></i></th>
                            <th class="header">用户名<i class="fa fa-sort"></i></th>
                            <th class="header">权限 <i class="fa fa-sort"></i></th>
                            <th class="header">最后登录时间 <i class="fa fa-sort"></i></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${adminList}" var="list">
                            <tr>
                                <td>${list.aid}</td>
                                <td>${list.name}</td>
                                <td>
                                    <c:if test="${list.type == 1}">管理员</c:if>
                                    <c:if test="${list.type == 2}">编辑</c:if>
                                    <c:if test="${list.type == 3}">财务</c:if>
                                </td>
                                <td><fmt:formatDate value="${list.logintime}" pattern="YYYY-MM-dd"/></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                        <tr>
                            <td colspan="9" class="page_box">
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
