<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="./css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.11/css/jquery.dataTables.min.css">
	<script type="text/javascript" language="javascript" src="http://code.jquery.com/jquery-1.12.0.min.js"></script>
	<script type="text/javascript" language="javascript" src="./js/bootstrap.js"></script>
	<script type="text/javascript" language="javascript" src="https://cdn.datatables.net/1.10.11/js/jquery.dataTables.min.js"></script>
<title>DataTable测试</title>
</head>
<body>
<h3>这是通过Ajax获取数据的页面</h3>
<hr/>

<table id="example" class="display" cellspacing="0" width="100%">
        <thead>
            <tr>
                <th>学号</th>
                <th>姓名</th>
                <th>Age</th>
                <th>Email</th>
            </tr>
        </thead>
        <tfoot>
            <tr>
                <th>学号</th>
                <th>姓名</th>
                <th>Age</th>
                <th>Email</th>
            </tr>
        </tfoot>
    </table>
<script type="text/javascript">
$(document).ready(function() {
	$('#example').DataTable( {
        "ajax": "AjaxDataSource",
        "language": {
            "url": "//cdn.datatables.net/plug-ins/1.10.11/i18n/Chinese.json"
        }
    } );
});

</script>
</body>
</html>