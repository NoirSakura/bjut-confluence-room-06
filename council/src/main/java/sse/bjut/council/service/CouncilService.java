package sse.bjut.council.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sse.bjut.council.dao.*;
import sse.bjut.council.entity.*;
import sse.bjut.council.util.*;

@Service
public class CouncilService {
	@Autowired 
	CouncilInfoDao councilInfoDao;
	
	@Autowired
	CouncilRoomDao councilRoomDao;
	
	@Autowired 
	CouncilCancelDao councilCancelDao;
	
	@Autowired
	CouncilAttendanceDao  councilAttendanceDao;
	
	public ResTemp getMyReservations(Integer staff_id) {
		ResTemp res = new ResTemp();
	
		List<Map<String,String>> data_list= new ArrayList<Map<String,String>>();
		
		Iterator<Council> iterator  = councilInfoDao.findByReserveIDAndState(staff_id, 0).iterator(); 
		while(iterator.hasNext()){
			Map<String,String> data = new HashMap<String,String>();
			Council council_data = iterator.next();
			CouncilRoom room = councilRoomDao.findByIdAndDelFlagAndStopFlag
					(council_data.getCouncilRoomID(), false, (short) 0);
			if(room != null) {
				data.put("council_name", council_data.getName());
				data.put("council_room_name", room.getRoomName());
				data.put("start_time", DateProcess.dateFormat(council_data.getStartTime()));
				data.put("stop_time", DateProcess.dateFormat(council_data.getEndTime()));
				data.put("reserve_time", DateProcess.dateFormat(council_data.getReserveTime()));
				data_list.add(data);
			}
		}
		res.setExecuteCode(String.valueOf(data_list.size()));
		res.setExecuteResult("success");
		res.setData(data_list);
		return res;
	}
	
	public ResTemp getMyCouncils(Integer att_id) {
		ResTemp res = new ResTemp();
	
		List<Map<String,String>> data_list= new ArrayList<Map<String,String>>();
		
		Iterator<CouncilAttendance> iterator  = councilAttendanceDao.findByAttIdAndDelFlag(att_id, false).iterator(); 
		while(iterator.hasNext()){
			Map<String,String> data = new HashMap<String,String>();
			CouncilAttendance council_attendance = iterator.next();
			Council council = councilInfoDao.findOne(council_attendance.getCouncilId());
			if(council != null) {
				CouncilRoom room = councilRoomDao.findByIdAndDelFlagAndStopFlag
						(council.getCouncilRoomID(), false, (short) 0);
				if(room != null) {
					data.put("council_name", council.getName());
					data.put("council_room_name", room.getRoomName());
					data.put("start_time", DateProcess.dateFormat(council.getStartTime()));
					data.put("stop_time", DateProcess.dateFormat(council.getEndTime()));
					data.put("reserve_time", DateProcess.dateFormat(council.getReserveTime()));
					data.put("reserve_name", council.getReserveName());
					data_list.add(data);
				}
			}
		}
		res.setExecuteCode(String.valueOf(data_list.size()));
		res.setExecuteResult("success");
		res.setData(data_list);
		return res;
	}
	
	/**
	 * @brief �鿴������
	 * @return ����δɾ���Ļ�����
	 */
	public ResTemp getRooms() {
		ResTemp res = new ResTemp();
		List<CouncilRoom> data_list = councilRoomDao.findByDelFlag(false);
		res.setExecuteCode(String.valueOf(data_list.size()));
		res.setExecuteResult("success");
		res.setData(data_list);
		return res;
	}

	/**
	 * 
	 * @return
	 */
	public ResTemp getRestRooms() {
		ResTemp res = new ResTemp();
		List<CouncilRoom> data_list = councilRoomDao.findByDelFlag(false);
		res.setExecuteCode(String.valueOf(data_list.size()));
		res.setExecuteResult("success");
		return res;
	}

	/**
	 * @brief ��ӻ�����
	 * @return ��ִ����
	 */
	public ResTemp addRoom(Integer roomNo, String roomName, Integer maxNumber, String note, Short stopFlag) {
		ResTemp res = new ResTemp();
		
		StringBuilder executeCode = new StringBuilder("1");
		StringBuilder executeResult = new StringBuilder("");
		
		CouncilRoom councilRoom = null;
		
		// �����ҷ�����жϣ�
		// 0 ͨ��
		// 1 �Ѵ���
		// 2������
		councilRoom = councilRoomDao.findByRoomNoAndDelFlag(roomNo, false);
		if(councilRoom != null){
			if(councilRoom.getStopFlag() == -1){
				executeCode.append(NetStateEnum.NET_INVALID);
				executeResult.append("�û����ҷ���Ų�����\n");
			}
			else {
				executeCode.append(NetStateEnum.NET_DUPLICATE);
				executeResult.append("�û����ҷ�����ѱ�ʹ��\n");
			}
		}
		else{
			executeCode.append(NetStateEnum.NET_PASS);
		}
		
		// �����������жϣ�
		// 0 ͨ��
		// 1 �Ѵ���
		councilRoom = councilRoomDao.findByRoomNameAndDelFlag(roomName, false);
		if(councilRoom != null){
			executeCode.append(NetStateEnum.NET_DUPLICATE);
			executeResult.append("�û��������ѱ�ʹ��\n");
		}
		else {
			executeCode.append(NetStateEnum.NET_PASS);
		}
		
		res.setExecuteCode(executeCode.toString());
		res.setExecuteResult(executeResult.toString());
		
		if(executeResult.toString().length() == 0){
			councilRoom = new CouncilRoom();
			councilRoom.setRoomNo(roomNo);
			councilRoom.setRoomName(roomName);
			councilRoom.setMaxNumber(maxNumber);
			councilRoom.setNote(note);
			councilRoom.setStopFlag(stopFlag);
			councilRoomDao.save(councilRoom);
		}
		
		return res;
	}
}
