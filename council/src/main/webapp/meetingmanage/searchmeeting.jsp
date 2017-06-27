<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<div class="page-content">
	<div class="content-nav">会议预定 > 搜索会议</div>
	<form>
		<fieldset>
			<legend>搜索会议</legend>
			<table class="formtable">
				<tr>
					<td>会议名称：</td>
					<td><input type="text" id="meetingname" maxlength="20" /></td>
					<td>会议室名称：</td>
					<td><input type="text" id="roomname" maxlength="20" /></td>
					<td>预定者姓名：</td>
					<td><input type="text" id="reservername" maxlength="20" /></td>
				</tr>
				<tr>
					<td>预定日期：</td>
					<td colspan="5">从&nbsp;<input type="date" id="reservefromdate"
						placeholder="例如：2013-10-20" /> 到&nbsp;<input type="date"
						id="reservetodate" placeholder="例如：2013-10-22" />
					</td>
				</tr>
				<tr>
					<td>会议日期：</td>
					<td colspan="5">从&nbsp;<input type="date" id="meetingfromdate"
						placeholder="例如：2013-10-20" /> 到&nbsp;<input type="date"
						id="meetingtodate" placeholder="例如：2013-10-22" />
					</td>
				</tr>
				<tr>
					<td colspan="6" class="command"><input type="button"
						class="clickbutton" value="查询" /> <input type="reset"
						class="clickbutton" value="重置" /></td>
				</tr>
			</table>
		</fieldset>
	</form>
	<div>
		<h3 style="text-align: center; color: black">查询结果</h3>
		<div class="pager-header">
			<div class="header-info">
				共<span class="info-number">54</span>条结果， 分成<span class="info-number">6</span>页显示，
				当前第<span class="info-number">1</span>页
			</div>
			<div class="header-nav">
				<input type="button" class="clickbutton" value="首页" /> <input
					type="button" class="clickbutton" value="上页" /> <input
					type="button" class="clickbutton" value="下页" /> <input
					type="button" class="clickbutton" value="末页" /> 跳到第<input
					type="text" id="pagenum" class="nav-number" />页 <input
					type="button" class="clickbutton" value="跳转" />
			</div>
		</div>
	</div>
	<table class="listtable">
		<tr class="listheader">
			<th>会议名称</th>
			<th>会议室名称</th>
			<th>会议开始时间</th>
			<th>会议结束时间</th>
			<th>会议预定时间</th>
			<th>预定者</th>
			<th>操作</th>
		</tr>
		<c:forEach var="item" items="${requestScope.map}">
			<tr>
				<td>${item.key.meetingname}</td>
				<td>${item.value[1]}</td>
				<td>${item.key.starttime}</td>
				<td>${item.key.endtime}</td>
				<td>${item.key.reservationtime}</td>
				<td>${item.value[0]}</td>

				<td><a class="clickbutton" href="meetingdetails.html">查看详情</a></td>
			</tr>
		</c:forEach>

	</table>
</div>
</div>

</head>
<body>

</body>
</html>