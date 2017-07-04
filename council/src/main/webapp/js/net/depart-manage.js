function addDepart(){
	var departName = $$('#departName').prop('value');
	if(departName == ""){
		$$('#depart-name-label').css('color', '#f00');
		$$('#depart-name-label').css('font-weight', 'bold');
		$$('#departName').prop('value','');
		myApp.alert('部门名不能为空');
	}
	else{
		$$('#depart-name-label').css('color', '#ddd');
		$$('#depart-name-label').css('font-weight', 'normal');
		$$('#depart-name-label').css('opacity', '0.9');
		myApp.showPreloader();

		var get_data = "depart_name="+departName;
		setTimeout(function() {
			$$.ajax({  
				url:"departmanage/adddepart",
				cache:false,
				timeout:60000,
				type:"GET",
				data:get_data,
				dataType:'json',
		        async:false,
				success:function(data) {
					var executeCode = data['executeCode'].trim();
					if(executeCode == '0'){
						myApp.alert('部门添加成功！','成功');
						listDepart();
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

function searchDepart(){
	var departName = $$('#departName').prop('value');
	$$.ajax({  
	url:"departmanage/listdepart",
	cache:false,
	data:"?depart_name="+departName,
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
			url:'staffmanage/departmanage',
			contextName:'dataCache',
			reload:true
		});
		$$('#departName').prop('value',departName);
	},
	error: function(xhr,status,error){ 
		 myApp.alert('网络错误：'+error,'错误');
		}
});
}

function listDepart(){
	$$.ajax({  
		url:"departmanage/listdepart",
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
    			url:'staffmanage/departmanage',
    			contextName:'dataCache',
    			reload:true
    		});
		},
		error: function(xhr,status,error){ 
			 myApp.alert('网络错误：'+error,'错误');
 		}
	});
}


function editDepart() {
	var index = $$(this).prop('id').substr(17);
	var depart_name = $$('#depart-name-'+index);
	if($$(this).html() == '<b>编辑</b>'){
		depart_name.data('data',depart_name.prop('value'));
		depart_name.removeAttr('readonly');
		$$(this).html('<b>保存</b>');
		depart_name.focus();
		$$('#label-'+index).removeAttr('hidden');
	}
	else{
		var depart_id = Template7.data.dataCache.response.data[index].depart_id;
		var get_data = "depart_id="+depart_id+"&depart_name="+depart_name.prop('value');
		myApp.showPreloader();
		setTimeout(function() {
			$$.ajax({  
				url:"departmanage/upddepart",
				cache:false,
				timeout:10000,
				type:"GET",
				data:get_data,
				dataType:'json',
		        async:false,
				success:function(data) {
					var executeCode = data['executeCode'].trim();
					if(executeCode == '0'){
						myApp.alert('修改成功！','成功');
						listDepart();
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

function cancelDepart(){
	var index = $$(this).prop('id').substr(14);
	var depart_name = $$('#depart-name-'+index);
	depart_name.prop('value',depart_name.data('data'));
	depart_name.attr('readonly','true');
	$$('#label-'+index).attr('hidden','true');
	$$('#button-edit-save-'+index).html('<b>编辑</b>');
}

function deleteDepart(){
	var depart = Template7.data.dataCache.response.data[$$(this).prop('id').substr(14)];
	myApp.confirm('确定要删除'+depart.depart_name+'吗?',function(){
    	var get_data = "depart_id="+depart.depart_id;
		myApp.showPreloader();
		setTimeout(function() {
			$$.ajax({  
				url:"departmanage/deldepart",
				cache:false,
				timeout:10000,
				type:"GET",
				data:get_data,
				dataType:'json',
		        async:false,
				success:function(data) {
					var executeCode = data['executeCode'].trim();
					if(executeCode == '0'){
						myApp.alert('删除成功！','成功');
					}
					else {
						myApp.alert(data["executeResult"],'错误');
					}
					listDepart();
				},
				error: function(xhr,status,error){ 
					 myApp.alert('网络超时！','错误');
	     		}
			});
			myApp.hidePreloader();
		}, 200);
	});
}

