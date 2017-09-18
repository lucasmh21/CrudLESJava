package br.com.fatec.fachada;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fatec.dao.CategoriaDAO;
import br.com.fatec.dao.FornecedorDAO;
import br.com.fatec.dao.IDAO;
import br.com.fatec.model.Categoria;
import br.com.fatec.model.EntidadeDominio;
import br.com.fatec.model.Fornecedor;
import br.com.fatec.strategy.IStrategy;
import br.com.fatec.strategy.ValidaCampos;
import br.com.fatec.strategy.ValidaCaracteresStrategy;
import br.com.fatec.strategy.ValidaDataStrategy;
import br.com.fatec.util.Resultado;

@Component
public class Fachada implements IFachada{

	@Autowired
	private FornecedorDAO fornecedorDAO;
	@Autowired
	private CategoriaDAO categoriaDAO;
	private Map<String,IDAO> daos;
	private Map<String, List<IStrategy>> regrasDeNegocio;
	@PostConstruct
	private void postFachada()
	{
		daos = new HashMap<String, IDAO>();
		daos.put(Fornecedor.class.getName(), fornecedorDAO);
		daos.put(Categoria.class.getName(), categoriaDAO);
		
		List<IStrategy> regrasFornecedor = new ArrayList<IStrategy>();
		regrasFornecedor.add(new ValidaDataStrategy());
		regrasFornecedor.add(new ValidaCaracteresStrategy());
		regrasFornecedor.add(new ValidaCampos());
		
		regrasDeNegocio = new HashMap<String, List<IStrategy>>();
		regrasDeNegocio.put(Fornecedor.class.getName(), regrasFornecedor);
	}
	
	public Resultado salvar(EntidadeDominio entidadeDominio) {
		// TODO Auto-generated method stub
		List<IStrategy> regras = regrasDeNegocio.get(entidadeDominio.getClass().getName());
		if(regras != null)
		{
			for(IStrategy r:regras)
			{
				if(!r.processar(entidadeDominio))
				{
					Resultado resultado = new Resultado();
					resultado.setMensagemSimples("Erro durante a validacao");
					return resultado;
				}
			}
		}
		IDAO dao = daos.get(entidadeDominio.getClass().getName());
		Resultado resultado=dao.salvar(entidadeDominio);
		return resultado;
	}

	public Resultado alterar(EntidadeDominio entidadeDominio) {
		// TODO Auto-generated method stub
		List<IStrategy> regras = regrasDeNegocio.get(entidadeDominio.getClass().getName());
		if(regras != null)
		{
			for(IStrategy r:regras)
			{
				if(!r.processar(entidadeDominio))
				{
					Resultado resultado = new Resultado();
					resultado.setMensagemSimples("Erro durante a validacao");
					return resultado;
				}
			}
		}
		IDAO dao = daos.get(entidadeDominio.getClass().getName());
		Resultado resultado=dao.alterar(entidadeDominio);
		return resultado;
	}

	public Resultado excluir(EntidadeDominio entidadeDominio) {
		// TODO Auto-generated method stub
		IDAO dao = daos.get(entidadeDominio.getClass().getName());
		Resultado resultado=dao.excluir(entidadeDominio);
		return resultado;
	}

	public Resultado consultar(EntidadeDominio entidadeDominio) {
		// TODO Auto-generated method stub
		IDAO dao = daos.get(entidadeDominio.getClass().getName());
		Resultado resultado=dao.consultar(entidadeDominio);
		return resultado;
	}

}
