function onReg(){
	resetColor();
	var name = $$('#name').val();
	if(name == "") {
		$$('#name-label').css('color', '#f00');
		$$('#name-label').css('font-weight', 'bold');
		myApp.alert('姓名不能为空！','输入错误');
	}
	else {
		$$('#name-label').css('color', '#ddd');
		$$('#name-label').css('font-weight', 'normal');
		$$('#name-label').css('opacity', '0.9');
		
		var account = $$('#account').val();
		if(!isAccount(account)) {
			$$('#account-label').css('color', '#f00');
			$$('#account-label').css('font-weight', 'bold');
			myApp.alert('账户格式错误！','输入错误');
		}
		else {
			$$('#account-label').css('color', '#ddd');
			$$('#account-label').css('font-weight', 'normal');
			$$('#account-label').css('opacity', '0.9');

			var password = $$('#password').val();
			if(password.length < 6){
				$$('#password-label').css('color', '#f00');
				$$('#password-label').css('font-weight', 'bold');
				myApp.alert('密码长度错误！','输入错误');
			}
			else{
				$$('#password-label').css('color', '#ddd');
				$$('#password-label').css('font-weight', 'normal');
				$$('#password-label').css('opacity', '0.9');

				if($$('#password').val() != $$('#password-confirm').val()){
					$$('#password-confirm-label').css('color', '#f00');
					$$('#password-confirm-label').css('font-weight', 'bold');
					myApp.alert('两次输入的密码不一致！','输入错误');
				}
				else{
					$$('#password-confirm-label').css('color', '#ddd');
					$$('#password-confirm-label').css('font-weight', 'normal');
					$$('#password-confirm-label').css('opacity', '0.9');

					var phone = $$('#phone').val();
					if(!isPhone(phone)){
						$$('#phone-label').css('color', '#f00');
						$$('#phone-label').css('font-weight', 'bold');
						myApp.alert('手机格式错误！','输入错误');
					}
					else{
						$$('#phone-label').css('color', '#ddd');
						$$('#phone-label').css('font-weight', 'normal');
						$$('#phone-label').css('opacity', '0.9');

						var email = $$('#email').val();
						if(!isEmail(email)){
							$$('#email-label').css('color', '#f00');
							$$('#email-label').css('font-weight', 'bold');
							myApp.alert('邮箱格式错误！','输入错误');
						}
						else{
							$$('#email-label').css('color', '#ddd');
							$$('#email-label').css('font-weight', 'normal');
							$$('#email-label').css('opacity', '0.9');
							var depart_id =  $$("#depart_id").val();
							var get_data = "name="+name+"&account="+account+"&password="+password
											+"&phone="+phone+"&email="+email+"&depart_id="+depart_id;
							myApp.showPreloader();
							setTimeout(function() {
								$$.ajax({  
									url:"staff/reg",
									cache:false,
									timeout:60000,
									type:"GET",
									data:get_data,
									dataType:'json',
							        async:false,
									success:function(data) {
										var executeCode = data['executeCode'].trim();
										if(executeCode == '10000'){
											myApp.alert('注册成功！请等待审批','成功');
											goIndex();
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
		}
	}
}

function onRegReset(){
	$$('#name').prop('value','');
	$$('#account').prop('value','');
	$$('#password').prop('value','');
	$$('#password-confirm').prop('value','');
	$$('#phone').prop('value','');
	$$('#email').prop('value','');
}

function resetColor(){
	$$('#name-label').css('color', '#ddd');
	$$('#name-label').css('font-weight', 'normal');
	$$('#name-label').css('opacity', '0.9');
	$$('#account-label').css('color', '#ddd');
	$$('#account-label').css('font-weight', 'normal');
	$$('#account-label').css('opacity', '0.9');
	$$('#password-label').css('color', '#ddd');
	$$('#password-label').css('font-weight', 'normal');
	$$('#password-label').css('opacity', '0.9');
	$$('#password-confirm-label').css('color', '#ddd');
	$$('#password-confirm-label').css('font-weight', 'normal');
	$$('#password-confirm-label').css('opacity', '0.9');
	$$('#phone-label').css('color', '#ddd');
	$$('#phone-label').css('font-weight', 'normal');
	$$('#phone-label').css('opacity', '0.9');
	$$('#email-label').css('color', '#ddd');
	$$('#email-label').css('font-weight', 'normal');
	$$('#email-label').css('opacity', '0.9');
}