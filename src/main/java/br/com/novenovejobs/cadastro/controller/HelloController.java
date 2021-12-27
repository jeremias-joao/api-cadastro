package br.com.novenovejobs.cadastro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	
	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		return "Projeto de Cadastro e Intermediação de Jovens Negro a Acesso"
				+ " de Investimentos Financeiro Privado e Publico";
	}

}
