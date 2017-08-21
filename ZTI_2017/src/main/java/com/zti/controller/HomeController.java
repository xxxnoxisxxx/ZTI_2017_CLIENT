package com.zti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.zti.service.UserService;

@Controller
public class HomeController {
	@Autowired
	private UserService userService;
	
    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }

        @RequestMapping(value = {"/admin"}, method = RequestMethod.GET)
        public String admin(Model model) {
        	List<String> users = userService.getAllLoggedUsers();
        	model.addAttribute("loggedUserList", users);
            return "admin";
        }

}
