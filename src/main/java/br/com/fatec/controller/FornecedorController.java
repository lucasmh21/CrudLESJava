package br.com.fatec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("fornecedor")
public class FornecedorController extends AbstractController{
	 
	@RequestMapping("novo")
	public ModelAndView novo()
	{
		ModelAndView modelAndView = new ModelAndView("fornecedor/novo");
		return modelAndView;
	}
}
