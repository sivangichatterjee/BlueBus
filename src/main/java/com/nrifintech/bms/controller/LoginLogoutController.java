package com.nrifintech.bms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.nrifintech.bms.request.UserLoginRequest;
import com.nrifintech.bms.service.UserService;


@Controller
public class LoginLogoutController {
	private final UserService userService;

	@Autowired
	public LoginLogoutController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/doLogin")
	public ModelAndView  doLogin(@Valid UserLoginRequest loginRequest, HttpServletRequest request, Model model) {
		boolean isValidUser = userService.isValidUser(loginRequest);
		if (isValidUser) {
			HttpSession session = request.getSession(true);
			session.setAttribute("isValidUser", true);
			model.addAttribute("error", "");
			session.setAttribute("username", loginRequest.getUsername());

			return new ModelAndView(new RedirectView("/dashboard", true));
		} else {
			
			ModelAndView modelAndView = new ModelAndView("login");
			modelAndView.addObject("error", "Invalid Credentials");
			return modelAndView;
		}
	}

	@GetMapping("/logout")
	public String doLogout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/login";
	}

	@RequestMapping("/dashboard")
	public String dashboard() {
		return "dashboard";
	}

}
