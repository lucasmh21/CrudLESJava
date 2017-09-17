package br.com.fatec.command;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.fatec.fachada.Fachada;

public abstract class AbstractCommand {
	@Autowired
	protected Fachada fachada;
}
