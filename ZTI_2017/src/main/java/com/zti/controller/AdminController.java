package com.zti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zti.model.User;
import com.zti.service.UserService;
import com.zti.validator.EditUserValidator;

@Controller
@RequestMapping("/admin/*")
public class AdminController {
	@Autowired
	private UserService userService;
	@Autowired
	private EditUserValidator userValidator;

	@RequestMapping(value = "users", method = RequestMethod.GET)
	public String admin(Model model) {
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		return "admin/users";
	}

	@RequestMapping(value = "user/edit/{id}", method = RequestMethod.GET)
	public String getUser(@PathVariable("id") Long id, Model model) {
		User user = userService.findById(id);
		model.addAttribute("userForm", user);
		return "admin/editUser";
	}

	@RequestMapping(value = "/user/edit/{id}", method = RequestMethod.POST)
	public String editUser(@ModelAttribute("userForm") User userForm, @PathVariable("id") Long id,
			BindingResult bindingResult, Model model) {

		// Long id = userForm.getId();
		User user = userService.findById(id);

		userValidator.validate(userForm, bindingResult);

		if (bindingResult.hasErrors()) {
			return "redirect:/admin/user/edit/" + id.toString();
		}

		user.setFirstname(userForm.getFirstname());
		user.setLastname(userForm.getLastname());
		user.setEmail(userForm.getEmail());
		user.setUsername(userForm.getUsername());

		userService.save(user);

		return "redirect:/admin/users";
	}

	@RequestMapping(value = "/user/delete", method = RequestMethod.DELETE)
	public @ResponseBody void deleteUser(@PathVariable("id") Long id, Model model) {

		userService.deleteById(id);

	}

}
