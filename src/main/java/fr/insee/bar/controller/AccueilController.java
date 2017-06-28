package fr.insee.bar.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class AccueilController {


	@GetMapping("/")
	@ResponseStatus(HttpStatus.MOVED_PERMANENTLY)
	public String welcome() {
		return "redirect:/accueil";
	}

	@GetMapping("/accueil")
    @ResponseBody
	public String hello() {
		return "accueil";
	}
}
