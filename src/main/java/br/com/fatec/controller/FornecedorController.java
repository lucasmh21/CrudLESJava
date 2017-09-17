package br.com.fatec.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.fatec.model.Fornecedor;
import br.com.fatec.util.Resultado;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController extends AbstractController{
	 
	@RequestMapping("/novo")
	public ModelAndView novo(Fornecedor fornecedor)
	{
		modelAndView = new ModelAndView("fornecedor/novo");
		return modelAndView;
	}
	@RequestMapping(value="/criar", method=RequestMethod.POST)
	public ModelAndView criar(Fornecedor fornecedor)
	{
		modelAndView = new ModelAndView("fornecedor/lista");
		Resultado resultado = commandSalvar.executar(fornecedor);
		modelAndView.addObject("mensagem", resultado.getMensagemSimples());
		return modelAndView;
	}
}
