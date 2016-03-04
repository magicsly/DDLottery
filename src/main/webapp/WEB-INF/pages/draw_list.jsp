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
                <h1 class="admin_title"><span>提款管理</span></h1>
            </div>
        </div><!-- /.row -->

        <div class="row">
            <div class="col-lg-12">
                <div class="table-responsive">
                    <table class="table table-bordered table-hover table-striped tablesorter">
                        <thead>
                        <tr>
                            <th class="header">ID<i class="fa fa-sort"></i></th>
                            <th class="header">bid <i class="fa fa-sort"></i></th>
                            <th class="header">真实姓名<i class="fa fa-sort"></i></th>
                            <th class="header">银行<i class="fa fa-sort"></i></th>
                            <th class="header">分行 <i class="fa fa-sort"></i></th>
                            <th class="header">卡号<i class="fa fa-sort"></i></th>
                            <th class="header">提款金额<i class="fa fa-sort"></i></th>
                            <th class="header">申请时间<i class="fa fa-sort"></i></th>
                            <th class="header">状态<i class="fa fa-sort"></i></th>
                            <th class="header">操作<i class="fa fa-sort"></i></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${drawList}" var="list">
                            <tr>
                                <td id="did">${list.id}</td>
                                <td>${list.bid}</td>
                                <td>${list.realname}</td>
                                <td>${list.bank}</td>
                                <td>${list.bankname}</td>
                                <td>${list.bancode}</td>
                                <td>${list.money}</td>
                                <td><fmt:formatDate value="${list.creattime}" pattern="YYYY-MM-dd hh:mm"/></td>
                                <td id="state">
                                    <c:if test="${list.state == 0}">
                                        <span class="btn btn-warning btn-xs">申请提款中</span>
                                    </c:if>
                                    <c:if test="${list.state == 1}">
                                        <span class="btn btn-success btn-xs">提款成功</span>
                                    </c:if>
                                    <c:if test="${list.state == 2}">
                                        <span class="btn btn-danger btn-xs">提款撤销</span>
                                    </c:if>
                                </td>
                                <td>
                                    <c:if test="${list.state == 0}">
                                        <a class="btn btn-primary btn-xs sure">确认</a>
                                        <a class="btn btn-primary btn-xs cancel">撤销</a>
                                    </c:if>
                                </td>
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
            href: '?page={{number}}'
        });

        $(".sure").click(function(){
            var tr = $(this).parents("tr");
            var did = tr.find("#did").text();
            $.confirm({
                title: '信息!',
                content: '你是否确认提款!',
                confirmButton: '确认',
                cancelButton: '取消',
                animation: 'rotateX',
                closeAnimation: 'rotateXR',
                confirm: function () {
                    $.ajax({
                        type: "POST",
                        url: "drawstate?id=" + did + "&state=1",
                        data: {},
                        success: function (data) {
                            tr.find("#state").html('<span class="btn btn-success btn-xs">提款成功</span>');
                            $.alert("操作成功")
                        },
                        error: function () {
                            $.alert("操作出错");
                        }
                    });
                }
            });
        });
        $(".cancel").click(function(){
            var tr = $(this).parents("tr");
            var did = tr.find("#did").text();
            $.confirm({
                title: '信息!',
                content: '你是否撤销提款!',
                confirmButton: '确认',
                cancelButton: '取消',
                animation: 'rotateX',
                closeAnimation: 'rotateXR',
                confirm: function () {
                    $.ajax({
                        type: "POST",
                        url: "drawstate?id=" + did + "&state=1",
                        data: {},
                        success: function (data) {
                            tr.find("#state").html('<span class="btn btn-danger btn-xs">提款撤销</span>');
                            $.alert("操作成功")
                        },
                        error: function () {
                            $.alert("操作出错");
                        }
                    });
                }
            });
        });
    });
</script>
</body>
</html>
