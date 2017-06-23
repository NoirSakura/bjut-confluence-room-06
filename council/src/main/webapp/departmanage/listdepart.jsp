<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<div class="page-content">
	<div class="page-content">
		<div class="content-nav">人员管理 > 部门管理</div>
		<table class="listable">
			<tr class="listheader">
				<th>部门编号</th>
				<th>部门名称</th>
				<th>操作</th>
			</tr>
			<c:forEach  items="${depart_list}"  var="depart_list">  
                <td>${depart_list.name}</td>
				<td>${depart_list.name}</td>
				<td>${depart_list.name}</td>


			</c:forEach>
		</table>
</head>
<body>

</body>
</html>