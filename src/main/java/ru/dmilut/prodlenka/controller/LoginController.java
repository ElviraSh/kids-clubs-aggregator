package ru.dmilut.prodlenka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

import java.io.IOException;

@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@ExceptionHandler(IOException.class)
	public ModelAndView handleIOException(IOException exception) {
		ModelAndView modelAndView = new ModelAndView("/exception/catchedException");
		modelAndView.addObject("message", exception.getMessage());
		return modelAndView;
	}

}
