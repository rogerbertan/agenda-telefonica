package com.bertan.agenda_telefonica;

import com.bertan.agenda_telefonica.model.Contato;
import com.bertan.agenda_telefonica.service.ContatoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class AgendaTelefonicaApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(AgendaTelefonicaApplication.class, args);
		ContatoService contatoService = context.getBean(ContatoService.class);
	}
}
