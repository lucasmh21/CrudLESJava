package br.com.fatec.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.fatec.model.Categoria;
import br.com.fatec.model.Fornecedor;
import br.com.fatec.util.Resultado;

@Controller
@RequestMapping("/categoria")
public class CategoriaController extends AbstractController{
	@RequestMapping("/novo")
	public ModelAndView novo(Categoria categoria)
	{
		modelAndView = new ModelAndView("categoria/novo");
		return modelAndView;
	}
	@RequestMapping(value="/criar", method=RequestMethod.POST)
	public ModelAndView criar(Categoria categoria)
	{
		modelAndView = new ModelAndView();
		Resultado resultado = commandSalvar.executar(categoria);
		modelAndView.addObject("mensagem", resultado.getMensagemSimples());
		return listar();
	}
	
	@RequestMapping("/listar")
	public ModelAndView listar()
	{
		modelAndView = new ModelAndView("categoria/listar");
		Resultado resultado = commandConsultar.executar(new Categoria());
		modelAndView.addObject("listaCategoria", resultado.getListaEntidade());
		return modelAndView;
	}
	@RequestMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable Integer id)
	{
		modelAndView = new ModelAndView("categoria/editar");
		Categoria categoria = new Categoria();
		categoria.setId(id);
		Resultado resultado = commandConsultar.executar(categoria);
		modelAndView.addObject("categoria", resultado.getListaEntidade().get(0));
		return modelAndView;
	}
	@RequestMapping(value="editar/acao", params="alterar", method=RequestMethod.POST)
	public ModelAndView alterar(Categoria categoria)
	{
		modelAndView = new ModelAndView();
		Resultado resultado = commandAlterar.executar(categoria);
		modelAndView.addObject("mensagem", resultado.getMensagemSimples());
		return listar();
	}
	@RequestMapping(value="editar/acao", params="excluir", method=RequestMethod.POST)
	public ModelAndView excluir(Categoria categoria)
	{
		modelAndView = new ModelAndView();
		Resultado resultado = commandExcluir.executar(categoria);
		modelAndView.addObject("mensagem", resultado.getMensagemSimples());
		return listar();
	}
	
	public List<Categoria> obterCategorias()
	{
		return null;
	}
}
