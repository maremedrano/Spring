package com.generation.habilidades.controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/habilidades")

public class HabilidadesControler {
	
	@GetMapping
	public String habilidades() {
		return "Para realizar essa atividade, fiz uso do trabalho em equipe e da persistência.";
	}

}
