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
	 * @brief ���û����������½
	 * 
	 * @param account ��½�õ��û���
	 * @param password ��½�õ�����
	 * 
	 * @return ������Ӧģ�壬����dataΪJSONObject
	 */
	public ResTemp login(String account,String password,Boolean privilege) {
		ResTemp res = new ResTemp();
		StringBuilder executeCode = new StringBuilder("1");
		StringBuilder executeResult = new StringBuilder("");
		
		LoginInfo loginInfo = null;
		
		// �˻��жϣ�
		// 0 ͨ��
		// 1 ���ȴ���
		// 2 ������
		// 3 �Ѿ���ɾ��
		if(account.length() < 0 || account.length() > 30){
			executeCode.append(NetStateEnum.NET_WRONG_LENGTH);
			executeResult.append("�˺ų��ȴ���\n");
		}
		else{
			loginInfo = loginInfoDao.findByAccountAndPrivilege(account, privilege);
			if(loginInfo == null){
				executeCode.append(NetStateEnum.NET_NOT_EXIST);
				executeResult.append("�˺Ų�����\n");
			}
			else{
				if(loginInfo.getDelFlag() == true){
					executeCode.append(NetStateEnum.NET_DELETED);
					executeResult.append("�˺��ѱ�ɾ��\n");
					loginInfo = null;
				}
				else executeCode.append(NetStateEnum.NET_PASS);
			}
		}	
		
		// �����жϣ�
		// 0 ͨ��
		// 1 ���ȴ���
		// 2 �������
		if(password.length() < 6 || account.length() > 30){
			executeCode.append(NetStateEnum.NET_WRONG_LENGTH);
			executeResult.append("���볤�ȴ���\n");
			loginInfo = null;
		}
		else{
			if(loginInfo != null && !loginInfo.getPassword().equals(password)) {
				executeCode.append(NetStateEnum.NET_INCORRECT);
				executeResult.append("�������\n");
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
