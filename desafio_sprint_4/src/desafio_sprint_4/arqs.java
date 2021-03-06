package desafio_sprint_4;

import java.io.*;

public class arqs {

	public void escrever(pessoa p) throws IOException {
		OutputStream fos = new FileOutputStream("Pessoas.txt", true);
        Writer osw = new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(osw);
		
        bw.append(p.getCodigo() + ";" + p.getNome() + ";" + p.getEndereco() + ";" + p.getIdade() +"\n");

        bw.close();
	}
	
	public void ler() throws IOException {
		InputStream fis = new FileInputStream("Pessoas.txt");
        Reader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);

        String linha = br.readLine();

        while (linha != null) {
        	String infos[] = linha.split(";");
            System.out.println("C�digo: " + infos[0]);
            System.out.println("Nome: " + infos[1]);
            System.out.println("Endere�o: " + infos[2]);
            System.out.println("Idade: " + infos[3] + "\n");
            
            linha = br.readLine();
        }

        br.close();
	}
}
