function listExam(){
	$$.ajax({  
		url:"staff/listexam",
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
    			url:'staffmanage/regexam',
    			contextName:'dataCache',
    			reload:true
    		});
		},
		error: function(xhr,status,error){ 
			 myApp.alert('网络错误：'+error,'错误');
 		}
	});
}

function onExamPass() {
	completeExam("pass",Template7.data.dataCache.response.data[$$(this).prop('id').substr(10)].staff_id);
}

function onExamRefuse() {
	completeExam("refuse",Template7.data.dataCache.response.data[$$(this).prop('id').substr(12)].staff_id);
}

function completeExam(result,staff_id) {
	var get_data = "result="+result+"&staff_id="+staff_id;
	myApp.showPreloader();
	setTimeout(function() {
		$$.ajax({  
			url:"staff/exam",
			cache:false,
			timeout:10000,
			type:"GET",
			data:get_data,
			dataType:'json',
	        async:false,
			success:function(data) {
				var executeCode = data['executeCode'].trim();
				if(executeCode == '0'){
					myApp.alert('操作成功！','成功');
					goRegExam();
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