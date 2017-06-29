package sse.bjut.council.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sse.bjut.council.service.AccountService;
import sse.bjut.council.util.ResTemp;

@RestController
@RequestMapping(value = "/")
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResTemp loginByPOST(@RequestParam("account") String account,
			@RequestParam("password") String password,
			@RequestParam("privilege") Boolean privilege){
		return loginByGET(account, password, privilege);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ResTemp loginByGET(@RequestParam("account") String account,
			@RequestParam("password") String password,
			@RequestParam("privilege") Boolean privilege) {
		return accountService.login(account, password, privilege);
	}
}