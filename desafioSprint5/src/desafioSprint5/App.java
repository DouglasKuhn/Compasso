package desafioSprint5;

import java.util.Scanner;

import model.Cliente;
import model.Produto;
import service.CadastraCliente;
import service.CadastraProduto;

public class App {
	
	private static Scanner sc = new Scanner(System.in);
	private static CadastraCliente cadastraCliente;
	private static CadastraProduto cadastraProduto;
	
	public static void main(String[] args) {
		int opcao = 0;
		
		do {
			System.out.println("## Escolha uma das opções abaixo ##");
			System.out.println("Opção 1 - Verificar Estoque");
			System.out.println("Opção 2 - Realizar Pedido");
			System.out.println("Opção 3 - Cadastrar Produto");
			System.out.println("Opção 4 - Cadastrar Cliente");
			System.out.println("Opção 5 - Sair");
			System.out.println("___________________________");

			System.out.print("Digite aqui sua opção: ");
			opcao = menu(Integer.parseInt(sc.nextLine()));
		} while (opcao != 5);

	}

	private static int menu(int opcao) {
		switch (opcao) {
		case 1:
			
			break;
		
		case 2:
			
			break;
			
		case 3:
			Produto produto = new Produto();

			System.out.print("Digite o código: ");
			produto.setCodigo(Integer.parseInt(sc.nextLine()));

			System.out.print("Digite o nome: ");
			produto.setDescricao(sc.nextLine());

			System.out.print("Digite o endereço: ");
			produto.setValor(Double.parseDouble(sc.nextLine()));

			System.out.println();

			// Guarda o objeto cliente em uma lista.
			cadastraProduto.cadastrarProduto(produto);
			
			break;
			
		case 4:
			Cliente cliente = new Cliente();

			System.out.print("Digite o código: ");
			cliente.setCodigo(Integer.parseInt(sc.nextLine()));

			System.out.print("Digite o nome: ");
			cliente.setNome(sc.nextLine());

			System.out.print("Digite o endereço: ");
			cliente.setEndereco(sc.nextLine());

			System.out.println();

			// Guarda o objeto cliente em uma lista.
			cadastraCliente.cadastrarCliente(cliente);
			
			break;
			
		case 5:
			System.out.println("Programa Finalizado!");
			break;

		default:
			System.out.println("Codigo Invalido!");
			break;
		}
		return opcao;
	}

}
