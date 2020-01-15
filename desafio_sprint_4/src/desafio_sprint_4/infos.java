package desafio_sprint_4;

import java.util.Scanner;

public class infos {
	private Scanner sc;

	public infos() {
		this.sc = new Scanner(System.in);
	}
	
	public pessoa pegaInfos( ) {
		pessoa p = new pessoa();
		
		System.out.print("Digite o Código: ");
		p.setCodigo(Integer.parseInt(sc.nextLine()));
		
		System.out.print("Digite o nome: ");
		p.setNome(sc.nextLine());
		
		System.out.print("Digite o endereço: ");
		p.setEndereco(sc.nextLine());
		
		System.out.print("Digite a idade: ");
		p.setIdade(Integer.parseInt(sc.nextLine()));
		
		System.out.println();
		return p;
	}
}
