package sse.bjut.council.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import sse.bjut.council.dao.StaffInfoDao;
import sse.bjut.council.dao.DepartInfoDao;

import sse.bjut.council.entity.Staff;
import sse.bjut.council.entity.Depart;

@RestController
@RequestMapping(value = "/")
public class MainController {

	@Autowired 
	StaffInfoDao staffInfoDao;
	
	@Autowired 
	DepartInfoDao departInfoDao;
	
	@RequestMapping("/index")
    public String index() { 
		Depart info = new Depart();
		info.setDepartName("124");
		info.setManagerID(124);
		//departInfoDao.save(info);;
		return departInfoDao.findByDepartName("123").toString() +
				departInfoDao.findByManagerID(124); 
		}
	
	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout() {
		ModelAndView mav = new ModelAndView("logout");
		return mav;
	}
}