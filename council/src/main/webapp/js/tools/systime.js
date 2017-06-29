/**
 * @brief 显示系统当前时间
 */


function getCurDate(){
 var date = new Date();
 var week;
 switch (date.getDay()){
 	case 1: week="星期一"; break;
	 case 2: week="星期二"; break;
	 case 3: week="星期三"; break;
	 case 4: week="星期四"; break;
	 case 5: week="星期五"; break;
	 case 6: week="星期六"; break;
	 default: week="星期天";
 }
 var years = date.getFullYear();
 var month = add_zero(date.getMonth()+1);
 var days = add_zero(date.getDate());
 var hours = add_zero(date.getHours());
 var minutes = add_zero(date.getMinutes());
 var seconds=add_zero(date.getSeconds());
 var sysDate = "系统时间:  "+years+"年"+month+"月"+days+"日 "+hours+":"+minutes+":"+seconds+" "+week;
 $$('.systime').html(sysDate);
}

function add_zero(temp){
 if(temp<10) 
	 return "0"+temp;
 else return temp;
}

setInterval("getCurDate()",100);