package sse.bjut.council.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import sse.bjut.council.service.DepartService;

@Controller
@RequestMapping(value = "/departmanage")
public class DepartController {
	
	@Autowired
	DepartService departService;
	
	@RequestMapping(value = "/adddepart", method = RequestMethod.POST)
	public ModelAndView addDepartByPOST(@RequestBody String depart_name){
		return addDepartByGET(depart_name);
	}
	
	@RequestMapping(value = "/adddepart", method = RequestMethod.GET)
	public ModelAndView addDepartByGET(@RequestParam("depart_name") String depart_name) {
		ModelAndView mav = new ModelAndView("/adddepart");
		mav.getModel().put("exe_code", departService.addDepart(depart_name));
		return mav;
	}
}
