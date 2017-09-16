package br.com.fatec.configuracao;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import br.com.fatec.controller.AbstractController;

@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@ComponentScan(basePackageClasses={AbstractController.class,WebMvcConfiguration.class})
public class Aplicacao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(Aplicacao.class, args);
	}

}
