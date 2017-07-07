package sse.bjut.council.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import sse.bjut.council.dao.*;
import sse.bjut.council.entity.*;
import sse.bjut.council.util.*;

@Service
public class CouncilService {
	@Autowired 
	DepartInfoDao departInfoDao;
	
	@Autowired 
	StaffInfoDao staffInfoDao;
	
	@Autowired 
	CouncilInfoDao councilInfoDao;
	
	@Autowired
	CouncilRoomDao councilRoomDao;
	
	@Autowired 
	CouncilCancelDao councilCancelDao;
	
	@Autowired
	CouncilAttendanceDao  councilAttendanceDao;

	/**
	 * @brief 获取我预定的会议
	 * @param staff_id 我的id
	 * @return 回执编码
	 */
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
				data.put("council_id", council_data.getId().toString());
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
	
	/**
	 * @brief 获取我参加的会议
	 * @param att_id 我的id
	 * @return 回执编码
	 * @throws ParseException 
	 */
	public ResTemp getMyCouncils(Integer att_id) {
		ResTemp res = new ResTemp();
	
		List<Map<String,String>> data_list= new ArrayList<Map<String,String>>();
		
		Iterator<CouncilAttendance> iterator  = councilAttendanceDao.findByAttIdAndDelFlag(att_id, false).iterator(); 
		while(iterator.hasNext()){
			Map<String,String> data = new HashMap<String,String>();
			CouncilAttendance council_attendance = iterator.next();
			Council council = councilInfoDao.findOne(council_attendance.getCouncilId());
			if(council != null && council.getState() == 0) {
				CouncilRoom room = councilRoomDao.findByIdAndDelFlagAndStopFlag
						(council.getCouncilRoomID(), false, (short) 0);
				if(room != null) {
					data.put("council_id", council.getId().toString());
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
	 * @brief 查看会议室
	 * @return 所有未删除的会议室
	 */
	public ResTemp getRooms() {
		ResTemp res = new ResTemp();
		
		List<Map<String,String>> data_list= new ArrayList<Map<String,String>>();
		
		Iterator<CouncilRoom> iterator  = councilRoomDao.findByDelFlagAndStopFlag(false,(short)0).iterator(); 
		while(iterator.hasNext()){
			Map<String,String> data = new HashMap<String,String>();
			CouncilRoom council_room = iterator.next();
				data.put("room_id", council_room.getId().toString());
				data.put("room_no", council_room.getRoomNo().toString());
				data.put("room_name", council_room.getRoomName());
				data.put("max_number", council_room.getMaxNumber().toString());
				String current_state = "";
				switch(council_room.getStopFlag()){
				case 0:
					current_state = "启用";
					break;
				case 1:
					current_state = "停用";
					break;
				case -1:
					current_state = "删除";
					break;
				}
				data.put("current_state", current_state);
				data_list.add(data);
		}
		res.setExecuteCode(String.valueOf(data_list.size()));
		res.setExecuteResult("success");
		res.setData(data_list);
		return res;
	}

	/**
	 * @brief 查看会议室
	 * @param roomId 会议室id 
	 * @return 回执编码
	 */
	public ResTemp checkRoom(Integer roomId) {
		ResTemp res = new ResTemp();
		CouncilRoom room = councilRoomDao.findByIdAndDelFlag(roomId,false);
		if(room == null){
			res.setExecuteCode(NetState.NET_NOT_EXIST);
			res.setExecuteResult("该房间不存在");
		}
		else{
			res.setExecuteCode(NetState.NET_PASS);
			res.setExecuteResult("success");
			Map<String,String> data = new HashMap<String,String>();
			data.put("room_id", room.getId().toString());
			data.put("room_no", room.getRoomNo().toString());
			data.put("room_name", room.getRoomName());
			data.put("max_number", room.getMaxNumber().toString());
			data.put("room_note", room.getNote());
			String room_state = "";
			switch(room.getStopFlag()){
			case 0:
				room_state = "启用";
				break;
			case 1:
				room_state = "停用";
				break;
			case -1:
				room_state = "删除";
				break;
			}
			data.put("room_state", room_state);
			res.setData(data);
		}
		return res;
	}

	/**
	 * @brief 添加会议室
	 * @param roomNo 会议室号
	 * @param roomName 会议室名
	 * @param maxNumber 最大容纳人数
	 * @param roomNote 会议室信息
	 * @param stopFlag 使用状态
	 * @return 回执编码
	 */
	public ResTemp addRoom(Integer roomNo, String roomName, Integer maxNumber, String note, Short stopFlag) {
		ResTemp res = new ResTemp();
		
		StringBuilder executeCode = new StringBuilder("1");
		StringBuilder executeResult = new StringBuilder("");
		
		CouncilRoom councilRoom = null;
		
		// 会议室房间号判断：
		// 0 通过
		// 1 已存在
		// 2不可用
		councilRoom = councilRoomDao.findByRoomNoAndDelFlag(roomNo, false);
		if(councilRoom != null){
			if(councilRoom.getStopFlag() == -1){
				executeCode.append(NetState.NET_INVALID);
				executeResult.append("该会议室房间号不可用\n");
			}
			else {
				executeCode.append(NetState.NET_DUPLICATE);
				executeResult.append("该会议室房间号已被使用\n");
			}
		}
		else{
			executeCode.append(NetState.NET_PASS);
		}
		
		// 会议室名称判断：
		// 0 通过
		// 1 已存在
		councilRoom = councilRoomDao.findByRoomNameAndDelFlag(roomName, false);
		if(councilRoom != null){
			executeCode.append(NetState.NET_DUPLICATE);
			executeResult.append("该会议室名已被使用\n");
		}
		else {
			executeCode.append(NetState.NET_PASS);
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
	
	/**
	 * @brief 更新会议室
	 * @param roomID 会议室id
	 * @param roomNo 会议室号
	 * @param roomName 会议室名
	 * @param maxNumber 最大容纳人数
	 * @param roomNote 会议室信息
	 * @param stopFlag 使用状态
	 * @return 回执编码
	 */
	public ResTemp updateRoom(Integer roomID, Integer roomNo, String roomName, 
			Integer maxNumber, String roomNote, Short stopFlag) {
		ResTemp res = new ResTemp();
		StringBuilder executeCode = new StringBuilder("1");
		StringBuilder executeResult = new StringBuilder("");
		CouncilRoom councilRoom = councilRoomDao.findOne(roomID);
		if(councilRoom != null && councilRoom.getDelFlag() != true){
			councilRoom.setDelFlag(true);
			councilRoomDao.save(councilRoom);
			// 会议室房间号判断：
			// 0 通过
			// 1 已存在
			// 2不可用
			councilRoom = councilRoomDao.findByRoomNoAndDelFlag(roomNo, false);
			if(councilRoom != null){
				if(councilRoom.getStopFlag() == -1){
					executeCode.append(NetState.NET_INVALID);
					executeResult.append("该会议室房间号不可用\n");
				}
				else {
					executeCode.append(NetState.NET_DUPLICATE);
					executeResult.append("该会议室房间号已被使用\n");
				}
			}
			else{
				executeCode.append(NetState.NET_PASS);
			}
			
			// 会议室名称判断：
			// 0 通过
			// 1 已存在
			councilRoom = councilRoomDao.findByRoomNameAndDelFlag(roomName, false);
			if(councilRoom != null){
				executeCode.append(NetState.NET_DUPLICATE);
				executeResult.append("该会议室名已被使用\n");
			}
			else {
				executeCode.append(NetState.NET_PASS);
			}
			
			res.setExecuteCode(executeCode.toString());
			res.setExecuteResult(executeResult.toString());
			
			if(executeResult.toString().length() == 0){
				councilRoom = new CouncilRoom();
				councilRoom.setId(roomID);
				councilRoom.setRoomNo(roomNo);
				councilRoom.setRoomName(roomName);
				councilRoom.setMaxNumber(maxNumber);
				councilRoom.setNote(roomNote);
				councilRoom.setStopFlag(stopFlag);
				councilRoomDao.save(councilRoom);
			}
			else {
				councilRoom = councilRoomDao.findOne(roomID);
				councilRoom.setDelFlag(false);
				councilRoomDao.save(councilRoom);
			}
		}
		else{
			res.setExecuteCode(NetState.NET_NOT_EXIST+"00");
			res.setExecuteResult("该部门不存在");
		}
		return res;
	}
	
	public ResTemp getCouncilInfo(Integer councilId){
		ResTemp res = new ResTemp();
		Map<String,Object> data_list= new HashMap<String,Object>();
		
		Council council = councilInfoDao.findOne(councilId);
		if(council == null){
			res.setExecuteCode(NetState.NET_NOT_EXIST);
			res.setExecuteResult("该会议不存在");
			return res;
		}
		else if(council.getState() != 0){
			res.setExecuteCode(NetState.NET_INVALID);
			res.setExecuteResult("该会议已结束或取消");
			return res;
		}
		else {
			Map<String,String> council_info =  new HashMap<String,String>();
			council_info.put("council_id", council.getId().toString());
			council_info.put("council_name", council.getName());
			council_info.put("start_time", DateProcess.dateFormat(council.getStartTime()));
			council_info.put("end_time", DateProcess.dateFormat(council.getEndTime()));
			council_info.put("council_info", council.getInfo());
			council_info.put("reserve_number", String.valueOf(council.getAttendance()));
			data_list.put("council",council_info);
			
			List<Map<String,String>> attendance_list= new ArrayList<Map<String,String>>();
			
			Iterator<CouncilAttendance> iterator  = councilAttendanceDao.findByCouncilIdAndDelFlag(councilId, false).iterator(); 
			while(iterator.hasNext()){
				Map<String,String> attendence = new HashMap<String,String>();
				CouncilAttendance council_attendance = iterator.next();
				Staff staff = staffInfoDao.findOne(council_attendance.getAttId());
				if(staff != null && !staff.getDelFlag()) {
					attendence.put("attendance_name", staff.getName());
					attendence.put("attendance_phone", staff.getPhone());
					attendence.put("attendance_email", staff.getEmail());
					attendance_list.add(attendence);
				}
			}
			data_list.put("attendance",attendance_list);
			
			res.setExecuteCode(String.valueOf(attendance_list.size()));
			res.setExecuteResult("");
			res.setData(data_list);
			return res;
		}
	}
	
	public ResTemp cancelCouncil(Integer councilId, String cancelReason){
		ResTemp res = new ResTemp();
		Council council = councilInfoDao.findOne(councilId);
		if(council == null){
			res.setExecuteCode(NetState.NET_NOT_EXIST);
			res.setExecuteResult("该会议不存在");
		}
		else{
			if(council.getState() != 0){
				res.setExecuteCode(NetState.NET_ERROR);
				res.setExecuteResult("该会议已结束或被撤销");
			}
			else {
				council.setState(-1);
				CouncilCancel cancel = new CouncilCancel();
				cancel.setCancelId(councilId);
				cancel.setCancelReason(cancelReason);
				cancel.setCancelTime(new Date());
				councilCancelDao.save(cancel);
				councilInfoDao.save(council);
				res.setExecuteCode(NetState.NET_PASS);
				res.setExecuteResult("success");
			}
		}
		return res;
	}
	
	@SuppressWarnings("unchecked")
	public ResTemp getInfo(){
		ResTemp res = new ResTemp();
		Map<String,Object> data_list= new HashMap<String,Object>();
		List<Map<String,String>> room = (List<Map<String, String>>) this.getRooms().getData();
		data_list.put("room", room);

		List<Map<String,Object>> depart_list = new ArrayList<Map<String,Object>>();
		Iterator<Depart> depart_iter  = departInfoDao.findByDelFlag(false).iterator(); 
		while(depart_iter.hasNext()){
			Map<String,Object> depart_info = new HashMap<String,Object>();
			List<Object> staff_list = new ArrayList<Object>();
			Depart depart = depart_iter.next();
			depart_info.put("depart_name",depart.getDepartName());
			Iterator<Staff> staff_iter  = staffInfoDao.findByDepartIDAndDelFlagAndStateAndStopFlag(depart.getId(), false, true, false).iterator(); 
			while(staff_iter.hasNext()){
				Map<String,String> staff_info = new HashMap<String,String>();
				Staff staff = staff_iter.next();
				staff_info.put("staff_id", staff.getId().toString());
				staff_info.put("staff_name", staff.getName());
				staff_list.add(staff_info);
			}
			depart_info.put("staff",staff_list);
			depart_list.add(depart_info);
		}
		data_list.put("depart", depart_list);
		res.setExecuteCode(String.valueOf(room.size()));
		res.setData(data_list);
		return res;
	}
	
	public ResTemp reserve(Integer councilRoomID,Integer reserveID, String councilName,Integer attendance,
			String reserveTime,String startTime,String endTime,String councilInfo,String attendance_list){
		ResTemp res = new ResTemp();
		Staff staff = staffInfoDao.findOne(reserveID);
		if(staff == null){
			res.setExecuteCode(NetState.NET_NOT_EXIST);
			res.setExecuteResult("员工不存在");
			return res;
		}
		Iterator<Council> iterator= councilInfoDao.findByCouncilRoomID(councilRoomID).iterator();
		while(iterator.hasNext()){
			Council council = iterator.next();
			if((startTime.compareTo(DateProcess.dateFormat(council.getStartTime())) <= 0 && endTime.compareTo(DateProcess.dateFormat(council.getStartTime())) >= 0)
					|| (startTime.compareTo(DateProcess.dateFormat(council.getStartTime())) >= 0 && startTime.compareTo(DateProcess.dateFormat(council.getEndTime())) <= 0)
					|| (startTime.compareTo(DateProcess.dateFormat(council.getStartTime())) <= 0 && endTime.compareTo(DateProcess.dateFormat(council.getEndTime())) >= 0)){
				res.setExecuteCode(NetState.NET_INVALID);
				res.setExecuteResult("会议室不可用");
				return res;
			}
		}
		
		Council council = new Council();
		council.setCouncilRoomID(councilRoomID);
		council.setReserveID(reserveID);
		council.setReserveName(staff.getName());
		council.setName(councilName);
		council.setAttendance(attendance);
		council.setReserveTime(DateProcess.parseFromFormate(reserveTime));
		council.setStartTime(DateProcess.parseFromFormate(startTime));
		council.setEndTime(DateProcess.parseFromFormate(endTime));
		council.setInfo(councilInfo);
		councilInfoDao.save(council);
		
		String[] attendanceList = attendance_list.split("-");
		
		for(int i=0;i<attendanceList.length;i++){
			CouncilAttendance council_attendance = new CouncilAttendance();
			council_attendance.setAttId(Integer.valueOf(attendanceList[i]));
			council_attendance.setCouncilId(council.getId());
			councilAttendanceDao.save(council_attendance);
		}
		res.setExecuteCode(NetState.NET_PASS);
		res.setExecuteResult("");
		return res;
	}
	
	/**
	 * @brief 获取取消的会议
	 * @param att_id 我的id
	 * @return 回执编码
	 * @throws ParseException 
	 */
	public ResTemp getCancelled() {
		ResTemp res = new ResTemp();
	
		List<Map<String,String>> data_list= new ArrayList<Map<String,String>>();
		
		Iterator<Council> iterator  = councilInfoDao.findByState(-1).iterator(); 
		while(iterator.hasNext()){
			Map<String,String> data = new HashMap<String,String>();
			Council council = iterator.next();
			CouncilCancel cancel = councilCancelDao.findByCancelId(council.getId());
			CouncilRoom room = councilRoomDao.findByIdAndDelFlagAndStopFlag
					(council.getCouncilRoomID(), false, (short) 0);
			if(room != null) {
				data.put("council_id", council.getId().toString());
				data.put("council_name", council.getName());
				data.put("council_room_name", room.getRoomName());
				data.put("start_time", DateProcess.dateFormat(council.getStartTime()));
				data.put("end_time", DateProcess.dateFormat(council.getEndTime()));
				data.put("cancel_reason", cancel.getCancelReason());
				data_list.add(data);
			}
		}
		res.setExecuteCode(String.valueOf(data_list.size()));
		res.setExecuteResult("success");
		res.setData(data_list);
		return res;
	}
}
