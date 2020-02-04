package desafioSprint5;

import java.io.IOException;
import java.util.List;
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
		
		sc.close();
	}

	private static int menu(int opcao) {
		switch (opcao) {
		case 1:
			List<Produto> listPessoasTMP = listaProduto.buscarTodos();
			if (listPessoasTMP.isEmpty()) {
				System.out.println("Não existem pessoas cadastradas, pressione uma tecla para continuar!");
				sc.nextLine();
			} else {
				System.out.println(listPessoasTMP.toString());

				System.out.println("Pressione um tecla para continuar.");
				sc.nextLine();
			}

			break;

		case 2:

			break;

		case 3:
			Produto produto = new Produto();

			System.out.print("Digite o código: ");
			produto.setCodigo(Integer.parseInt(sc.nextLine()));

			System.out.print("Digite a descrição: ");
			produto.setDescricao(sc.nextLine());

			System.out.print("Digite Valor: R$ ");
			produto.setValor(Double.parseDouble(sc.nextLine()));
			
			System.out.print("Digite a quantidade: ");
			produto.setQuantidade(Integer.parseInt(sc.nextLine()));

			System.out.println();

			// Guarda o objeto produto em uma lista.
			try {
				cadastraProduto.cadastrarProduto(produto);
			} catch (IOException e) {
				System.out.println("Produto não cadastrado!!" + e.getMessage());
				e.printStackTrace();
			}
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
			try {
				cadastraCliente.cadastrarCliente(cliente);
			} catch (IOException e) {
				System.out.println("Cliente não cadastrado!!" + e.getMessage());
				e.printStackTrace();
			}

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
