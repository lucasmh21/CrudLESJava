package br.com.fatec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FornecedorController extends AbstractController{
	 
	@RequestMapping("/")
	public ModelAndView novo()
	{
		ModelAndView modelAndView = new ModelAndView("fornecedor/novo");
		return modelAndView;
	}
}
