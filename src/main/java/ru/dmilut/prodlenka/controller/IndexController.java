package ru.dmilut.prodlenka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.portlet.ModelAndView;
import ru.dmilut.prodlenka.entity.User;
import ru.dmilut.prodlenka.service.UserService;

import java.io.IOException;

@Controller
public class IndexController {

	@Autowired
	private UserService userService;

	@ModelAttribute("user")
	public User constructUser() {
		return new User();
	}

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public String doRegistrer(@ModelAttribute("user") User user) {
		userService.save(user);
		return "redirect:/index.html";
	}
	@ExceptionHandler(IOException.class)
	public ModelAndView handleIOException(IOException exception) {
		ModelAndView modelAndView = new ModelAndView("/exception/catchedException");
		modelAndView.addObject("message", exception.getMessage());
		return modelAndView;
	}

}
