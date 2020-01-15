package br.com.compasso.labs.sprint04;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import br.com.compasso.labs.sprint04.model.Pessoa;
import br.com.compasso.labs.sprint04.service.CadastraPessoa;
import br.com.compasso.labs.sprint04.service.ListaPessoa;

/**
 * Hello world!
 *
 */
public class App {
	
	private static Scanner sc = new Scanner(System.in);
	private static CadastraPessoa cadastraPessoa;
	private static ListaPessoa listaPessoa;
	
	public static void main(String[] args) throws IOException {
		cadastraPessoa = new CadastraPessoa();
		listaPessoa = new ListaPessoa();
		int opcao = 0;
		
		System.out.println(getSystemTitle());
		do {
			System.out.println("## Escolha uma das opções abaixo ##");
			System.out.println("Opção 1 - Cadastra pessoas");
			System.out.println("Opção 2 - Imprime pessoas cadastradas");
			System.out.println("Opção 0 - Sair do programa");
			System.out.println("_______________________");

			System.out.print("Digite aqui sua opção: ");
			opcao = menu(Integer.parseInt(sc.nextLine()));
		} while (opcao != 0);

		sc.close();
	}
	
	private static int menu(int opcao) throws IOException {
		switch (opcao) {
		case 1:
			Pessoa pessoa = new Pessoa();

			System.out.print("Digite o código: ");
			pessoa.setCodigo(Integer.parseInt(sc.nextLine()));

			System.out.print("Digite o nome: ");
			pessoa.setNome(sc.nextLine());

			System.out.print("Digite o endereço: ");
			pessoa.setEndereco(sc.nextLine());

			System.out.print("Digite a idade: ");
			pessoa.setIdade(Integer.parseInt(sc.nextLine()));

			System.out.println();

			// Guarda o objeto pessoa em uma lista.
			cadastraPessoa.cadastrarPessoa(pessoa);
			
			break;
		case 2:
			List<Pessoa> listPessoasTMP = listaPessoa.buscarTodos();
			if (listPessoasTMP.isEmpty()) {
				System.out.println("Não existem pessoas cadastradas, pressione uma tecla para continuar!");
				sc.nextLine();
			} else {
				System.out.println(listPessoasTMP.toString());

				System.out.println("Pressione um tecla para continuar.");
				sc.nextLine();
			}
			break;
		default:
			break;
		}
		return opcao;
	}
	
	private static String getSystemTitle() {
		StringBuffer titleBuffer = new StringBuffer();
		titleBuffer.append("  ______                                                                                 __                  __                 \n");
		titleBuffer.append(" /      \\                                                                               /  |                /  |                \n");
		titleBuffer.append("/$$$$$$  |  ______   _____  ____    ______   ______    _______  _______   ______        $$ |        ______  $$ |____    _______ \n");
		titleBuffer.append("$$ |  $$/  /      \\ /     \\/    \\  /      \\ /      \\  /       |/       | /      \\       $$ |       /      \\ $$      \\  /       |\n");
		titleBuffer.append("$$ |      /$$$$$$  |$$$$$$ $$$$  |/$$$$$$  |$$$$$$  |/$$$$$$$//$$$$$$$/ /$$$$$$  |      $$ |       $$$$$$  |$$$$$$$  |/$$$$$$$/ \n");
		titleBuffer.append("$$ |   __ $$ |  $$ |$$ | $$ | $$ |$$ |  $$ |/    $$ |$$      \\$$      \\ $$ |  $$ |      $$ |       /    $$ |$$ |  $$ |$$      \\ \n");
		titleBuffer.append("$$ \\__/  |$$ \\__$$ |$$ | $$ | $$ |$$ |__$$ /$$$$$$$ | $$$$$$  |$$$$$$  |$$ \\__$$ |      $$ |_____ /$$$$$$$ |$$ |__$$ | $$$$$$  |\n");
		titleBuffer.append("$$    $$/ $$    $$/ $$ | $$ | $$ |$$    $$/$$    $$ |/     $$//     $$/ $$    $$/       $$       |$$    $$ |$$    $$/ /     $$/ \n");
		titleBuffer.append(" $$$$$$/   $$$$$$/  $$/  $$/  $$/ $$$$$$$/  $$$$$$$/ $$$$$$$/ $$$$$$$/   $$$$$$/        $$$$$$$$/  $$$$$$$/ $$$$$$$/  $$$$$$$/\n");
		titleBuffer.append("                                  $$ |   \n");                                                                                      
		titleBuffer.append("                                  $$ |   \n");
		titleBuffer.append("                                  $$/\n");
		return titleBuffer.toString();
	}
}
