package br.com.fatec.strategy;

import br.com.fatec.model.EntidadeDominio;
import br.com.fatec.util.Resultado;

public interface IStrategy {
	public boolean processar(EntidadeDominio entidadeDominio);
}
