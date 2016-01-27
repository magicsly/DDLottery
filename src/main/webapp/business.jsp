<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <%@ include file="WEB-INF/pages/top.jsp"%>
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1>商户管理 <small>Sort Your Data</small></h1>
                <ol class="breadcrumb">
                    <li><a href="index.jsp"><i class="fa fa-dashboard"></i> 首页</a></li>
                    <li class="active"><i class="fa fa-table"></i> 商户</li>
                </ol>
            </div>
        </div><!-- /.row -->

        <div class="row">
            <div class="col-lg-6">
                <button type="button" class="btn btn-primary" onclick="location='business_add.jsp'">添加商户</button>
                <div class="table-responsive">
                    <table class="table table-hover tablesorter">
                        <thead>
                        <tr>
                            <th>id</th>
                            <th>商户名</th>
                            <th>手机号</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody id="data">

                        </tbody>
                    </table>
                </div>
                <ul class="pagination pagination-sm">
                    <li class="disabled"><a href="#">&laquo;</a></li>
                    <li class="active"><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li><a href="#">&raquo;</a></li>
                </ul>
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
        $.ajax({
            type: "POST",
            url: "businessList?page=1",
            data:{},
            success: function(data){
                var count = data.count;
                if(count > 0){
                    var h = []

                    for(var i=0;i<count;i++){
                        h[h.length] = "<tr>";
                        h[h.length] = "<td>"+data.list[i].bid+"</td>";
                        h[h.length] = "<td>"+data.list[i].locname+"</td>";
                        h[h.length] = "<td>"+data.list[i].mobile+"</td>";
                        h[h.length] = "<td><a href='business_order?bid="+data.list[i].bid+"'>订单</a></td>";
                        h[h.length] = "</tr>";
                    }
                    $("#data").html(h.join(""));
                }else{
                    alert("无数据");
                }
            },
            error: function(){
                alert("出错");
            }
        });
    });
</script>
</body>
</html>