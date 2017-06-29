function goMyReservation(){

	var get_data = "reserve_id="+Template7.data.myReservations.loginInfo.staff_id;
	myApp.showPreloader();
	setTimeout(function() {
		$$.ajax({  
			url:"council/myresv",
			cache:false,
			timeout:10000,
			type:"GET",
			data:get_data,
			dataType:'json',
	        async:false,
			success:function(data) {
				/// 为页面缓存添加信息
				if(data['executeCode'] == 0){
					Template7.data.myReservations.response.active = false;
				}
				else{
					Template7.data.myReservations.response.active = true;
				}
				
				Template7.data.myReservations.response.data = data['data'];
				Template7.data.myReservations.loginInfo = Template7.data.index.loginInfo;
				mainView.router.load({
					url:'selfcenter/myreservations',
					contextName:'myReservations'
				});
			},
			error: function(xhr,status,error){ 
				 myApp.alert('网络错误：'+error,'错误');
     		}
		});
		myApp.hidePreloader();
	}, 200);
}

function goReserve(){
	var get_data = "reserve_id="+Template7.data.myReservations.loginInfo.staff_id;
	myApp.showPreloader();
	setTimeout(function() {
		$$.ajax({  
			url:"council/myresv",
			cache:false,
			timeout:10000,
			type:"GET",
			data:get_data,
			dataType:'json',
	        async:false,
			success:function(data) {
				/// 为页面缓存添加信息
				if(data['executeCode'] == 0){
					Template7.data.myReservations.response.active = false;
				}
				else{
					Template7.data.myReservations.response.active = true;
				}
				
				Template7.data.myReservations.response.data = data['data'];
				Template7.data.myReservations.loginInfo = Template7.data.index.loginInfo;
				mainView.router.load({
					url:'selfcenter/myreservations',
					contextName:'myReservations'
				});
			},
			error: function(xhr,status,error){ 
				 myApp.alert('网络错误：'+error,'错误');
     		}
		});
		myApp.hidePreloader();
	}, 200);	
}