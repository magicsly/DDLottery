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
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet">
    <link href="css/sb-admin.css" rel="stylesheet">
    <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/dyj.css">
    <link href="css/jquery-confirm.css" rel="stylesheet">
</head>
<body>
    <div id="wrapper">
    <%@ include file="top.jsp"%>
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="admin_title"><span>店铺充值</span><a href="business_list" class="btn btn-link">返回列表</a></h1>
                </div>
            </div><!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <form class="form-horizontal"action="business_recharge" method="post" id="form">
                        <input type="hidden" name="act" value="add">
                        <input type="hidden" name="bid" value="${info.bid}">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">店铺名称:</label>
                            <div class="col-sm-5">
                                ${info.locname}
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="money" class="col-sm-2 control-label">充值金额:</label>
                            <div class="col-sm-5">
                                <input class="form-control" id="money" name="money" value="" check-type="required" required-message="金额不能为空！">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-primary btn-sm">确认</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div><!-- /#page-wrapper -->
    </div><!-- /#wrapper -->
        <!-- JavaScript -->
        <script src="js/jquery-1.10.2.js"></script>
        <script src="js/bootstrap.js"></script>
        <script src="js/bootstrap-datetimepicker.min.js"></script>
        <script src="js/jquery-confirm.js"></script>
        <script src="js/area.js"></script>
        <script type="application/javascript">
            $(function() {
            })
        </script>
</body>
</html>