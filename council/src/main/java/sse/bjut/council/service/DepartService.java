package sse.bjut.council.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sse.bjut.council.dao.DepartInfoDao;
import sse.bjut.council.entity.Depart;
import sse.bjut.council.util.NetState;
import sse.bjut.council.util.ResTemp;

@Service
public class DepartService {
	@Autowired 
	DepartInfoDao departInfoDao;
	
	public ResTemp addDepart(String departName){
		ResTemp res = new ResTemp();
		Depart depart = departInfoDao.findByDepartNameAndDelFlag(departName,false);
		if(depart == null){
			depart = new Depart();
			depart.setDepartName(departName);
			departInfoDao.save(depart);
			res.setExecuteCode(NetState.NET_PASS);
			res.setExecuteResult("success");
		}
		else{
			res.setExecuteCode(NetState.NET_DUPLICATE);
			res.setExecuteResult("该部门已存在");
		}
		return res;
	}
	
	public ResTemp updateDepart(Integer departId, String departName){
		ResTemp res = new ResTemp();
		Depart depart = departInfoDao.findOne(departId);
		if(depart != null && depart.getDelFlag() == false){
			Depart another = departInfoDao.findByDepartNameAndDelFlag(departName, false);
			if(another != null && another.getId() != departId){
				res.setExecuteCode(NetState.NET_DUPLICATE);
				res.setExecuteResult("该部门名已存在");
			}
			else{
				depart.setDepartName(departName);
				departInfoDao.save(depart);
				res.setExecuteCode(NetState.NET_PASS);
				res.setExecuteResult("success");
			}
		}
		else{
			res.setExecuteCode(NetState.NET_NOT_EXIST);
			res.setExecuteResult("该部门不存在");
		}
		return res;
	}
	
	public ResTemp deleteDepart(Integer departId){
		ResTemp res = new ResTemp();
		Depart depart = departInfoDao.findOne(departId);
		if(depart != null && depart.getDelFlag() == false){
			depart.setDelFlag(true);
			departInfoDao.save(depart);
			res.setExecuteCode(NetState.NET_PASS);
			res.setExecuteResult("success");
		}
		else{
			res.setExecuteCode(NetState.NET_NOT_EXIST);
			res.setExecuteResult("该部门不存在");
		}
		return res;
	}
	
	public ResTemp listDepart(String departName){
		ResTemp res = new ResTemp();
		List<Map<String,String>> data_list= new ArrayList<Map<String,String>>();
		if(!departName.isEmpty()){
			Depart depart = departInfoDao.findByDepartNameAndDelFlag(departName,false);
			if(depart!=null){
				Map<String,String> data = new HashMap<String,String>();
				data.put("depart_id", depart.getId().toString());
				data.put("depart_name", depart.getDepartName());
				data_list.add(data);
			}
		}
		else{
			Iterator<Depart> iterator  = departInfoDao.findByDelFlag(false).iterator(); 
			while(iterator.hasNext()){
				Map<String,String> data = new HashMap<String,String>();
				Depart depart = iterator.next();
				data.put("depart_id", depart.getId().toString());
				data.put("depart_name", depart.getDepartName());
				data_list.add(data);
			}
		}
		res.setExecuteCode(String.valueOf(data_list.size()));
		res.setExecuteResult("success");
		res.setData(data_list);
		return res;
	}
	
	
}
