package sse.bjut.council.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	public ResTemp getMyCouncilsByPOST(@RequestParam("att_id") Integer att_id){
		return getMyCouncilsByGET(att_id);
	}
	
	@RequestMapping(value = "/mycouncils", method = RequestMethod.GET)
	public ResTemp getMyCouncilsByGET(@RequestParam("att_id") Integer att_id){
		return councilService.getMyCouncils(att_id);
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
}