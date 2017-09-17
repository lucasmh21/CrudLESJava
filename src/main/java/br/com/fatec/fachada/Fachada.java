package br.com.fatec.fachada;


import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fatec.dao.FornecedorDAO;
import br.com.fatec.dao.IDAO;
import br.com.fatec.model.EntidadeDominio;
import br.com.fatec.model.Fornecedor;
import br.com.fatec.util.Resultado;

@Component
public class Fachada implements IFachada{

	@Autowired
	private FornecedorDAO fornecedorDAO;
	private Map<String,IDAO> daos;
	
	@PostConstruct
	private void postFachada()
	{
		daos = new HashMap<String, IDAO>();
		daos.put(Fornecedor.class.getName(), fornecedorDAO);
	}
	
	public Resultado salvar(EntidadeDominio entidadeDominio) {
		// TODO Auto-generated method stub
		IDAO dao = daos.get(entidadeDominio.getClass().getName());
		Resultado resultado=dao.salvar(entidadeDominio);
		return resultado;
	}

	public Resultado alterar(EntidadeDominio entidadeDominio) {
		// TODO Auto-generated method stub
		return null;
	}

	public Resultado excluir(EntidadeDominio entidadeDominio) {
		// TODO Auto-generated method stub
		return null;
	}

	public Resultado consultar(EntidadeDominio entidadeDominio) {
		// TODO Auto-generated method stub
		return null;
	}

}
