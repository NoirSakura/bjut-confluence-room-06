package sse.bjut.council.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sse.bjut.council.dao.*;
import sse.bjut.council.entity.*;
import sse.bjut.council.util.*;

@Service
public class StaffService {
	@Autowired 
	StaffInfoDao staffInfoDao;
	
	@Autowired
	LoginInfoDao loginInfoDao;
	
	@Autowired
	DepartInfoDao departInfoDao;
	
	public ResTemp registerStaff(String name, String account, String password,
			String phone, String email, Integer departID){
		ResTemp res = new ResTemp();
		StringBuilder executeCode = new StringBuilder("1");
		StringBuilder executeResult = new StringBuilder("");
		
		Staff staff;
		if(staffInfoDao.findByEmailAndDelFlag(email, false) != null){
			executeCode.append(NetState.NET_DUPLICATE);
			executeResult.append("该邮箱已经被使用！");
		}
		else{
			executeCode.append(NetState.NET_PASS);
		}
		if(staffInfoDao.findByPhoneAndDelFlag(phone, false) != null) {
			executeCode.append(NetState.NET_DUPLICATE);
			executeResult.append("该手机号已经被使用！");
		}
		else{
			executeCode.append(NetState.NET_PASS);
		}
		Depart depart = departInfoDao.findOne(departID);
		if(depart == null || depart.getDelFlag() == true) {
			executeCode.append(NetState.NET_NOT_EXIST);
			executeResult.append("该部门不存在！");
		}
		else{
			executeCode.append(NetState.NET_PASS);
		}
		LoginInfo login = (loginInfoDao.findByAccount(account));
		if(login != null) {
			if(login.getDelFlag() == false) {
				executeCode.append(NetState.NET_DUPLICATE);
				executeResult.append("该账号已经被使用！");
			}
			else {
				executeCode.append(NetState.NET_INVALID);
				executeResult.append("该账号已经申请，请等待审批！");
			}
		}
		else{
			executeCode.append(NetState.NET_PASS);
		}
		
		res.setExecuteCode(executeCode.toString());
		res.setExecuteResult(executeResult.toString());
		
		if(executeResult.toString().isEmpty()){
			staff = new Staff();
			staff.setName(name);
			staff.setPhone(phone);
			staff.setEmail(email);
			staff.setDepartID(departID);
			staffInfoDao.save(staff);
			
			LoginInfo loginInfo = new LoginInfo();
			loginInfo.setAccount(account);
			loginInfo.setPassword(password);
			loginInfo.setDelFlag(true);
			loginInfo.setStaffId(staff.getId());
			loginInfo.setLastLoginTime(new Date(0));
			loginInfoDao.save(loginInfo);
		}
		return res;
	}
	
	public ResTemp listExamStaff(){
		ResTemp res = new ResTemp();
		List<Map<String,String>> data_list= new ArrayList<Map<String,String>>();
		Iterator<Staff> iterator  = staffInfoDao.findByStateAndDelFlag(false,false).iterator(); 
		while(iterator.hasNext()){
			Map<String,String> data = new HashMap<String,String>();
			Staff staff = iterator.next();
			data.put("staff_id", staff.getId().toString());
			data.put("staff_name", staff.getName());
			data.put("staff_account", loginInfoDao.findByStaffIdAndDelFlag(staff.getId(),true).getAccount());
			data.put("staff_phone", staff.getPhone());
			data.put("staff_email", staff.getEmail());
			data_list.add(data);
		}
		res.setExecuteCode(String.valueOf(data_list.size()));
		res.setExecuteResult("success");
		res.setData(data_list);
		return res;
	}
	
	public ResTemp examStaff(String result, Integer staffId){
		ResTemp res = new ResTemp();
		
		if(result.equals("pass")){
			Staff staff = staffInfoDao.findOne(staffId);
			if(staff == null){
				res.setExecuteResult("员工不存在");
				res.setExecuteCode(NetState.NET_NOT_EXIST);
			}
			else {
				LoginInfo login = loginInfoDao.findByStaffIdAndDelFlag(staffId, true);
				if(login == null){
					res.setExecuteResult("账户不存在");
					res.setExecuteCode(NetState.NET_NOT_EXIST);
				}
				else{
					staff.setState(true);
					staffInfoDao.save(staff);
					login.setDelFlag(false);
					loginInfoDao.save(login);
					res.setExecuteCode(NetState.NET_PASS);
					res.setExecuteResult("success");
				}
			}
		}
		else if(result.equals("refuse")){
			Staff staff = staffInfoDao.findOne(staffId);
			if(staff == null){
				res.setExecuteResult("账户不存在");
				res.setExecuteCode(NetState.NET_NOT_EXIST);
			}
			else{
				staffInfoDao.delete(staffId);
				res.setExecuteCode(NetState.NET_PASS);
				res.setExecuteResult("success");
			}
		}
		else{
			res.setExecuteCode(NetState.NET_ERROR);
			res.setExecuteResult("异常的操作类型");
		}
		return res;
	}
	
	public ResTemp searchStaff(String name,String account,String state){
		ResTemp res = new ResTemp();
		List<Map<String,String>> data_list= new ArrayList<Map<String,String>>();
		Iterator<Staff> iterator;
		if(name.isEmpty()){
			iterator= staffInfoDao.findByDelFlag(false).iterator(); 
		}
		else{
			iterator= staffInfoDao.findByNameAndDelFlag(name,false).iterator(); 
		}
		while(iterator.hasNext()){
			Map<String,String> data = new HashMap<String,String>();
			Staff staff = iterator.next();
			LoginInfo login = null;
			if(!account.isEmpty()){
				login = loginInfoDao.findByAccountAndDelFlag(account,!staff.getState());
				if(login == null || login.getStaffId() != staff.getId()){
					continue;
				}
			}
			if(state.equals("granted") && !staff.getState()){
				continue;
			}
			else if(state.equals("waiting") && staff.getState()){
				continue;
			}
			else if(state.equals("stopped") && !staff.getStopFlag()){
				continue;
			}
			data.put("staff_id", staff.getId().toString());
			data.put("staff_name", staff.getName());
			if(login == null){
				login = loginInfoDao.findByStaffIdAndDelFlag(staff.getId(),!staff.getState());
			} 
			data.put("staff_account", login.getAccount());
			data.put("staff_phone", staff.getPhone());
			data.put("staff_email", staff.getEmail());
			data_list.add(data);
		}
		res.setExecuteCode(String.valueOf(data_list.size()));
		res.setExecuteResult("success");
		res.setData(data_list);
		return res;
	}
}
