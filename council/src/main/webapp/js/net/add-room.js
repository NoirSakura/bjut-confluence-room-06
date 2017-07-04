function onAddRoom(){
	var roomNo = $$('#roomNo').prop('value');
	if(roomNo == "" || roomNo <0 || roomNo > 65535){
		$$('#room-no-label').css('color', '#f00');
		$$('#room-no-label').css('font-weight', 'bold');
		$$('#roomNo').prop('value','');
		myApp.alert('门牌号应为1-5位，且不大于65535','输入错误');
	}
	else{
		$$('#room-no-label').css('color', '#ddd');
		$$('#room-no-label').css('font-weight', 'normal');
		$$('#room-no-label').css('opacity', '0.9');

		var roomName = $$('#roomName').prop('value');
		if(roomName == ""){
			$$('#room-name-label').css('color', '#f00');
			$$('#room-name-label').css('font-weight', 'bold');
			$$('#roomName').prop('value','');
			myApp.alert('会议室名不能为空','输入错误');
		}
		else{
			$$('#room-name-label').css('color', '#ddd');
			$$('#room-name-label').css('font-weight', 'normal');
			$$('room-name-label').css('opacity', '0.9');
			var maxNumber = $$('#rangeNumber').prop('value');
			var note = $$('#note').prop('value');
			var stopFlag = $$('.item-input input[name="state"]:checked').val();
			myApp.showPreloader();

			var get_data = "room_no="+roomNo
							+"&room_name="+roomName
							+"&max_number="+maxNumber
							+"&note="+note
							+"&stop_flag="+stopFlag;
			setTimeout(function() {
				$$.ajax({  
					url:"council/addroom",
					cache:false,
					timeout:60000,
					type:"GET",
					data:get_data,
					dataType:'json',
			        async:false,
					success:function(data) {
						var executeCode = data['executeCode'].trim();
						if(executeCode == '100'){
							myApp.alert('会议室添加成功！','成功');
							mainView.router.load({
								url:'selfcenter/index',
								contextName:'dataCache'
							});
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

function onAddRoomReset(){
	$$('#roomNo').prop('value','');
	$$('#roomName').prop('value','');
	$$('#maxRange').prop('value','2');
	$$('#rangeNumber').prop('value','20');
}

function onRangeChange(){
	var rangeVal = $$('#maxRange').prop('value');
	$$('#rangeNumber').prop('value',5 * Math.pow(2,rangeVal % 3) * Math.pow(10,Math.floor(rangeVal / 3)));
}