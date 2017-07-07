// 个人中心
function goIndex(){
	Template7.data.dataCache.response.active=false;
	
	mainView.router.load({
		url:'selfcenter/index',
		contextName:'dataCache'
	});
	
	$$.ajax({  
		url:"council/getcancelled",
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
			var res_data = {
					'cancel':data['data'],
					'mycouncil':[]
			}
			Template7.data.dataCache.response.data = res_data;
    		mainView.router.load({
    			url:'selfcenter/index',
    			contextName:'dataCache',
    			reload:true
    		});
		},
		error: function(xhr,status,error){ 
			 myApp.alert('网络错误：'+error,'错误');
 		}
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
			Template7.data.dataCache.response.active = true;
			
			Template7.data.dataCache.response.data.mycouncil = data['data'];
    		mainView.router.load({
    			url:'selfcenter/index',
    			contextName:'dataCache',
    			reload:true
    		});
		},
		error: function(xhr,status,error){ 
			 myApp.alert('网络错误：'+error,'错误');
 		}
	});
}

function goMyReservations(){
	Template7.data.dataCache.response.active=false;
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

function goMyCouncils(){
	Template7.data.dataCache.response.active=false;
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

// 人员管理
function goDepartManage(){
	Template7.data.dataCache.response.active=false;
	mainView.router.load({
		url:'staffmanage/departmanage',
		contextName:'dataCache'
	});
	listDepart();
}

function goStaffReg(){
	myApp.showPreloader();
	$$.ajax({  
		url:"departmanage/listdepart",
		cache:false,
		timeout:10000,
		type:"GET",
		dataType:'json',
        async:false,
		success:function(data) {
			Template7.data.dataCache.response.data = data['data'];

			mainView.router.load({
				url:'staffmanage/staffreg',
				contextName:'dataCache'
			});
		},
		error: function(xhr,status,error){ 
			 myApp.alert('网络错误：'+error,'错误');
 		}
	});
	myApp.hidePreloader();
}

function goRegExam(){
	Template7.data.dataCache.response.active=false;
	mainView.router.load({
		url:'staffmanage/regexam',
		contextName:'dataCache'
	});
	listExam();
}

function goStaffSearch(){
	Template7.data.dataCache.response.active=false;
	mainView.router.load({
		url:'staffmanage/staffsearch',
		contextName:'dataCache'
	});
}

function goReserve(){
	Template7.data.dataCache.response.active=false;
	myApp.showPreloader();
	setTimeout(function() {
		$$.ajax({  
			url:"council/getinfo",
			cache:false,
			timeout:10000,
			type:"GET",
			dataType:'json',
		    async:false,
			success:function(data) {
				/// 为页面缓存添加信息
				if(data['executeCode'] == 0){
					myApp.alert('当前无可用会议室！');
				}
				else{
					Template7.data.dataCache.response.data = data['data'];
					mainView.router.load({
						url:'councilreserve/reserve',
						contextName:'dataCache'
					});
				}
			},
			error: function(xhr,status,error){ 
				 myApp.alert('网络错误：'+error,'错误');
			}
		});
		myApp.hidePreloader();
	}, 200);
}

// 会议预定
function goAddRoom(){
	Template7.data.dataCache.response.active=false;
	mainView.router.load({
		url:'councilreserve/addroom',
		contextName:'dataCache'
	});
}

function goCheckRooms(){
	Template7.data.dataCache.response.active=false;
	mainView.router.load({
		url:'councilreserve/checkrooms',
		contextName:'dataCache'
	});
	checkRooms();
}

function goCouncilSearch(){
	Template7.data.dataCache.response.active=false;
	mainView.router.load({
		url:'councilreserve/staffsearch',
		contextName:'dataCache'
	});
}