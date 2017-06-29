package sse.bjut.council.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sse.bjut.council.dao.LoginInfoDao;
import sse.bjut.council.entity.LoginInfo;
import sse.bjut.council.util.*;

@Service
public class AccountService {
	@Autowired 
	LoginInfoDao loginInfoDao;
	
	/**
	 * @brief 用用户名和密码登陆
	 * 
	 * @param account 登陆用的用户名
	 * @param password 登陆用的密码
	 * 
	 * @return 返回相应模板，其中data为JSONObject
	 */
	public ResTemp login(String account,String password,Boolean privilege) {
		ResTemp res = new ResTemp();
		StringBuilder executeCode = new StringBuilder("1");
		StringBuilder executeResult = new StringBuilder("");
		
		LoginInfo loginInfo = null;
		
		// 账户判断：
		// 0 通过
		// 1 长度错误
		// 2 不存在
		// 3 已经被删除
		if(account.length() < 0 || account.length() > 30){
			executeCode.append(NetStateEnum.NET_WRONG_LENGTH);
			executeResult.append("账号长度错误\n");
		}
		else{
			loginInfo = loginInfoDao.findByAccountAndPrivilege(account, privilege);
			if(loginInfo == null){
				executeCode.append(NetStateEnum.NET_NOT_EXIST);
				executeResult.append("账号不存在\n");
			}
			else{
				if(loginInfo.getDelFlag() == true){
					executeCode.append(NetStateEnum.NET_DELETED);
					executeResult.append("账号已被删除\n");
					loginInfo = null;
				}
				else executeCode.append(NetStateEnum.NET_PASS);
			}
		}	
		
		// 密码判断：
		// 0 通过
		// 1 长度错误
		// 2 密码错误
		if(password.length() < 6 || account.length() > 30){
			executeCode.append(NetStateEnum.NET_WRONG_LENGTH);
			executeResult.append("密码长度错误\n");
			loginInfo = null;
		}
		else{
			if(loginInfo != null && !loginInfo.getPassword().equals(password)) {
				executeCode.append(NetStateEnum.NET_INCORRECT);
				executeResult.append("密码错误\n");
				loginInfo = null;
			}
			else{
				executeCode.append(NetStateEnum.NET_PASS);
			}
		}
		
		res.setExecuteCode(executeCode.toString());
		res.setExecuteResult(executeResult.toString());
		if(loginInfo != null) {
			HashMap<String,String> data = new HashMap<String,String>();
			data.put("staff_id", loginInfo.getStaffId().toString());
			data.put("account", loginInfo.getAccount());
			data.put("privilege", loginInfo.getPrivilege().toString());
			data.put("last_login_time", DateProcess.dateFormat(loginInfo.getLastLoginTime()));
			res.setData(data);
		}
		return res;
	}
}
