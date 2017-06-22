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
                <div class="content-nav">
                    会议预定 > 搜索员工
                </div>
                <form>
                    <fieldset>
                        <legend>搜索员工</legend>
                        <table class="formtable">
                            <tr>
                                <td>姓名：</td>
                                <td>
                                    <input type="text" id="staff_name" maxlength="20"/>
                                </td>
                                <td>状态：</td>
                                <td>
                                    <input type="radio" id="status" name="status" value="0" checked="checked"/><label>已批准</label>
                                    <input type="radio" id="status" name="status" value="1"/><label>待审批</label>
                                    <input type="radio" id="status" name="status" value="2"/><label>已关闭</label>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="6" class="command">
                                    <input type="submit" class="clickbutton" value="查询"/>
                                    <input type="reset" class="clickbutton" value="重置"/>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </form>
<%@ include file="/include/page.jsp"%>
                <table class="listtable">
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
	                    	<tr>  
		                    	<td>${staff_list.name }</td>
		                    	<td>${staff_list.phone }</td>
		                    	<td>${staff_list.email }</td>
		                    	<td>
		                    		<button id="btn${staff_list.id }" type="button" class="clickbutton" onclick="closeAccount(${staff_list.id })">关闭账号</button>
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
	function closeAccount(staff_id){
		$.ajax({
			type : 'post',
			url : 'stafflist',
			data : {id:staff_id},
			success : function(result) {
				var btn=document.getElementById("btn"+staff_id);
				if(result=="0"){
					btn.innerHtml="开启账号";
				}
				else if(result=="1"){
					btn.innerHtml="关闭账号";
				}
				
			}
		});
	};
</script>

</html>