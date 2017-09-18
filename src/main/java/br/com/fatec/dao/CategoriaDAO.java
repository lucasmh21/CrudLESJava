package br.com.fatec.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.fatec.model.Categoria;
import br.com.fatec.model.EntidadeDominio;
import br.com.fatec.util.Resultado;

@Repository
@Transactional
public class CategoriaDAO implements IDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	public Resultado salvar(EntidadeDominio entidadeDominio) {
		// TODO Auto-generated method stub
		entityManager.persist(entidadeDominio);
		Resultado resultado = new Resultado();
		resultado.setMensagemSimples("Categoria cadastrada com suceso!");
		return resultado;
	}

	public Resultado alterar(EntidadeDominio entidadeDominio) {
		// TODO Auto-generated method stub
		entityManager.merge(entidadeDominio);
		Resultado resultado = new Resultado();
		resultado.setMensagemSimples("Categoria atualizada com sucesso!");
		return resultado;
	}

	public Resultado excluir(EntidadeDominio entidadeDominio) {
		// TODO Auto-generated method stub
		Categoria categoria = (Categoria) entidadeDominio;
		entidadeDominio = entityManager.merge(categoria);
		entityManager.remove(entidadeDominio);
		Resultado resultado = new Resultado();
		resultado.setMensagemSimples("Categoria excluida com sucesso!");
		return resultado;
	}

	public Resultado consultar(EntidadeDominio entidadeDominio) {
		// TODO Auto-generated method stub
		Categoria categoria = (Categoria) entidadeDominio;
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Categoria.class);
		if(categoria.getId() != 0)
			criteria.add(Restrictions.idEq(categoria.getId()));
		Resultado resultado = new Resultado();
		resultado.setListaEntidade(criteria.list());
		return resultado;
	}

}
