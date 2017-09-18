package br.com.fatec.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.fatec.model.Categoria;
import br.com.fatec.model.EntidadeDominio;
import br.com.fatec.model.Fornecedor;
import br.com.fatec.util.Resultado;

@Repository
@Transactional
public class FornecedorDAO implements IDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	public Resultado salvar(EntidadeDominio entidadeDominio) {
		// TODO Auto-generated method stub
		Fornecedor fornecedor = (Fornecedor) entidadeDominio;
		Categoria categoria = entityManager.find(Categoria.class, fornecedor.getCategoria().getId());
		fornecedor.setCategoria(categoria);
		entityManager.persist(entidadeDominio);
		Resultado resultado = new Resultado();
		resultado.setMensagemSimples("Fornecedor gravado com sucesso");
		return resultado;
	}

	public Resultado alterar(EntidadeDominio entidadeDominio) {
		// TODO Auto-generated method stub	
		Fornecedor fornecedor = (Fornecedor) entidadeDominio;
		Categoria categoria = entityManager.find(Categoria.class, fornecedor.getCategoria().getId());
		fornecedor.setCategoria(categoria);
		entityManager.merge(fornecedor);
		return new Resultado();
	}

	public Resultado excluir(EntidadeDominio entidadeDominio) {
		// TODO Auto-generated method stub
		return null;
	}

	public Resultado consultar(EntidadeDominio entidadeDominio) {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Fornecedor.class);
		Fornecedor fornecedor = (Fornecedor) entidadeDominio;
		if(fornecedor.getId() != 0)
			criteria.add(Restrictions.idEq(fornecedor.getId()));
		else if(fornecedor.getNome() != null && !fornecedor.getNome().isEmpty())
			criteria.add(Restrictions.like("nome", fornecedor.getNome()));
		else if(fornecedor.getCnpj() != null && !fornecedor.getCnpj().isEmpty())
			criteria.add(Restrictions.like("cnpj", fornecedor.getCnpj()));
		else if(fornecedor.getIE() != null && !fornecedor.getIE().isEmpty())
			criteria.add(Restrictions.like("IE", fornecedor.getIE()));
		Resultado resultado = new Resultado();
		resultado.setListaEntidade(criteria.list());
		return resultado;
	}

}
