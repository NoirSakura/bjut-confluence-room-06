function goMyReservations(){
	mainView.router.load({
		url:'selfcenter/myreservations',
		contextName:'dataCache'
	});
	var get_data = "reserve_id="+Template7.data.dataCache.loginInfo.staff_id;
	$$.ajax({  
		url:"council/myresv",
		cache:false,
		timeout:10000,
		type:"GET",
		data:get_data,
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
    			url:'selfcenter/myreservations',
    			contextName:'dataCache',
    			reload:true
    		});
		},
		error: function(xhr,status,error){ 
			 myApp.alert('网络错误：'+error,'错误');
 		}
	});
}

function goReserve(){
	Template7.data.myReservations.loginInfo = Template7.data.index.loginInfo;
	alert(Template7.data.index.loginInfo.staff_id);
	mainView.router.load({
		url:'selfcenter/myreservations',
		contextName:'myReservations'
	});
	var get_data = "reserve_id="+Template7.data.myReservations.loginInfo.staff_id;
	setTimeout(function() {
		$$.ajax({  
			url:"council/myresv",
			cache:false,
			timeout:10000,
			type:"GET",
			data:get_data,
			dataType:'json',
	        async:true,
			success:function(data) {
				/// 为页面缓存添加信息
				if(data['executeCode'] == 0){
					Template7.data.myReservations.response.active = false;
				}
				else{
					Template7.data.myReservations.response.active = true;
				}
				
				Template7.data.myReservations.response.data = data['data'];
        		myApp.alert("reload");
            	mainView.router.reloadPage();
			},
			error: function(xhr,status,error){ 
				 myApp.alert('网络错误：'+error,'错误');
     		}
		});
	}, 200);	
}

function goMyCouncils(){
	mainView.router.load({
		url:'selfcenter/mycouncils',
		contextName:'dataCache'
	});
	var get_data = "att_id="+Template7.data.dataCache.loginInfo.staff_id;
	$$.ajax({  
		url:"council/mycouncils",
		cache:false,
		timeout:10000,
		type:"GET",
		data:get_data,
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
    			url:'selfcenter/mycouncils',
    			contextName:'dataCache',
    			reload:true
    		});
		},
		error: function(xhr,status,error){ 
			 myApp.alert('网络错误：'+error,'错误');
 		}
	});
}