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
                    会议预定 > 搜索员工
                </div>
                <form>
                    <fieldset>
                        <legend>搜索会议</legend>
                        <table class="formtable">
                            <tr>
                                <td>姓名：</td>
                                <td>
                                    <input type="text" id="employeename" maxlength="20"/>
                                </td>
                                <td>账号名：</td>
                                <td>
                                    <input type="text" id="accountname" maxlength="20"/>
                                </td>
                                <td>状态：</td>
                                <td>
                                    <input type="radio" id="status" name="status" value="1" checked="checked"/><label>已批准</label>
                                    <input type="radio" id="status" name="status" value="0"/><label>待审批</label>
                                    <input type="radio" id="status" name="status" value="-1"/><label>已关闭</label>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="6" class="command">
                                    <input type="button" class="clickbutton" value="查询"/>
                                    <input type="reset" class="clickbutton" value="重置"/>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </form>
                <div>
                    <h3 style="text-align:center;color:black">查询结果</h3>
                    <div class="pager-header">
                        <div class="header-info">
                            共<span class="info-number">54</span>条结果，
                            分成<span class="info-number">6</span>页显示，
                            当前第<span class="info-number">1</span>页
                        </div>
                        <div class="header-nav">
                            <input type="button" class="clickbutton" value="首页"/>
                            <input type="button" class="clickbutton" value="上页"/>
                            <input type="button" class="clickbutton" value="下页"/>
                            <input type="button" class="clickbutton" value="末页"/>
                            跳到第<input type="text" id="pagenum" class="nav-number"/>页
                            <input type="button" class="clickbutton" value="跳转"/>
                        </div>
                    </div>
                </div>
                <table class="listtable">
                    <tr class="listheader">
                        <th>姓名</th>
                        <th>账号名</th>
                        <th>联系电话</th>
                        <th>电子邮件</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${staff_list}" var="staff_list">
                    	<td>${staff_list.name }</td>
                    	<td>${staff_list.name }</td>
                    	<td>${staff_list.name }</td>
                    	<td>${staff_list.name }</td>
                    	<td>${staff_list.name }</td>
                    </c:forEach>
                </table>
            </div>
        </div>
        <div class="page-footer">
            <hr/>
            更多问题，欢迎联系<a href="mailto:webmaster@eeg.com">管理员</a>
            <img src="images/footer.png" alt="CoolMeeting"/>
        </div>


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