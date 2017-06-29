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
	
	@RequestMapping(value = "/getrooms", method = RequestMethod.POST)
	public ResTemp getRoomsByPOST(){
		return getRoomsByGET();
	}
	
	@RequestMapping(value = "/getrooms", method = RequestMethod.GET)
	public ResTemp getRoomsByGET(){
		return councilService.getRooms();
	}
}