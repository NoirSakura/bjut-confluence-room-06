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
	
	@RequestMapping("/selfcenter/mycouncils")
	public String myCouncils() {
		return "selfcenter/mycouncils";
	}
	
	@RequestMapping("/selfcenter/myreservations")
	public String myReservations() {
		return "selfcenter/myreservations";
	}
	
	// ����Ԥ��
	@RequestMapping("/councilreserve/reserve")
	public String reserve() {
		return "councilreserve/reserve";
	}
}