package com.example.SportyShoes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.SportyShoes.entities.User;
import com.example.SportyShoes.services.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcomePage(ModelMap model) {
		return showLogin(model);
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLogin(ModelMap model) {
		model.addAttribute("message", "Welcome!");
		return ("login");
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String handleLogin(@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "password", required = true) String password,

			ModelMap model) {

		User user;
		try {

			user = userService.GetUserByName(username);
		} catch (Exception ex) {
			model.addAttribute("message", "ERROR: Unknown user!");
			return ("login");
		}
		if (userService.ConfirmUserPassword(user, password)) {
			// TODO: Check user and password
			// model.addAttribute("user", user);
			model.addAttribute("message", "Success!");
			return ("login");
		} else {
			model.addAttribute("message", "Invalid Password, Try again!");
			return ("login");
		}
	}
}