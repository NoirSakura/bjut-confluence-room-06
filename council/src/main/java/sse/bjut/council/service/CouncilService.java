package sse.bjut.council.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sse.bjut.council.dao.*;
import sse.bjut.council.entity.*;

@Service
public class CouncilService {
	@Autowired 
	CouncilInfoDao councilInfoDao;
	
	@Autowired
	CouncilRoomDao councilRoomDao;
	
	@Autowired 
	CouncilCancelDao councilCancelDao;
	
	public ResTemp getMyReservations(Integer staff_id) {
		ResTemp res = new ResTemp();
	
		List<Map<String,String>> data_list= new ArrayList<Map<String,String>>();
		
		Iterator<Council> iterator  = councilInfoDao.findByReserveIDAndState(staff_id, 0).iterator(); 
		while(iterator.hasNext()){
			Map<String,String> data = new HashMap<String,String>();
			Council council_data = iterator.next();
			CouncilRoom room = councilRoomDao.findByIdAndDelFlagAndStopFlag
					(council_data.getCouncilRoomID(), false, false);
			if(room != null) {
				data.put("council_name", council_data.getName());
				data.put("council_room_name", room.getRoomName());
				data.put("start_time", NetStateEnum.dateFormat(council_data.getStartTime()));
				data.put("stop_time", NetStateEnum.dateFormat(council_data.getEndTime()));
				data.put("reserve_time", NetStateEnum.dateFormat(council_data.getReserveTime()));
				data_list.add(data);
			}
		}
		res.setExecuteCode(String.valueOf(data_list.size()));
		res.setExecuteResult("success");
		res.setData(data_list);
		return res;
	}
}
