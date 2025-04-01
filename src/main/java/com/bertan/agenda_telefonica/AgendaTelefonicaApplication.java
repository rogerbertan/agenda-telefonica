package com.bertan.agenda_telefonica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class AgendaTelefonicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgendaTelefonicaApplication.class, args);
		Scanner scanner = new Scanner(System.in);
		Agenda agenda = new Agenda();

		int opcao;
		do {
			System.out.println("\nMENU");
			System.out.println("1 - Adicionar contato");
			System.out.println("2 - Listar contatos");
			System.out.println("3 - Remover contato");
			System.out.println("4 - Sair");
			System.out.print("Escolha uma opção: ");

			while (!scanner.hasNextInt()) {
				System.out.println("Por favor, digite um número válido.");
				scanner.next();
			}
			opcao = scanner.nextInt();
			scanner.nextLine();

			switch (opcao) {
				case 1:
					System.out.print("Digite o nome do contato: ");
					String nome = scanner.nextLine().trim();
					System.out.print("Digite o número do contato: ");
					String telefone = scanner.nextLine().trim();
					agenda.adicionarContato(new Contato(nome, telefone));
					System.out.println("Contato adicionado com sucesso!");
					break;
				case 2:
					System.out.println("\nLista de contatos:");
					if (agenda.listarContatos().isEmpty()) {
						System.out.println("Nenhum contato cadastrado.");
					} else {
						for (Contato c : agenda.listarContatos()) {
							System.out.println("Nome: " + c.getNome() + ", Telefone: " + c.getTelefone());
						}
					}
					break;
				case 3:
					System.out.print("Digite o nome do contato a ser removido: ");
					String nomeRemover = scanner.nextLine().trim();
					if (agenda.removerContato(nomeRemover)) {
						System.out.println("Contato removido com sucesso!");
					} else {
						System.out.println("Contato não encontrado.");
					}
					break;
				case 4:
					System.out.println("Saindo do programa...");
					break;
				default:
					System.out.println("Opção inválida! Tente novamente.");
			}
		} while (opcao != 4);

		scanner.close();
	}
}
