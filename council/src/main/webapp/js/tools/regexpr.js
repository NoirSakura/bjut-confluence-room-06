/**
 * @brief 邮箱正则表达式
 * @param str 输入字符串
 * @returns 匹配结果
 */
function isEmail(str){ 
	var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/; 
	return reg.test(str); 
} 
/**
 * @brief 账号正则表达式
 * @param str 输入字符串
 * @returns 匹配结果
 */
function isAccount(str){ 
	var reg = /^[a-zA-Z]\w{5,29}$/; 
	return reg.test(str); 
} 
/**
 * @brief 电话正则表达式
 * @param str 输入字符串
 * @returns 匹配结果
 */
function isPhone(str){
	var reg = /^1[3|4|5|7|8][0-9]{9}$/; 
	return reg.test(str); 
}