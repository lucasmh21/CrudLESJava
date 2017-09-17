package br.com.fatec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import br.com.fatec.command.CommandAlterar;
import br.com.fatec.command.CommandConsultar;
import br.com.fatec.command.CommandExcluir;
import br.com.fatec.command.CommandSalvar;

public abstract class AbstractController {
	protected ModelAndView modelAndView;
	
	@Autowired
	protected CommandAlterar commandAlterar;
	@Autowired
	protected CommandConsultar commandConsultar;
	@Autowired
	protected CommandExcluir commandExcluir;
	@Autowired
	protected CommandSalvar commandSalvar;
}
