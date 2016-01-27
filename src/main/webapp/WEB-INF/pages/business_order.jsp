<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String bid = request.getQueryString().replace("bid=","");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Tables - SB Admin</title>
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">
    <!-- Add custom CSS here -->
    <link href="css/sb-admin.css" rel="stylesheet">
    <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
</head>
<body>
<div id="wrapper">
    <%@ include file="top.jsp"%>
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1>出票管理 <small>Sort Your Data</small></h1>
                <ol class="breadcrumb">
                    <li><a href="index.jsp"><i class="fa fa-dashboard"></i> 首页</a></li>
                    <li class="active"><i class="fa fa-table"></i> 出票管理</li>
                </ol>
            </div>
        </div><!-- /.row -->
        <div class="alert alert-success alert-dismissable">
            商户手机号:<%=bid%><br>
            通信md5: ${md5}
        </div>
        <div class="row">
            <div class="col-lg-6">
                <div class="table-responsive">
                    <table class="table table-hover tablesorter">
                        <thead>
                        <tr>
                            <th>id</th>
                            <th>用户id</th>
                            <th>金额</th>
                            <th>出票截止时间</th>
                            <th>状态</th>
                        </tr>
                        </thead>
                        <tbody id="data">

                        </tbody>
                    </table>
                </div>
            </div>
        </div><!-- /.row -->
    </div><!-- /#page-wrapper -->
</div><!-- /#wrapper -->

<!-- JavaScript -->
<script src="js/jquery-1.10.2.js"></script>
<script src="js/bootstrap.js"></script>
<!-- Page Specific Plugins -->
<script src="js/tablesorter/jquery.tablesorter.js"></script>
<script src="js/tablesorter/tables.js"></script>
<script>
    $(function() {
        var bid = GetQueryString("bid");
        $.ajax({
            type: "POST",
            url: "machorder?bid="+bid+"&key=cym",
            data:{},
            success: function(data){

                    var h = []
                    for(var i=0;i<data.list.length;i++){
                        h[h.length] = "<tr>";
                        h[h.length] = "<td>"+data.list[i].oid+"</td>";
                        h[h.length] = "<td>"+data.list[i].uid+"</td>";
                        h[h.length] = "<td>"+data.list[i].money+"</td>";
                        h[h.length] = "<td>"+data.list[i].closetime+"</td>";
                        h[h.length] = "<td>"+data.list[i].state+"</td>";
                        h[h.length] = "</tr>";
                    }
                    $("#data").html(h.join(""));
            },
            error: function(){
                alert("出错");
            }
        });
    });
    function GetQueryString(name)
    {
        var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if(r!=null)return  unescape(r[2]); return null;
    }
</script>
</body>
</html>