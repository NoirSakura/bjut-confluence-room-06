package sse.bjut.council.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sse.bjut.council.dao.LoginInfoDao;
import sse.bjut.council.dao.StaffInfoDao;
import sse.bjut.council.entity.LoginInfo;
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

		LoginInfo login_info  = loginInfoDao.findByAccount(accountName);
		if(depart == null){
			depart = new Depart();
			depart.setDepartName(departName);
			departInfoDao.save(depart);
			return 0;
			if(staff != null)
				
		}
		
		return Integer.valueOf(exe_code.toString());
	}
	
	public static void resolveExeCode(Integer exeCode) {
		String code = String.valueOf(exeCode);
		if(code.length() != 6) {
			// exe_code error
		}
		else {
			/// code of success
			char c = code.charAt(0);
			switch(c){
			case 1:
				// success
				break;
			case 0:
				// failed
				break;
			}
			
			/// code of staff_name
			c = code.charAt(1);
			switch(c){
			case 0:
				// success
				break;
			case 1:
				// length error
				break;
			}
			
			/// code of account_name
			c = code.charAt(2);
			switch(c){
			case 0:
				// success
				break;
			case 1:
				// already exist
				break;
			case 2:
				// length error
				break;
			}
			
			/// code of password
			c = code.charAt(3);
			switch(c){
			case 0:
				// success
				break;
			case 1:
				// length error
				break;
			}
			
			/// code of staff_phone
			c = code.charAt(4);
			switch(c){
			case 0:
				// success
				break;
			case 1:
				// already exist
				break;
			case 2:
				// length error
				break;
			}

			/// code of staff_email
			c = code.charAt(5);
			switch(c){
			case 0:
				// success
				break;
			case 1:
				// already exist
				break;
			case 2:
				// length error
				break;
			}
		}
	}
	
}
