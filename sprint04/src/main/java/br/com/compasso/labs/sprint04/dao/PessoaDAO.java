package br.com.compasso.labs.sprint04.dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.compasso.labs.sprint04.converter.PessoaConverter;
import br.com.compasso.labs.sprint04.model.Pessoa;
import br.com.compasso.labs.sprint04.service.EscreverLinhaArquivo;
import br.com.compasso.labs.sprint04.service.LerArquivo;
import br.com.compasso.labs.sprint04.service.LerLinhaArquivo;

public class PessoaDAO implements LerLinhaArquivo {

	private static List<Pessoa> pessoas = new ArrayList<Pessoa>();
	private String fileName = "pessoas.txt";
	private static PessoaDAO instance;
	private LerArquivo lerArquivo = new LerArquivo(this);
	private EscreverLinhaArquivo escreverLinhaArquivo = new EscreverLinhaArquivo();

	private PessoaDAO() throws IOException {
		this.lerArquivo.readFile(fileName);
	}
	
	public static synchronized PessoaDAO getInstance() throws IOException {
		if (instance == null) {
			instance = new PessoaDAO();
		}
		return instance;
	}

	public boolean add(Pessoa pessoa) throws IOException {
		escreverLinhaDoArquivo(fileName, PessoaConverter.converterPessoaParaLinhaDoArquivo(pessoa));
		//escreverLinhaArquivo.escreverLinhaDoArquivo(fileName, PessoaConverter.converterPessoaParaLinhaDoArquivo(pessoa));
		return pessoas.add(pessoa);
	}

	public List<Pessoa> findAll() {
		return Collections.unmodifiableList(pessoas);
	}

	public void lerLinhaDoArquivo(String linha) {
		pessoas.add(PessoaConverter.converterLinhaDoArquivoParaPessoa(linha));
	}
	
	public void escreverLinhaDoArquivo(String fileName, String linhaStr) throws IOException {
		boolean existeArquivo = new File(fileName).exists();
		FileWriter fileWriter = new FileWriter(fileName, true);
		PrintWriter printWriter = new PrintWriter(fileWriter, true);
		if (existeArquivo) {
			printWriter.println(linhaStr);
		} else {
			printWriter.print(linhaStr);
		}
		printWriter.close();
		fileWriter.close();
	}

}
