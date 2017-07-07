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
	
	// 个人中心
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
	
	// 人员管理
	@RequestMapping("/staffmanage/departmanage")
	public String departManage() {
		return "staffmanage/departmanage";
	}

	@RequestMapping("/staffmanage/staffreg")
	public String staffReg() {
		return "staffmanage/staffreg";
	}
	
	@RequestMapping("/staffmanage/regexam")
	public String regExam() {
		return "staffmanage/regexam";
	}
	
	@RequestMapping("/staffmanage/staffsearch")
	public String staffSearch() {
		return "staffmanage/staffsearch";
	}
	
	// 会议预定	
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

	@RequestMapping("/councilreserve/roominfo")
	public String roominfo() {
		return "councilreserve/roominfo";
	}
	
	@RequestMapping("/councilreserve/councilinfo")
	public String councilInfo() {
		return "councilreserve/councilinfo";
	}
	
	@RequestMapping("/councilreserve/councilcancel")
	public String councilCancel() {
		return "councilreserve/councilcancel";
	}
}