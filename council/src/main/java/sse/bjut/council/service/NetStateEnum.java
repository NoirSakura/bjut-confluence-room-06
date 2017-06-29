package sse.bjut.council.service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @brief 定义了回执编码中各属性编号的意义,提供一些辅助方法
 * 
 * @author fht_6
 *
 */
public class NetStateEnum {
	public static final String NET_PASS = "0";
	public static final String NET_WRONG_LENGTH = "1";
	public static final String NET_NOT_EXIST = "2";
	public static final String NET_INCORRECT = "2";
	public static final String NET_DELETED = "3";

	/**
	 * @brief 转换时间为标准格式
	 * 
	 * 转化为yyyy-MM-dd HH:mm:ss格式
	 * 
	 * @param date 需要转换的时间
	 * @return 转化后的字符串
	 */
	public static String dateFormat(Date date){
		 SimpleDateFormat myDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 return myDateFormat.format(date);
	}
}
