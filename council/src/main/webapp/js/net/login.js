//$$('#login').on('click', function() {
//			var account = $$('.login-screen input[name="account"]').val();
//			var password = $$('.login-screen input[name="password"]').val();
//			var identity = $$('.login-screen input[name="identity"]:checked').val();
//			var get_data = "account="+account+"&password="+password+"&privilege="+identity;
//			
//			if($$('#account').val() == "") {
//				$$('#pass-label').css('color', '#ddd');
//				$$('#pass-label').css('font-weight', 'normal');
//				$$('#pass-label').css('opacity', '0.9');
//				
//				$$('#acc-label').css('color', '#f00');
//				$$('#acc-label').css('font-weight', 'bold');
//				myApp.alert('账户不能为空！','输入错误');
//			}
//			else if($$('#password').val() == "") {
//				$$('#acc-label').css('color', '#ddd');
//				$$('#acc-label').css('font-weight', 'normal');
//				$$('#acc-label').css('opacity', '0.9');
//				
//				$$('#pass-label').css('color', '#f00');
//				$$('#pass-label').css('font-weight', 'bold');
//				myApp.alert('密码不能为空！','输入错误');
//			}
//			else{
//				myApp.showPreloader();
//				setTimeout(function() {
//					$$.ajax({  
//						url:"login",
//						cache:false,
//						timeout:60000,
//						type:"GET",
//						data:get_data,
//						dataType:'json',
//				        async:false,
//						success:function(data) {
//							var executeCode = data['executeCode'].trim();
//							var account = data['data'];
//							if(executeCode == '100'){
//								var welcome = '欢迎:';
//								var privilege = '';
//								if(account['privilege'] == true){
//									privilege += '管理员 ';
//								}
//								else privilege += '员工 ';
//								welcome += privilege;
//								welcome += account['account'];
//								myApp.alert(welcome,'欢迎');
//								
//								login_info = {
//										staff_id: account['staff_id'],
//										account: account['account'],
//										last_login_time:account['last_login_time'],
//										privilege: {
//											name: privilege,
//											type: account['privilege']
//										} 
//								};
//								
//								/// 为页面缓存添加登陆信息
//								Template7.data.dataCache.loginInfo = login_info;
//								
//								myApp.closeModal('.login-screen');
//								mainView.router.load({
//									url:'selfcenter/index',
//									contextName:'dataCache'
//								});
//							}
//							else {
//								myApp.alert(data["executeResult"],'错误');
//							}
//						},
//						error: function(xhr,status,error){ 
//							 myApp.alert('网络超时！','错误');
//		         		}
//					});
//					myApp.hidePreloader();
//				}, 500);
//			}
//});
//
//$$('#reset').on('click',function(){
//	$$('#account').prop('value','');
//	$$('#password').prop('value','');
//})
//
myApp.closeModal('.login-screen');
mainView.router.load({
	//url:'selfcenter/index',
	url:'councilreserve/checkrooms',
	contextName:'dataCache'
});
