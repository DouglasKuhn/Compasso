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
			System.out.println("## Escolha uma das op��es abaixo ##");
			System.out.println("Op��o 1 - Cadastrar pessoas");
			System.out.println("Op��o 2 - Imprime pessoas cadastradas");
			System.out.println("Op��o 0 - Sair do programa");
			System.out.println("_______________________");
			System.out.print("Digite aqui sua op��o: ");
			
			x = Integer.parseInt(sc.nextLine());
			
			System.out.println();
			
			switch (x) {
			case 1:
				System.out.println("## Inclus�o de Pessoa ##");
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
				System.out.println("## Op��o invalida, tente novamente! ##");
				break;
			}
			
		}
		
		sc.close();
		
	}

}
