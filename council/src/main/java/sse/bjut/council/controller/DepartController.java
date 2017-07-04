package sse.bjut.council.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sse.bjut.council.service.DepartService;
import sse.bjut.council.util.ResTemp;

@RestController
@RequestMapping(value = "/departmanage")
public class DepartController {
	
	@Autowired
	DepartService departService;
	
	@RequestMapping(value = "/adddepart", method = RequestMethod.POST)
	public ResTemp addDepartByPOST(@RequestParam("depart_name") String depart_name){
		return addDepartByGET(depart_name);
	}
	
	@RequestMapping(value = "/adddepart", method = RequestMethod.GET)
	public ResTemp addDepartByGET(@RequestParam("depart_name") String depart_name) {
		return departService.addDepart(depart_name);
	}
	
	@RequestMapping(value = "/upddepart", method = RequestMethod.POST)
	public ResTemp updDepartByPOST(@RequestParam("depart_id") Integer depart_id,
			@RequestParam("depart_name") String depart_name){
		return updDepartByGET(depart_id,depart_name);
	}
	
	@RequestMapping(value = "/upddepart", method = RequestMethod.GET)
	public ResTemp updDepartByGET(@RequestParam("depart_id") Integer depart_id,
			@RequestParam("depart_name") String depart_name) {
		return departService.updateDepart(depart_id,depart_name);
	}
	
	@RequestMapping(value = "/deldepart", method = RequestMethod.POST)
	public ResTemp delDepartByPOST(@RequestParam("depart_id") Integer depart_id){
		return delDepartByGET(depart_id);
	}
	
	@RequestMapping(value = "/deldepart", method = RequestMethod.GET)
	public ResTemp delDepartByGET(@RequestParam("depart_id") Integer depart_id) {
		return departService.deleteDepart(depart_id);
	}

	@RequestMapping(value = "/listdepart", method = RequestMethod.POST)
	public ResTemp listDepartByPOST(@RequestParam(value="depart_name",required=false) String depart_name){
		return listDepartByGET(depart_name);
	}
	
	@RequestMapping(value = "/listdepart", method = RequestMethod.GET)
	public ResTemp listDepartByGET(@RequestParam(value="depart_name",required=false) String depart_name) {
		return depart_name == null?departService.listDepart(""):departService.listDepart(depart_name);
	}
}
