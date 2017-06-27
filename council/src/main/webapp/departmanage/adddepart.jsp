<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<div class="page-content">
	<div class="page-content">
		<div class="content-nav">人员管理 > 添加部门</div>
		<form action="AddDeleteDepartmentServlet" method="post">
			<fieldset>
				<legend>添加部门</legend>
				部门名称： <input type="text" name="departmentname" maxlength="20" /> <input
					type="hidden" name="code" value="add"> <input type="submit"
					class="clickbutton" value="添加" />
			</fieldset>
			<table class="depart_table">
				<script type="text/javascript">
window.onload = function(){
if(exe_code==0){
alert("添加部门成功")
}
else
{
alert("添加部门失败")
}
}
</script>
				</form>


				</head>
				<body>

				</body>
				</html>