package sse.bjut.council.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sse.bjut.council.dao.DepartInfoDao;
import sse.bjut.council.entity.Depart;

@Service
public class DepartService {
	@Autowired 
	DepartInfoDao departInfoDao;
	
	public Integer addDepart(String departName){
		Depart depart = departInfoDao.findByDepartName(departName);
		if(depart == null){
			depart = new Depart();
			depart.setDepartName(departName);
			departInfoDao.save(depart);
			return 0;
		}
		else return 1;
	}
	
}
