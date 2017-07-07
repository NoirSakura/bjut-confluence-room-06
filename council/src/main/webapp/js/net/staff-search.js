function staffSearch(){
	var name = $$('#name').val();
	var account = $$('#account').val();
	var state = $$('input[name="state"]:checked').val();
	if(account != "" && !isAccount(account)) {
		$$('#account-label').css('color', '#f00');
		$$('#account-label').css('font-weight', 'bold');
		myApp.alert('账户格式错误！','输入错误');
	}
	else {
		$$('#account-label').css('color', '#ddd');
		$$('#account-label').css('font-weight', 'normal');
		$$('#account-label').css('opacity', '0.9');
		
		var get_data = "name="+name+"&account="+account+"&state="+state;
		$$.ajax({  
			url:"staff/searchstaff",
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
					url:'staffmanage/staffsearch',
					contextName:'dataCache',
					reload:true
				});
				$$('#name').prop('value',name);
				$$('#account').prop('value',account);	
				$$('input[value=\"'+state+'\"]').prop('checked',true);
			},
			error: function(xhr,status,error){ 
				 myApp.alert('网络错误：'+error,'错误');
			}
		});
	}
}

function resetStaffSearch(){
	$$('#name').prop('value','');
	$$('#account').prop('value','');
}