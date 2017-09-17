package br.com.fatec.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.fatec.model.EntidadeDominio;
import br.com.fatec.util.Resultado;

@Repository
@Transactional
public class FornecedorDAO implements IDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	public Resultado salvar(EntidadeDominio entidadeDominio) {
		// TODO Auto-generated method stub
		entityManager.persist(entidadeDominio);
		Resultado resultado = new Resultado();
		resultado.setMensagemSimples("Fornecedor gravado com sucesso");
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
