package sse.bjut.council.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @brief �ṩ�����ڵĴ�����
 * 
 * @author fht_6
 */
public class DateProcess {
	/**
	 * @brief ת��ʱ��Ϊ��׼��ʽ
	 * 
	 * ת��Ϊyyyy-MM-dd HH:mm:ss��ʽ
	 * 
	 * @param date ��Ҫת����ʱ��
	 * @return ת������ַ���
	 */
	public static String dateFormat(Date date){
		 SimpleDateFormat myDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 return myDateFormat.format(date);
	}
}
