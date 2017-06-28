package fr.insee.tdd.controller;

import fr.insee.tdd.model.Publication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PublicationController {

	@GetMapping("/publication/{id}")
    @ResponseBody
	public Publication publication(@PathVariable("id") Publication publication) {
		return publication;
	}
}
