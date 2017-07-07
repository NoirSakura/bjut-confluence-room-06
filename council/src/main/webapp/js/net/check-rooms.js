function checkRooms(){
	$$.ajax({  
		url:"council/getrooms",
		cache:false,
		timeout:10000,
		type:"GET",
		dataType:'json',
	    async:true,
		success:function(data) {
			/// 为页面缓存添加信息
			if(data['executeCode'] == 0){
				Template7.data.dataCache.response.active = false;
			}
			else{
				Template7.data.dataCache.response.active = true;
			}
			
			Template7.data.dataCache.response.data = data['data'];
			mainView.router.load({
				url:'councilreserve/checkrooms',
				contextName:'dataCache',
				reload:true
			});
		},
		error: function(xhr,status,error){ 
			 myApp.alert('网络错误：'+error,'错误');
		}
	});
}

function checkRoomInfo(){
	var index = $$(this).prop('id').substr(12);
	var get_data = "room_id="+Template7.data.dataCache.response.data[$$(this).prop('id').substr(12)].room_id;
	
	myApp.showPreloader();
	setTimeout(function() {
		$$.ajax({  
			url:"council/checkroom",
			cache:false,
			data:get_data,
			timeout:10000,
			type:"GET",
			dataType:'json',
		    async:false,
			success:function(data) {
				if(data['executeCode'] == 0){
					Template7.data.dataCache.response.data = data['data'];
					mainView.router.load({
						url:'councilreserve/roominfo',
						contextName:'dataCache'
					});
				}
				else{
					myApp.alert(data["executeResult"],'错误');
				}
			},
			error: function(xhr,status,error){ 
				 myApp.alert('网络错误：'+error,'错误');
			}
		});
		myApp.hidePreloader();
	},200);
}

function onEditRoomInfo(){
	if($$('#mod-save').data('mode') == 'mod'){
		$$('input[value="0"]').prop('checked',true);
		$$('#room-no').hide();
		$$('#room-name').hide();
		$$('#room-state').hide();
		$$('#max-number').hide();
    	$$('#room-note').hide();
		$$('#room-no-edit').show();
		$$('#room-name-edit').show();
		$$('#room-state-edit').show();
		$$('#max-number-edit').show();
    	$$('#room-note-edit').show();
    	$$('#rangeNumber').show();
		$$('#mod-save').data('mode','save');
		$$('#mod-save').html('<b>保存</b>');
		$$('#return-cancel').html('<b>取消</b>');
	}
	else{
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

				var get_data = "room_id="+Template7.data.dataCache.response.data.room_id
								+"&room_no="+roomNo
								+"&room_name="+roomName
								+"&max_number="+maxNumber
								+"&room_note="+note
								+"&stop_flag="+stopFlag;
				setTimeout(function() {
					$$.ajax({  
						url:"council/updroom",
						cache:false,
						timeout:60000,
						type:"GET",
						data:get_data,
						dataType:'json',
				        async:false,
						success:function(data) {
							var executeCode = data['executeCode'].trim();
							if(executeCode == '100'){
								myApp.alert('会议室更新成功！','成功');
								Template7.data.dataCache.response.active=false;
								mainView.router.load({
									url:'councilreserve/checkrooms',
									contextName:'dataCache'
								});
								checkRooms();
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
				}, 200);
			}
		}	
	}
}

function onCancelEditRoomInfo(){
	if($$('#mod-save').data('mode') == 'mod'){
		goCheckRooms();
	}
	else{
    	$$('#room-no').show();
    	$$('#room-name').show();
    	$$('#room-state').show();
    	$$('#max-number').show();
    	$$('#room-note').show();
    	$$('#room-no-edit').hide();
    	$$('#room-name-edit').hide();
    	$$('#room-state-edit').hide();
    	$$('#max-number-edit').hide();
    	$$('#room-note-edit').hide();
    	$$('#rangeNumber').hide();

    	$$('#room-no-edit').find('input').prop('value',$$('#room-no').find('input').prop('value'));
    	$$('#room-name-edit').find('input').prop('value',$$('#room-name').find('input').prop('value'));
    	$$('#room-note-edit').html($$('#room-note').html());
    	$$('#rangeNumber').find('input').prop('value',$$('#max-number').find('input').prop('value'));
		$$('#mod-save').data('mode','mod');
		$$('#mod-save').html('<b>修改</b>');
		$$('#return-cancel').html('<b>返回</b>');
	}
}