function onReserve() {
	var attendanceList = dealOptions($$('div.attendance').find('div.item-after').html().split(', '));
	var reserveId = Template7.data.dataCache.loginInfo.staff_id;
	var councilName = $$('#council-name').prop('value');
	if(councilName == ""){
		$$('#council-name-label').css('color', '#f00');
		$$('#council-name-label').css('font-weight', 'bold');
		myApp.alert('会议名不能为空','输入错误');
	}
	else{
		$$('#council-name-label').css('color', '#ddd');
		$$('#council-name-label').css('font-weight', 'normal');
		$$('#council-name-label').css('opacity', '0.9');

		var attendance = $$('#attendance').prop('value');
		if(attendance == "" || attendance <0 || attendance > 10000){
			$$('#attendance-label').css('color', '#f00');
			$$('#attendance-label').css('font-weight', 'bold');
			myApp.alert('参会人员应为1-5位，且不大于10000','输入错误');
		}
		else{
			$$('#attendance-label').css('color', '#ddd');
			$$('#attendance-label').css('font-weight', 'normal');
			$$('#attendance-label').css('opacity', '0.9');

		    var now = new Date();
			var reserve_time = format(now.getFullYear() + "-" + fix((now.getMonth() + 1),2) + "-" + fix(now.getDate(),2) + "T" + fix(now.getHours(),2) + ":" + fix(now.getMinutes(),2));
			var start_time = format($$('#start-time').val());
			var end_time = format($$('#end-time').val());
			
			$$('#start-time-label').css('color', '#ddd');
			$$('#start-time-label').css('font-weight', 'normal');
			$$('#start-time-label').css('opacity', '0.9');
			$$('#end-time-label').css('color', '#ddd');
			$$('#end-time-label').css('font-weight', 'normal');
			$$('#end-time-label').css('opacity', '0.9');
			if(start_time < reserve_time){
				$$('#start-time-label').css('color', '#f00');
				$$('#start-time-label').css('font-weight', 'bold');
				myApp.alert('开始时间不能小于当前时间');
			}
			else if(end_time < reserve_time){
				$$('#end-time-label').css('color', '#f00');
				$$('#end-time-label').css('font-weight', 'bold');
				myApp.alert('结束时间不能小于当前时间');
			}
			else if(end_time < start_time){
				$$('#end-time-label').css('color', '#f00');
				$$('#end-time-label').css('font-weight', 'bold');
				myApp.alert('结束时间不能小于开始时间');
			}
			else {
				var councilRoomId =  $$('#council-room-id').val();
				var get_data = "council_room_id="+councilRoomId+
								"&reserve_id="+reserveId+
								"&council_name="+councilName+
								"&attendance="+attendance+
								"&reserve_time="+reserve_time+
								"&start_time="+start_time+
								"&end_time="+end_time+
								"&council_info="+$$('#council_info').prop('value')+
								"&attendance_list="+attendanceList;
				myApp.showPreloader();
				setTimeout(function() {
					$$.ajax({  
						url:"council/reserve",
						cache:false,
						timeout:60000,
						type:"GET",
						data:get_data,
						dataType:'json',
				        async:false,
						success:function(data) {
							var executeCode = data['executeCode'].trim();
							if(executeCode == '0'){
								myApp.alert('预约成功','成功');
								goMyReservations();
							}
							else {
								myApp.alert(data["executeResult"],'错误');
							}
						},
						error: function(xhr,status,error){ 
							 myApp.alert('网络超时！','错误');
		         		}
					});
					myApp.hidePreloader();
				}, 500);
								
			}
		}
	}
}

function onReserveReset(){
	$$('#council-name').prop('value','');
	$$('#attendance').prop('value','');
	$$('#council_info').prop('value','');
	defaultDateTime();
}

function defaultDateTime() {
    var now = new Date();
    var str = now.getFullYear() + "-" + fix((now.getMonth() + 1),2) + "-" + fix(now.getDate(),2) + "T" + fix(now.getHours(),2) + ":" + fix(now.getMinutes(),2);
    $$("#start-time").val(str);    
    $$("#end-time").val(str);
}

function fix(num, length) {
  return ('' + num).length < length ? ((new Array(length + 1)).join('0') + num).slice(-length) : '' + num;
}

function format(date) {
	return date.substring(0,10) + " " + date.substr(11) + ":00"
}


function dealOptions(choices){	
	var result = '';
	$$.each(choices,function(index,data){
		if(index != 0) {
			result = result +'-'+ data.substr(data.indexOf('-')+1);
		}
		else {
			result = result + data.substr(data.indexOf('-')+1);
		}
	});
	return result;
}