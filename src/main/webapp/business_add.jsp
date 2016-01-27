<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="utf-8"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">
    <!-- Add custom CSS here -->
    <link href="css/sb-admin.css" rel="stylesheet">
    <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
    <title>添加商户</title>
</head>
<body>
<div id="wrapper">
    <%@ include file="WEB-INF/pages/top.jsp"%>
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1>商户管理</h1>
                <ol class="breadcrumb">
                    <li><a href="business.jsp"><i class="fa fa-dashboard"></i> 首页</a></li>
                    <li class="active"><i class="fa fa-table"></i> 商户</li>
                </ol>
            </div>
        </div><!-- /.row -->
        <form id="busineesForm" name="busineesForm" action="/addbusiness">
            <div class="form-group">
                <label>商户名</label>
                <input class="form-control" name="locname">
                <p class="help-block"></p>
            </div>
            <div class="form-group">
                <label>密码</label>
                <input class="form-control" name="pwd">
                <p class="help-block"></p>
            </div>
            <div class="form-group">
                <label>再次输入密码</label>
                <input class="form-control" name="pwd2">
                <p class="help-block"></p>
            </div>
            <div class="form-group">
                <label>手机号</label>
                <input class="form-control" name="mobile">
                <p class="help-block"></p>
            </div>
            <div class="form-group">
                <label>商户地址</label>
                <input class="form-control" name="address">
                <p class="help-block"></p>
            </div>
            <div class="form-group">
                <label>真实姓名</label>
                <input class="form-control" name="realname">
                <p class="help-block"></p>
            </div>
            <div class="form-group">
                <label>身份证号</label>
                <input class="form-control" name="idcard">
                <p class="help-block"></p>
            </div>
            <div class="form-group">
                <label>银行</label>
                <input class="form-control" name="bank">
                <p class="help-block"></p>
            </div>
            <div class="form-group">
                <label>银行</label>
                <input class="form-control" name="bankname">
                <p class="help-block"></p>
            </div>
            <button type="submit" class="btn btn-primary">添加</button>
        </form>
    </div><!-- /#page-wrapper -->
</div><!-- /#wrapper -->
</body>
</html>
