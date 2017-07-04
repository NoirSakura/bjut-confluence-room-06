package sse.bjut.council.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class ViewController {
	
	@RequestMapping("/entry")
    public String entry() { 
		return "entry";
	}
	
	@RequestMapping("/exit")
	public String exit() {
		return "exit";
	}
	
	// ��������
	@RequestMapping("/selfcenter/index")
	public String index() {
		return "selfcenter/index";
	}
	
	@RequestMapping("/selfcenter/myreservations")
	public String myReservations() {
		return "selfcenter/myreservations";
	}
	
	@RequestMapping("/selfcenter/mycouncils")
	public String myCouncils() {
		return "selfcenter/mycouncils";
	}
	
	// ��Ա����
	@RequestMapping("/staffmanage/departmanage")
	public String departManage() {
		return "staffmanage/departmanage";
	}
	
	// ����Ԥ��
	@RequestMapping("/councilreserve/addroom")
	public String addroom() {
		return "councilreserve/addroom";
	}
	
	@RequestMapping("/councilreserve/checkrooms")
	public String checkrooms() {
		return "councilreserve/checkrooms";
	}
	
	@RequestMapping("/councilreserve/reserve")
	public String reserve() {
		return "councilreserve/reserve";
	}
}