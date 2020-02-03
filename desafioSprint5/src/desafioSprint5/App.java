package desafioSprint5;

import java.io.IOException;
import java.util.Scanner;

import model.Cliente;
import model.Produto;
import service.CadastraCliente;
import service.CadastraProduto;
import service.ListaCliente;
import service.ListaProduto;

public class App {

	private static Scanner sc = new Scanner(System.in);
	private static CadastraCliente cadastraCliente;
	private static CadastraProduto cadastraProduto;
	private static ListaCliente listaCliente;
	private static ListaProduto listaProduto;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int opcao = 0;
		cadastraCliente = new CadastraCliente();
		cadastraProduto = new CadastraProduto();
		listaCliente = new ListaCliente();
		listaProduto = new ListaProduto();

		do {
			System.out.println("## Escolha uma das op��es abaixo ##");
			System.out.println("Op��o 1 - Verificar Estoque");
			System.out.println("Op��o 2 - Realizar Pedido");
			System.out.println("Op��o 3 - Cadastrar Produto");
			System.out.println("Op��o 4 - Cadastrar Cliente");
			System.out.println("Op��o 5 - Sair");
			System.out.println("___________________________");

			System.out.print("Digite aqui sua op��o: ");
			opcao = menu(Integer.parseInt(sc.nextLine()));
		} while (opcao != 5);
		
		sc.close();
	}

	private static int menu(int opcao) {
		switch (opcao) {
		case 1:

			break;

		case 2:

			break;

		case 3:
			Produto produto = new Produto();

			System.out.print("Digite o c�digo: ");
			produto.setCodigo(Integer.parseInt(sc.nextLine()));

			System.out.print("Digite o nome: ");
			produto.setDescricao(sc.nextLine());

			System.out.print("Digite o endere�o: ");
			produto.setValor(Double.parseDouble(sc.nextLine()));

			System.out.println();

			// Guarda o objeto produto em uma lista.
			CadastraProduto.cadastrarProduto(produto);

			break;

		case 4:
			Cliente cliente = new Cliente();

			System.out.print("Digite o c�digo: ");
			cliente.setCodigo(Integer.parseInt(sc.nextLine()));

			System.out.print("Digite o nome: ");
			cliente.setNome(sc.nextLine());

			System.out.print("Digite o endere�o: ");
			cliente.setEndereco(sc.nextLine());

			System.out.println();

			// Guarda o objeto cliente em uma lista.
//			cadastra.cadastrar(cliente);

			break;

		case 5:
			System.out.println("Programa Finalizado!");
			break;

		default:
			System.out.println("Codigo Invalido!");
			break;
		}
		System.out.println(opcao);
		return opcao;
	}

}
