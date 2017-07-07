package sse.bjut.council.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sse.bjut.council.service.CouncilService;
import sse.bjut.council.util.ResTemp;

@RestController
@RequestMapping(value = "/council")
public class CouncilController {
	
	@Autowired
	CouncilService councilService;
	
	@RequestMapping(value = "/myresv", method = RequestMethod.POST)
	public ResTemp getMyReservationsByPOST(@RequestParam("reserve_id") Integer reserve_id){
		return getMyReservationsByGET(reserve_id);
	}
	
	@RequestMapping(value = "/myresv", method = RequestMethod.GET)
	public ResTemp getMyReservationsByGET(@RequestParam("reserve_id") Integer reserve_id){
		return councilService.getMyReservations(reserve_id);
	}
	
	@RequestMapping(value = "/mycouncils", method = RequestMethod.POST)
	public ResTemp getMyCouncilsByPOST(@RequestParam("att_id") Integer att_id) {
		return getMyCouncilsByGET(att_id);
	}
	
	@RequestMapping(value = "/mycouncils", method = RequestMethod.GET)
	public ResTemp getMyCouncilsByGET(@RequestParam("att_id") Integer att_id) {
		return councilService.getMyCouncils(att_id);
	}
	
	@RequestMapping(value = "/getcancelled", method = RequestMethod.POST)
	public ResTemp getMyCouncilsByPOST() {
		return getCancelledByGET();
	}
	
	@RequestMapping(value = "/getcancelled", method = RequestMethod.GET)
	public ResTemp getCancelledByGET() {
		return councilService.getCancelled();
	}
	
	@RequestMapping(value = "/getrooms", method = RequestMethod.POST)
	public ResTemp getRoomsByPOST(){
		return getRoomsByGET();
	}
	
	@RequestMapping(value = "/getrooms", method = RequestMethod.GET)
	public ResTemp getRoomsByGET(){
		return councilService.getRooms();
	}
	
	@RequestMapping(value = "/addroom", method = RequestMethod.POST)
	public ResTemp addRoomByPOST(@RequestParam("room_no") Integer room_no,
			@RequestParam("room_name") String room_name,
			@RequestParam("max_number") Integer max_number,
			@RequestParam("note") String note,
			@RequestParam("stop_flag") Short stop_flag){
		return addRoomByGET(room_no,room_name,max_number,note,stop_flag);
	}
	
	@RequestMapping(value = "/addroom", method = RequestMethod.GET)
	public ResTemp addRoomByGET(@RequestParam("room_no") Integer room_no,
			@RequestParam("room_name") String room_name,
			@RequestParam("max_number") Integer max_number,
			@RequestParam("note") String note,
			@RequestParam("stop_flag") Short stop_flag){
		return councilService.addRoom(room_no,room_name,max_number,note,stop_flag);
	}

	@RequestMapping(value = "/checkroom", method = RequestMethod.POST)
	public ResTemp checkRoomByPOST(@RequestParam("room_id") Integer room_id){
		return checkRoomByGET(room_id);
	}

	@RequestMapping(value = "/checkroom", method = RequestMethod.GET)
	public ResTemp checkRoomByGET(@RequestParam("room_id") Integer room_id){
		return councilService.checkRoom(room_id);
	}
	
	@RequestMapping(value = "/updroom", method = RequestMethod.POST)
	public ResTemp updRoomByPOST(@RequestParam("room_id") Integer room_id,
			@RequestParam("room_no") Integer room_no,
			@RequestParam("room_name") String room_name,
			@RequestParam("max_number") Integer max_number,
			@RequestParam("room_note") String room_note,
			@RequestParam("stop_flag") Short stop_flag){
		return updRoomByGET(room_id,room_no,room_name,max_number,room_note,stop_flag);
	}

	@RequestMapping(value = "/updroom", method = RequestMethod.GET)
	public ResTemp updRoomByGET(@RequestParam("room_id") Integer room_id,
			@RequestParam("room_no") Integer room_no,
			@RequestParam("room_name") String room_name,
			@RequestParam("max_number") Integer max_number,
			@RequestParam("room_note") String room_note,
			@RequestParam("stop_flag") Short stop_flag){
		return councilService.updateRoom(room_id,room_no,room_name,max_number,room_note,stop_flag);
	}

	@RequestMapping(value = "/getcouncilinfo", method = RequestMethod.POST)
	public ResTemp getCouncilInfoByPOST(@RequestParam("council_id") Integer council_id){
		return getCouncilInfoByGET(council_id);
	}
	
	@RequestMapping(value = "/getcouncilinfo", method = RequestMethod.GET)
	public ResTemp getCouncilInfoByGET(@RequestParam("council_id") Integer council_id){
		return councilService.getCouncilInfo(council_id);
	}

	@RequestMapping(value = "/councilcancel", method = RequestMethod.POST)
	public ResTemp cancelCouncilByPOST(@RequestParam("council_id") Integer council_id,
			@RequestParam("cancel_reason") String cancel_reason){
		return cancelCouncilByGET(council_id,cancel_reason);
	}
	
	@RequestMapping(value = "/councilcancel", method = RequestMethod.GET)
	public ResTemp cancelCouncilByGET(@RequestParam("council_id") Integer council_id,
			@RequestParam("cancel_reason") String cancel_reason){
		return councilService.cancelCouncil(council_id,cancel_reason);
	}
	
	@RequestMapping(value = "/getinfo", method = RequestMethod.POST)
	public ResTemp getInfoByPOST(){
		return getInfoByGET();
	}
	
	@RequestMapping(value = "/getinfo", method = RequestMethod.GET)
	public ResTemp getInfoByGET(){
		return councilService.getInfo();
	}
	
	@RequestMapping(value = "/reserve", method = RequestMethod.POST)
	public ResTemp reserveByPOST(@RequestParam("council_room_id") Integer council_room_id,
			@RequestParam("reserve_id") Integer reserve_id,
			@RequestParam("council_name") String council_name,
			@RequestParam("attendance") Integer attendance,
			@RequestParam("reserve_time") String reserve_time,
			@RequestParam("start_time") String start_time,
			@RequestParam("end_time") String end_time,
			@RequestParam("council_info") String council_info,
			@RequestParam("attendance_list") String attendance_list){
		return reserveByGET(council_room_id,reserve_id,council_name,
				attendance,reserve_time,start_time,end_time,council_info,attendance_list);
	}
	
	@RequestMapping(value = "/reserve", method = RequestMethod.GET)
	public ResTemp reserveByGET(@RequestParam("council_room_id") Integer council_room_id,
			@RequestParam("reserve_id") Integer reserve_id,
			@RequestParam("council_name") String council_name,
			@RequestParam("attendance") Integer attendance,
			@RequestParam("reserve_time") String reserve_time,
			@RequestParam("start_time") String start_time,
			@RequestParam("end_time") String end_time,
			@RequestParam("council_info") String council_info,
			@RequestParam("attendance_list") String attendance_list){
		return councilService.reserve(council_room_id,reserve_id,council_name,
				attendance,reserve_time,start_time,end_time,council_info,attendance_list);
	}
	
}