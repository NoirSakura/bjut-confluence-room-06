<%@ page language="java"  import="java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/include/maintitle.jsp"%>
</head>
<body>
<%@ include file="/include/header.jsp"%>
		<div class="page-body">
<%@ include file="/include/menu.jsp"%>
 <div class="page-content">
                <div class="page-content">
                <div class="content-nav">
                    人员管理 > 注册审批
                </div>
                <table class="listtable">
                    <caption>所有待审批注册信息：</caption>
                    <thead>
	                    <tr class="listheader">
	                        <th>姓名</th>
	                        <th>联系电话</th>
	                        <th>电子邮件</th>
	                        <th>操作</th>
	                    </tr>
                    </thead>
                    <tbody>
	                    <c:forEach items="${staff_list}" var="staff_list" varStatus="status">
		                    <tr id="s${staff_list.id }">
		                        <td>${staff_list.name }</td>
		                        <td>${staff_list.phone }</td>
		                        <td>${staff_list.email }</td>
		                        <td>
		                            <input type="button" class="clickbutton" value="通过" onclick="permitStaff(${staff_list.id })"/>
		                            <input type="button" class="clickbutton" value="删除" onclick="deleteStaff(${staff_list.id })"/>
		                        </td>
		                    </tr>
	                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

<%@ include file="/include/buttom.jsp"%>


</body>


<script type="text/javascript">  
	function permitStaff(staff_id){
		$.ajax({
			type : 'post',
			url : 'staffconfirm',
			data : {id:staff_id,operation:'0'},
			success : function(result) {
				var s=document.getElementById("s"+staff_id);
				if(result=="0"){
					s.remove(s.id);
				}
				else if(result=="1"){
					alert("通过失败");
				}
				
			}
		});
	};
	function deleteStaff(staff_id){
		$.ajax({
			type : 'post',
			url : 'staffconfirm',
			data : {id:staff_id,operation:'1'},
			success : function(result) {
				var btn=document.getElementById("btn"+staff_id);
				if(result=="0"){
					s.remove(s.id);
				}
				else if(result=="1"){
					alert("删除失败");
				}
				
			}
		});
	};
</script>

</html>