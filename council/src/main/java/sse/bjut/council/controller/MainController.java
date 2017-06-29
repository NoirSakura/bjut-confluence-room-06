package sse.bjut.council.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import sse.bjut.council.service.AccountService;

import sse.bjut.council.entity.ResTemp;

@Controller
@RequestMapping(value = "/")
public class MainController {

	@Autowired
	AccountService accountService;
	
	@RequestMapping("/entry")
    public String index() { 
		return "entry";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
	public ResTemp loginByPOST(@RequestParam("account") String account,
			@RequestParam("password") String password,
			@RequestParam("privilege") Boolean privilege){
		return loginByGET(account, password, privilege);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	@ResponseBody
	public ResTemp loginByGET(@RequestParam("account") String account,
			@RequestParam("password") String password,
			@RequestParam("privilege") Boolean privilege) {
		return accountService.login(account, password, privilege);
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout() {
		ModelAndView mav = new ModelAndView("logout");
		return mav;
	}
	
	@RequestMapping("/selfcenter/index")
	public ModelAndView project() {
		ModelAndView mav = new ModelAndView("selfcenter/index");
		return mav;
	}
	
	@RequestMapping("/selfcenter/mycouncils")
	public ModelAndView myCouncils() {
		ModelAndView mav = new ModelAndView("selfcenter/mycouncils");
		return mav;
	}
	

	@RequestMapping("/selfcenter/myreservations")
	public ModelAndView myReservations() {
		ModelAndView mav = new ModelAndView("selfcenter/myreservations");
		return mav;
	}
}