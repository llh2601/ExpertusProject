package ca.expertus.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class MainController {
	@GetMapping("/")
	public String Show(Model model) {
		
		return "Home";
	}

}
