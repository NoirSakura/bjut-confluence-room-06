package sse.bjut.council.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @brief 提供了日期的处理方法
 * 
 * @author fht_6
 */
public class DateProcess {
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
	
	/**
	 * @brief 转换标准格式为时间
	 * 
	 * 转化为yyyy-MM-dd HH:mm:ss格式
	 * 
	 * @param date 需要转换的时间
	 * @return 转化后的Date
	 */
	public static Date parseFromFormate(String date){
		 SimpleDateFormat myDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 try {
			return myDateFormat.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
