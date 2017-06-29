package sse.bjut.council.service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @brief �����˻�ִ�����и����Ա�ŵ�����,�ṩһЩ��������
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
