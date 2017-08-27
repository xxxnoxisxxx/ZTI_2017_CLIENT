package com.zti.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Kontroler przeznaczony dla użytkowników z rolą ROLE_USER
 * 
 * @author PawełN
 *
 */
@Controller
public class HomeController {

	/**
	 * Widok strony głównej
	 * 
	 * @param model
	 *            Widok modelu
	 * @return Strona główna
	 */
	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String welcome(Model model) {
		return "home";
	}

}
