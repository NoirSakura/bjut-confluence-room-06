<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
                    人员管理 > 员工注册
                </div>
                <form id="staff_form">
                    <fieldset>
                        <legend>员工信息</legend>
                        <table class="staff_table" style="width:50%">
                            <tr>
                                <td>姓名：</td>
                                <td>
                                    <input type="text" id="staff_name" maxlength="10"/>
                                </td>
                            </tr>
                            <tr>
                                <td>账户名：</td>
                                <td>
                                    <input type="text" id="account_name" maxlength="30"/>
                                </td>
                            </tr>
                            <tr>
                                <td>密码：</td>
                                <td>
                                    <input type="password" id="password" maxlength="30" placeholder="请输入6位以上的密码"/>
                                </td>
                            </tr>
                            <tr>
                                <td>确认密码：</td>
                                <td>
                                    <input type="password" id="confirm_password" maxlength="30" onBlur="confirm()"/>
                                </td>
                                <td>
                                	<div id="comfirmmessage"></div>
                                </td>
                            </tr>
                            <tr>
                                <td>联系电话：</td>
                                <td>
                                    <input type="text" id="staff_phone" maxlength="13"/>
                                </td>
                            </tr>
                            <tr>
                                <td>电子邮件：</td>
                                <td>
                                    <input type="text" id="staff_email" maxlength="30"/>
                                </td>
                            </tr>
                            <tr>
							<td>所在部门：</td>
                                <td>
                                    <select name="depart_id">    
	                                     <c:forEach items="${depart_list}" var="depart">
	                                     	<option value="${depart.id}" 
	                                     		<c:if test="${depart_list.id==depart_id}">select</c:if>
	                                     		>${depart.name}
	                                     	</option>
	                                     </c:forEach>
                                     </select>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="6" class="command">
                                    <input type="submit" class="clickbutton" value="注册"/>
                                    <input type="reset" class="clickbutton" value="重置"/>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </form>
            </div>
        </div>
<%@ include file="/include/buttom.jsp"%>

</body>
</html>

<script type="text/javascript">  
	window.onload = function() {
		var exe_code = 0;
		//exe_code = ${exe_code};
		if(exe_code==100)
			alert("注册成功");
		else if(exe_code==110)
			alert("注册失败，账号名已存在");
		
                        
    }
	
	function confirm(){
		if (document.getElementById("password").value != document.getElementById("confirm_password").value) {
			comfirmmessage.innerHTML = "<font color=red>两次输入的密码不相符</font>";
		} else {
			comfirmmessage.innerHTML = "<font color=green>确认密码正确</font>";
		}
	}
</script>