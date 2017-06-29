package sse.bjut.council.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sse.bjut.council.dao.LoginInfoDao;
import sse.bjut.council.dao.StaffInfoDao;
import sse.bjut.council.entity.Staff;

@Service
public class StaffService {
	@Autowired 
	StaffInfoDao staffInfoDao;
	
	@Autowired
	LoginInfoDao loginInfoDao;
	
	public Integer addStaff(String staffName, String accountName, String password,
			String staffPhone, String staffEmail, Integer departID){
		StringBuilder exe_code = new StringBuilder("1");
		Staff staff = new Staff();
		
		if(staffName.length()>0 && staffName.length()<=10){
			staff.setName(staffName);
			exe_code.append('0');
		}
		else {
			exe_code.append('1');
			staff = null;
		}

//		if(depart == null){
//			depart = new Depart();
//			depart.setDepartName(departName);
//			departInfoDao.save(depart);
//			return 0;
//			if(staff != null)
//				
//		}
		
//		
		return Integer.valueOf(exe_code.toString());
	}
	
}
