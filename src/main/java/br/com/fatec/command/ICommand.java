package br.com.fatec.command;

import br.com.fatec.model.EntidadeDominio;
import br.com.fatec.util.Resultado;

public interface ICommand {
		public Resultado executar(EntidadeDominio entidadeDominio);
}
