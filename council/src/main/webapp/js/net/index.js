function checkDetail(){
	myApp.showPreloader();
	var get_data = "council_id="+$$(this).prop('id').substr(6);
	setTimeout(function() {
		$$.ajax({  
			url:"council/getcouncilinfo",
			cache:false,
			timeout:60000,
			type:"GET",
			data:get_data,
			dataType:'json',
	        async:false,
			success:function(data) {
				var executeCode = data['executeCode'].trim();
				if(data['executeCode'] == 0){
					Template7.data.dataCache.response.active = false;
					Template7.data.dataCache.response.data = data['data'];
					goCouncilDetail();
				}
				else if(data['executeResult'] == ""){
					Template7.data.dataCache.response.active = true;
					Template7.data.dataCache.response.data = data['data'];
					goCouncilDetail();
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

function goCouncilDetail(){
	mainView.router.load({
		url:'councilreserve/councilinfo',
		contextName:'dataCache'
	});
}

function onCancelReserve(){
	var council = Template7.data.dataCache.response.data.council;
	myApp.confirm('确定要撤销'+council.council_name+'吗?',function(){
    	var get_data = "council_id="+council.council_id
    		+"&cancel_reason="+$$('#cancel-reason').val();
		myApp.showPreloader();
		setTimeout(function() {
			$$.ajax({  
				url:"council/councilcancel",
				cache:false,
				timeout:10000,
				type:"GET",
				data:get_data,
				dataType:'json',
		        async:false,
				success:function(data) {
					var executeCode = data['executeCode'].trim();
					if(executeCode == '0'){
						myApp.alert('撤销成功！','成功');
					}
					else {
						myApp.alert(data["executeResult"],'错误');
					}
					goMyReservations();
				},
				error: function(xhr,status,error){ 
					 myApp.alert('网络超时！','错误');
	     		}
			});
			myApp.hidePreloader();
		}, 200);
	});
}