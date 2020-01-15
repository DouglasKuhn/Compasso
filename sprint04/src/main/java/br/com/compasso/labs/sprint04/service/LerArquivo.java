package br.com.compasso.labs.sprint04.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LerArquivo {
	
	private LerLinhaArquivo lerLinhaArquivo;
	
	public LerArquivo(LerLinhaArquivo lerLinhaArquivo) {
		this.lerLinhaArquivo = lerLinhaArquivo;
	}
	
	public void readFile(String fileName) throws IOException {
		if (new File(fileName).exists()) {
			FileReader reader = new FileReader(fileName);
			BufferedReader br = new BufferedReader(reader);
			String linha;
			while ((linha = br.readLine()) != null) {
				this.lerLinhaArquivo.lerLinhaDoArquivo(linha);
			}
			br.close();
			reader.close();
		}

	}

}
