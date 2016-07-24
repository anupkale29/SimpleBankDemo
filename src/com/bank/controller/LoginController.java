package com.bank.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bank.domain.category.Category;
import com.bank.service.users.IUserService;
import com.bank.utility.EncryptPassword;

@Controller
public class LoginController {

	private IUserService employeeService;
	private EncryptPassword encryptPassword;

	@Autowired
	public LoginController(IUserService employeeService,
			EncryptPassword encryptPassword) {
		this.employeeService = employeeService;
		this.encryptPassword = encryptPassword;
	}

	@RequestMapping(value = "loginpage.json", method = RequestMethod.GET)
	public ModelAndView administratorLogin(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		ModelMap modelMap=new ModelMap();
		List<Category> categories=employeeService.getCategories();
		modelMap.put("categories", categories);
		return new ModelAndView("index",modelMap);
	}
}
