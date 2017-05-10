package ru.dmilut.prodlenka.controller;

import java.io.IOException;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.portlet.ModelAndView;
import ru.dmilut.prodlenka.entity.User;
import ru.dmilut.prodlenka.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@ModelAttribute("user")
	public User constructUser() {
		return new User();
	}

	@RequestMapping("/users")
	public String users(Model model) {
		model.addAttribute("users", userService.findAll());
		return "users";
	}

	@RequestMapping("/users/{id}")
	public String detail(Model model, @PathVariable long id) {
		model.addAttribute("user", userService.findOneWithUnits(id));
		return "user-detail";
	}

	/*
	 * @RequestMapping("/register") public String showRegistrer() { return
	 * "user-register"; }
	 * 
	 * @RequestMapping(value = "/register", method = RequestMethod.POST) public
	 * String doRegistrer(@ModelAttribute("user") User user) {
	 * userService.save(user); return "redirect:/register.html?success=true"; }
	 */

	@RequestMapping("/account")
	public String account(Model model, Principal principal) {
		String name = principal.getName();
		model.addAttribute("user", userService.findOneWithUnits(name));
		return "user-detail";
	}

	@RequestMapping("/user/remove/{id}")
	public String removeUser(@PathVariable long id, Principal principal) {
		String name = principal.getName();
		if (name.equals("admin")) {
			userService.delete(id);
		}
		return "redirect:/users.html";
	}
	@ExceptionHandler(IOException.class)
	public ModelAndView handleIOException(IOException exception) {
		ModelAndView modelAndView = new ModelAndView("/exception/catchedException");
		modelAndView.addObject("message", exception.getMessage());
		return modelAndView;
	}

}
