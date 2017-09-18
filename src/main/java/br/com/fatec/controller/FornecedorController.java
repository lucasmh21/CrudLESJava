package br.com.fatec.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fatec.model.Categoria;
import br.com.fatec.model.EntidadeDominio;
import br.com.fatec.model.Fornecedor;
import br.com.fatec.util.Resultado;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController extends AbstractController{
	 
	@RequestMapping("/novo")
	public ModelAndView novo(Fornecedor fornecedor)
	{
		modelAndView = new ModelAndView("fornecedor/novo");
		modelAndView.addObject("listaCategoria", obterCategorias());
		return modelAndView;
	}
	@RequestMapping(value="/criar", method=RequestMethod.POST)
	public ModelAndView criar(Fornecedor fornecedor,RedirectAttributes rm)
	{
		modelAndView = new ModelAndView("redirect:listar");
		Categoria categoria = new Categoria();
		categoria.setId(fornecedor.getCategoria().getId());
		Resultado resultadoCategoria = commandConsultar.executar(categoria);
		categoria = (Categoria) resultadoCategoria.getListaEntidade().get(0);
		fornecedor.setCategoria(categoria);
		Resultado resultado = commandSalvar.executar(fornecedor);
		rm.addFlashAttribute("mensagem", resultado.getMensagemSimples());
		return modelAndView;
	}
	
	@RequestMapping("/listar")
	public ModelAndView listar()
	{
		modelAndView = new ModelAndView("fornecedor/listar");
		Resultado resultado = commandConsultar.executar(new Fornecedor());
		modelAndView.addObject("listaFornecedor", resultado.getListaEntidade());
		return modelAndView;
	}
	@RequestMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable Integer id)
	{
		modelAndView = new ModelAndView("fornecedor/editar");
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setId(id);
		Resultado resultado = commandConsultar.executar(fornecedor);
		modelAndView.addObject("fornecedor", resultado.getListaEntidade().get(0));
		modelAndView.addObject("listaCategoria", obterCategorias());
		return modelAndView;
	}
	@RequestMapping("/alterar")
	public ModelAndView alterar(Fornecedor fornecedor,RedirectAttributes rm)
	{
		modelAndView = new ModelAndView("redirect:listar");
		Categoria categoria = new Categoria();
		categoria.setId(fornecedor.getCategoria().getId());
		Resultado resultadoCategoria = commandConsultar.executar(categoria);
		categoria = (Categoria) resultadoCategoria.getListaEntidade().get(0);
		fornecedor.setCategoria(categoria);
		Resultado resultado = commandAlterar.executar(fornecedor);
		rm.addFlashAttribute("mensagem", resultado.getMensagemSimples());
		return modelAndView;
	}
	
	@RequestMapping("/pesquisar")
	public ModelAndView pesquisar(Fornecedor fornecedor)
	{
		modelAndView = new ModelAndView("fornecedor/pesquisar");
		modelAndView.addObject("listaCategoria", obterCategorias());
		return modelAndView;
	}
	
	@RequestMapping("/listarComFiltro")
	public ModelAndView listarComFiltro(Fornecedor fornecedor)
	{
		modelAndView = new ModelAndView("fornecedor/listar");
		Resultado resultado = commandConsultar.executar(fornecedor);
		modelAndView.addObject("listaFornecedor", resultado.getListaEntidade());
		return modelAndView;
	}
	
	private List<EntidadeDominio> obterCategorias()
	{
		Resultado resultado = commandConsultar.executar(new Categoria());
		return resultado.getListaEntidade();
	}
}
