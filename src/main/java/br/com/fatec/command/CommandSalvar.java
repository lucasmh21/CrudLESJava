package br.com.fatec.command;

import org.springframework.stereotype.Component;

import br.com.fatec.model.EntidadeDominio;
import br.com.fatec.util.Resultado;

@Component
public class CommandSalvar extends AbstractCommand implements ICommand{

	public Resultado executar(EntidadeDominio entidadeDominio) {
		// TODO Auto-generated method stub
		return fachada.salvar(entidadeDominio);
	}

}
