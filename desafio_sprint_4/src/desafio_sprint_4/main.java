package desafio_sprint_4;

import java.io.IOException;
import java.util.Scanner;

public class main {

	public static void main(String[] args) throws IOException {

		int x = 777;
		Scanner sc = new Scanner(System.in);
		infos i = new infos();
		pessoa p = new pessoa();
		arqs arq = new arqs();
		
		while(x != 0) {
			System.out.println("## Escolha uma das opções abaixo ##");
			System.out.println("Opção 1 - Cadastrar pessoas");
			System.out.println("Opção 2 - Imprime pessoas cadastradas");
			System.out.println("Opção 0 - Sair do programa");
			System.out.println("_______________________");
			System.out.print("Digite aqui sua opção: ");
			
			x = Integer.parseInt(sc.nextLine());
			
			System.out.println();
			
			switch (x) {
			case 1:
				System.out.println("## Inclusão de Pessoa ##");
				p = i.pegaInfos();
				arq.escrever(p);
				break;

			case 2:
				System.out.println("## Exibir Lista de Pessoas ##");
				arq.ler();
				break;
				
			case 0:
				System.out.println("## Sair ##");
				break;
				
			default:
				System.out.println("## Opção invalida, tente novamente! ##");
				break;
			}
			
		}
		
		sc.close();
		
	}

}
