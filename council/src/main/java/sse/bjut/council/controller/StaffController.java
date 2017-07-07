package sse.bjut.council.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import sse.bjut.council.service.StaffService;
import sse.bjut.council.util.ResTemp;

@RestController
@RequestMapping(value = "/staff")
public class StaffController {

	@Autowired
	StaffService staffService;
	
	@RequestMapping(value = "/reg", method = RequestMethod.POST)
	public ResTemp regStaffByPOST(@RequestParam("name") String name,
			@RequestParam("account") String account,
			@RequestParam("password") String password,
			@RequestParam("phone") String phone,
			@RequestParam("email") String email,
			@RequestParam("depart_id") Integer depart_id){
		return regStaffByGET(name,account,password,phone,email,depart_id);
	}
	
	@RequestMapping(value = "/reg", method = RequestMethod.GET)
	public ResTemp regStaffByGET(@RequestParam("name") String name,
			@RequestParam("account") String account,
			@RequestParam("password") String password,
			@RequestParam("phone") String phone,
			@RequestParam("email") String email,
			@RequestParam("depart_id") Integer depart_id) {
		return staffService.registerStaff(name,account,password,phone,email,depart_id);
	}
	
	@RequestMapping(value = "/listexam", method = RequestMethod.POST)
	public ResTemp listExamStaffByPOST(){
		return listExamStaffByGET();
	}
	
	@RequestMapping(value = "/listexam", method = RequestMethod.GET)
	public ResTemp listExamStaffByGET() {
		return staffService.listExamStaff();
	}
	
	@RequestMapping(value = "/exam", method = RequestMethod.POST)
	public ResTemp examStaffByPOST(@RequestParam("result") String result,
			@RequestParam("staff_id") Integer staff_id){
		return examStaffByGET(result,staff_id);
	}
	
	@RequestMapping(value = "/exam", method = RequestMethod.GET)
	public ResTemp examStaffByGET(@RequestParam("result") String result,
			@RequestParam("staff_id") Integer staff_id) {
		return staffService.examStaff(result,staff_id);
	}
	
	@RequestMapping(value = "/searchstaff", method = RequestMethod.POST)
	public ResTemp searchStaffByPOST(@RequestParam("name") String name,
			@RequestParam("account") String account,
			@RequestParam("state") String state){
		return searchStaffByGET(name,account,state);
	}
	
	@RequestMapping(value = "/searchstaff", method = RequestMethod.GET)
	public ResTemp searchStaffByGET(@RequestParam("name") String name,
			@RequestParam("account") String account,
			@RequestParam("state") String state) {
		return staffService.searchStaff(name,account,state);
	}
}
