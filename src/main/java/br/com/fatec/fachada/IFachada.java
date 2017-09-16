package br.com.fatec.fachada;

import br.com.fatec.model.EntidadeDominio;
import br.com.fatec.util.Resultado;

public interface IFachada {
	public Resultado salvar(EntidadeDominio entidadeDominio);
	public Resultado alterar(EntidadeDominio entidadeDominio);
	public Resultado excluir(EntidadeDominio entidadeDominio);
	public Resultado consultar(EntidadeDominio entidadeDominio);
}
