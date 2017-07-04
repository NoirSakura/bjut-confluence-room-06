package sse.bjut.council.util;

/**
 * @brief 定义了回执编码中各属性编号的意义
 * 
 * @author fht_6
 */
public class NetStateEnum {
	// 通过
	public static final String NET_PASS = "0";
	// 对象属性长度错误
	public static final String NET_WRONG_LENGTH = "1";
	// 对象已存在
	public static final String NET_DUPLICATE = "1";
	// 对象不存在
	public static final String NET_NOT_EXIST = "2";
	// 对象属性匹配错误
	public static final String NET_INCORRECT = "2";
	// 对象不可用
	public static final String NET_INVALID = "2";
	// 对象已删除
	public static final String NET_DELETED = "3";
}
