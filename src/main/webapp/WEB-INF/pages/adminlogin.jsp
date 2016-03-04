<%--
  Created by IntelliJ IDEA.
  User: ElNino
  Date: 16/2/25
  Time: 上午9:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>苋菜 - 用户登录</title>
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/sb-admin.css" rel="stylesheet">
    <link rel="stylesheet" href="css/dyj.css">
    <link href="css/jquery-confirm.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="login-panel panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Please Sign In</h3>
                </div>
                <div class="panel-body">
                    <form role="form" action="adminlogin">
                        <fieldset>
                            <div class="form-group">
                                <input class="form-control" placeholder="name" name="name" type="text" autofocus>
                            </div>
                            <div class="form-group">
                                <input class="form-control" placeholder="Password" name="pwd" type="password" value="">
                            </div>
                            <%--<div class="checkbox">--%>
                                <%--<label>--%>
                                    <%--<input name="remember" type="checkbox" value="Remember Me">Remember Me--%>
                                <%--</label>--%>
                            <%--</div>--%>
                            <!-- Change this to a button or input when using this as a form -->
                            <button type="submit" class="btn btn-lg btn-success btn-block">Login</button>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="js/jquery-1.10.2.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/jquery-confirm.js"></script>
</body>
</html>
