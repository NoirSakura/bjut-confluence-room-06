<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title> 
<style type="text/css">
            #divfrom{
                float:left;
                width:150px;
            }
            #divto{
                float:left;
                width:150px;
            }
            #divoperator{
                float:left;
                width:50px;
                padding:60px 5px;
            }
            #divoperator input[type="button"]{
                margin:10px 0;
            }
            #selDepartments{
                display:block;
                width:100%;
            }
            #selEmployees{
                display:block;
                width:100%;
                height:200px;
            }
            #selSelectedEmployees{
                display:block;
                width:100%;
                height:225px;
            }
        </style>

<div class="page-content">
	<div class="content-nav">会议预定 > 预定会议</div>
	<form>
		<fieldset>
			<legend>会议信息</legend>
			<table class="formtable">
				<tr>
					<td>会议名称：</td>
					<td><input type="text" id="name" maxlength="45" /></td>
				</tr>
				<tr>
					<td>预计参加人数：</td>
					<td><input type="text" id="attendance" maxlength="5" /></td>
				</tr>
				<tr>
					<td>预计开始时间：</td>
					<td><input type="date" id="start_date" /> <input type="time"
						id="start_time" /></td>
				</tr>
				<tr>
					<td>预计结束时间：</td>
					<td><input type="date" id="end_date" /> <input type="time"
						id="end_time" /></td>
				</tr>
				<tr>
					<td>会议室名称：</td>
					<td><select name="room_name">
							<c:forEach items="${room_list}" var="room">
								<option value="${room.name}"
									<c:if test="${room_list.id==room_id}">select</c:if>>${room.name}
								</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td>会议说明：</td>
					<td><textarea id="info" rows="5"></textarea></td>
				</tr>
				<tr>
					<td>选择参会人员：</td>
					<td>
						<div id="divfrom">
						<select name="depart_name">
							<c:forEach items="${depart_list}" var="depart">
								<option value="${depart.name}"
									<c:if test="${depart_list.id==depart_id}">select</c:if>>${depart.name}
								</option>
							</c:forEach>
					</select>
							<select id="selEmployees" name="staff_name">
							<c:forEach items="${staff_list}" var="staff">
								<option value="${staff.name}"
									<c:if test="${staff_list.id==staff_id}">select</c:if>>${staff.name}
								</option>
							</c:forEach>
							</select>
						</div>
						<div id="divoperator">
							<input type="button" class="clickbutton" value="&gt;"
								onclick="selectEmployees()" /> <input type="button"
								class="clickbutton" value="&lt;" onclick="deSelectEmployees()" />
						</div>
						<div id="divto">
							<select id="selSelectedEmployees" multiple="true">
							</select>
						</div>
					</td>
				</tr>
				<tr>
					<td class="command" colspan="2"><input type="submit"
						class="clickbutton" value="预定会议" /> <input type="reset"
						class="clickbutton" value="重置" /></td>
				</tr>
			</table>
		</fieldset>
	</form>
</div>
</div>

</head>
<body>

</body>
</html>